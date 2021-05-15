package br.com.capegemini.advertising.controller;

import br.com.capegemini.advertising.dto.AdRequestDto;
import br.com.capegemini.advertising.dto.AdResponseDto;
import br.com.capegemini.advertising.exception.EndDateException;
import br.com.capegemini.advertising.service.AdService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.time.LocalDate;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/ads")
public class AdController {

    private final AdService adService;

    public AdController(AdService adService) {
        this.adService = adService;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid AdRequestDto adRequestDto,
                                    UriComponentsBuilder uriComponentsBuilder) throws EndDateException {

        if (adRequestDto.getStartDate().isAfter(adRequestDto.getEndDate())) {

            throw new EndDateException("Data de término do anúncio não pode ser anterior à data de início.");
        }
        var createdAd = adService.create(adRequestDto);
        URI location = uriComponentsBuilder
                .path("/api/v1/ads/{id}")
                .buildAndExpand(createdAd.getId())
                .toUri();

        return ResponseEntity.created(location).body(new AdResponseDto(createdAd));
    }

    @GetMapping
    public ResponseEntity<?> getReport(@RequestParam Optional<String> client,
                                       @RequestParam Optional<String> startDate) {

        return ResponseEntity.ok(
                client.map(c -> ResponseEntity.ok(adService.findAll()
                        .stream()
                        .filter(ad -> ad.getClient().equals(c))
                        .map(it -> adService.buildReport(it.getId()))
                        .collect(Collectors.toList())))
                        .or(() -> startDate.map(s -> ResponseEntity.ok(adService.findAll()
                                .stream()
                                .filter(ad -> ad.getStartDate().toString().equals(LocalDate.parse(s).toString()))
                                .map(it -> adService.buildReport(it.getId()))
                                .collect(Collectors.toList()))))
                        .orElse(ResponseEntity.ok(adService.findAll()
                                .stream()
                                .map(it -> adService.buildReport(it.getId()))
                                .collect(Collectors.toList()))).getBody());
    }
}
