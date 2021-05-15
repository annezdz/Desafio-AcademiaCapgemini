package br.com.capegemini.advertising.controller;

import br.com.capegemini.advertising.model.Ad;
import br.com.capegemini.advertising.repository.AdRepository;
import br.com.capegemini.advertising.service.AdService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles({"test"})
public class AdControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AdService adService;

    @MockBean
    private AdRepository adRepository;

    @Test
    public void testFindByClient() throws Exception {

        Ad ad = new Ad("Teste", "Cliente",
                LocalDate.of(2021, 5, 16), LocalDate.of(2021, 6, 16),
                150.0);

        when(adRepository.findAll()).thenReturn(List.of(ad));
        when(adService.findAll()).thenReturn(List.of(ad));

        mockMvc.perform(get("/api/v1/ads?client={id}", "Cliente")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testFindByStartDate() throws Exception {

        Ad ad = new Ad("Teste", "Cliente",
                LocalDate.of(2021, 5, 16), LocalDate.of(2021, 6, 16),
                150.0);

        when(adRepository.findAll()).thenReturn(List.of(ad));
        when(adService.findAll()).thenReturn(List.of(ad));

        mockMvc.perform(get("/api/v1/ads?startDate={id}", "2021-05-16")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testFindAll() throws Exception {

        Ad ad = new Ad("Teste", "Cliente",
                LocalDate.of(2021, 5, 16), LocalDate.of(2021, 6, 16),
                150.0);

        when(adRepository.findAll()).thenReturn(List.of(ad));
        when(adService.findAll()).thenReturn(List.of(ad));

        mockMvc.perform(get("/api/v1/ads")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
