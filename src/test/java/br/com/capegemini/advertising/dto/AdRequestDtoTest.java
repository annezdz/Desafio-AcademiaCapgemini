package br.com.capegemini.advertising.dto;

import br.com.capegemini.advertising.model.Ad;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class AdRequestDtoTest {

    @Test
    public void shouldRequestAnAd(){
        AdRequestDto atual = new AdRequestDto();
        assertTrue(atual instanceof AdRequestDto);
    }

    @Test
    public void shouldRequestAnAdWithParameters(){
        AdRequestDto atual = new AdRequestDto("testeNome","testeEmpresa",
                LocalDate.of(2021,01,01),
                LocalDate.of(2021,02,01),1.0);
        assertEquals("testeNome",atual.getName());
        assertEquals("testeEmpresa",atual.getClient());
        assertEquals(LocalDate.of(2021,01,01),atual.getStartDate());
        assertEquals(LocalDate.of(2021,02,01),atual.getEndDate());
        assertEquals(1.0,atual.getAmount());
    }

    @Test
    public void shouldReturnAModel(){
        AdRequestDto atual = new AdRequestDto("testeNome","testeEmpresa",
                LocalDate.of(2021,01,01),
                LocalDate.of(2021,02,01),1.0);
        assertEquals("testeNome",atual.toModel().getName());
        assertEquals("testeEmpresa",atual.toModel().getClient());
        assertEquals(LocalDate.of(2021,01,01),atual.toModel().getStartDate());
        assertEquals(LocalDate.of(2021,02,01),atual.toModel().getEndDate());
        assertEquals(1.0,atual.toModel().getAmount());
        assertTrue(atual instanceof AdRequestDto);
    }

    @Test
    public void shouldGetPropertiesFromAdRequestDto(){
        AdRequestDto atual = new AdRequestDto("testeNome","testeEmpresa",
                LocalDate.of(2021,01,01),
                LocalDate.of(2021,02,01),1.0);
        assertEquals("testeNome",atual.getName());
        assertEquals("testeEmpresa",atual.getClient());
        assertEquals(LocalDate.of(2021,01,01),atual.getStartDate());
        assertEquals(LocalDate.of(2021,02,01),atual.getEndDate());
        assertEquals(1.0,atual.getAmount());
        assertTrue(atual instanceof AdRequestDto);
    }



    }

