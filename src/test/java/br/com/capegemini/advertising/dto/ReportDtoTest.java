package br.com.capegemini.advertising.dto;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class ReportDtoTest {

    @Test
    public void shouldGetaReportDTO(){
        ReportDto atual = new ReportDto();
        assertTrue(atual instanceof ReportDto);
    }

    @Test
    public void shouldGetInstanceOfReportDto(){
        ReportDto atual = new ReportDto(1L, "teste", Arrays.asList(3.4, 5.6, 7.8),120.0);
        assertEquals(1L,atual.getId());
        assertEquals("teste",atual.getClient());
        assertEquals(120.0,atual.getTotalInvestment());
        assertEquals(3,atual.getTotalViews());
        assertEquals(6,atual.getMaxShares());
        assertEquals(8,atual.getMaxkClicks());
    }



}