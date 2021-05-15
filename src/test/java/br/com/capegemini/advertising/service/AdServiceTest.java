package br.com.capegemini.advertising.service;

import br.com.capegemini.advertising.dto.AdRequestDto;
import br.com.capegemini.advertising.dto.ReportDto;
import br.com.capegemini.advertising.exception.AdNotFoundException;
import br.com.capegemini.advertising.model.Ad;
import br.com.capegemini.advertising.repository.AdRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ContextConfiguration(classes = {AdServiceImpl.class})
@ExtendWith(SpringExtension.class)
public class AdServiceTest {

    @MockBean
    private AdRepository adRepository;

    @Autowired
    private AdService adService;

    @Test
    @DisplayName("Test Should Pass when return the total views")
    void shouldReturnTotalViews() {
        Ad ad = new Ad("Vende Tudo","Capgemini", LocalDate.of(2021,03,01),
                LocalDate.of(2021,04,01),10.0);
    }

    @Test
    public void testBuildReport() {
        when(this.adRepository.findById((Long) any())).thenThrow(new AdNotFoundException("foo"));

        assertThrows(AdNotFoundException.class, () -> this.adService.buildReport(123L));
        verify(this.adRepository).findById((Long) any());
    }

    @Test
    public void testBuildReport2() {
        when(this.adRepository.findById((Long) any())).thenReturn(
                Optional.<Ad>of(new Ad("Name", "Client", LocalDate.ofEpochDay(1L), LocalDate.ofEpochDay(1L), 10.0)));

        ReportDto actualBuildReportResult = this.adService.buildReport(123L);

        assertEquals(22, actualBuildReportResult.getMaxShares().intValue());
        assertEquals(1164, actualBuildReportResult.getTotalViews().intValue());
        assertEquals(0.0, actualBuildReportResult.getTotalInvestment().doubleValue());
        assertEquals(140, actualBuildReportResult.getMaxkClicks().intValue());
        verify(this.adRepository).findById((Long) any());
    }

    @Test
    public void testBuildReport3() {
        when(this.adRepository.findById((Long) any())).thenReturn(Optional.<Ad>empty());

        assertThrows(AdNotFoundException.class, () -> this.adService.buildReport(123L));
        verify(this.adRepository).findById((Long) any());
    }

    @Test
    public void testBuildReport4() {
        when(this.adRepository.findById((Long) any())).thenReturn(
                Optional.<Ad>of(new Ad("Name", "Client", LocalDate.ofEpochDay(1L), LocalDate.ofEpochDay(0L), 10.0)));

        ReportDto actualBuildReportResult = this.adService.buildReport(123L);

        assertEquals(22, actualBuildReportResult.getMaxShares().intValue());
        assertEquals(1164, actualBuildReportResult.getTotalViews().intValue());
        assertEquals(-10.0, actualBuildReportResult.getTotalInvestment().doubleValue());
        assertEquals(140, actualBuildReportResult.getMaxkClicks().intValue());
        verify(this.adRepository).findById((Long) any());
    }

    @Test
    public void shouldGetAllAds(){

        Ad ad1 = new Ad("name1","cliente1", LocalDate.of(2020,01,01),
                LocalDate.of(2020,02,01),10.0);
        Ad ad2 = new Ad("name2","cliente2", LocalDate.of(2020,01,01),
                LocalDate.of(2020,02,01),10.0);
        Ad ad3 = new Ad("name3","cliente3", LocalDate.of(2020,01,01),
                LocalDate.of(2020,02,01),10.0);

        when(adRepository.findAll()).thenReturn(Arrays.asList(ad1, ad2, ad3));

        var response = adService.findAll();

        assertEquals(3, response.size());
        assertEquals("name1", response.get(0).getName());
    }

    @Test
    public void shouldCreateAnAd(){
        AdRequestDto ad1 = new AdRequestDto("name1","cliente1", LocalDate.of(2020,01,01),
                LocalDate.of(2020,02,01),10.0);

        Ad createdAd = ad1.toModel();

        when(adRepository.save(ad1.toModel())).thenReturn(createdAd);

        var response = adService.create(ad1);
        assertEquals("cliente1",response.getClient());

    }
}

