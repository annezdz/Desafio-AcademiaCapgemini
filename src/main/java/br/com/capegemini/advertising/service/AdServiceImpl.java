package br.com.capegemini.advertising.service;

import br.com.capegemini.advertising.dto.AdRequestDto;
import br.com.capegemini.advertising.dto.ReportDto;
import br.com.capegemini.advertising.exception.AdNotFoundException;
import br.com.capegemini.advertising.model.Ad;
import br.com.capegemini.advertising.repository.AdRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

@Service
public class AdServiceImpl implements AdService {

    private final AdRepository adRepository;

    public AdServiceImpl(AdRepository adRepository) {
        this.adRepository = adRepository;
    }

    public List<Double> getReport(Double dailyAmount) {

        List<Double> output = new ArrayList<>();

        var tempViews = dailyAmount * 30;
        var clickCountFirstAd = tempViews * 0.12;
        var socialNetworkShares = clickCountFirstAd * 0.15;
        var maxShares = socialNetworkShares * 4;
        var newViews = maxShares * 40;
        var totalViews = tempViews + newViews;
        var maxClicks = totalViews * 0.12;

        output.add(totalViews);
        output.add(maxShares);
        output.add(maxClicks);

        return output;
    }

    public double totalInvestment(Double dailyAmount, LocalDate startDate, LocalDate endDate) {

        Period period = Period.between(startDate, endDate);

        return period.getDays() * dailyAmount;
    }

    public ReportDto buildReport(Long id) {

        return adRepository.findById(id)
                .map(adResponse -> new ReportDto(
                        id,
                        adResponse.getClient(),
                        getReport(adResponse.getAmount()),
                        totalInvestment(adResponse.getAmount(),
                                adResponse.getStartDate(),
                                adResponse.getEndDate())))
                .orElseThrow(() -> new AdNotFoundException("Anúncio não localizado."));
    }

    public Ad create(AdRequestDto adRequestDto) {
        return adRepository.save(adRequestDto.toModel());
    }

    public List<Ad> findAll() {
        return adRepository.findAll();
    }
}
