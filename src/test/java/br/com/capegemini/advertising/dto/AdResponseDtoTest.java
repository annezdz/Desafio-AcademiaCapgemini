package br.com.capegemini.advertising.dto;

import br.com.capegemini.advertising.model.Ad;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AdResponseDtoTest {

    @Test
    public void shouldCreateResponseDtoInstance(){
        AdResponseDto atual = new AdResponseDto(new Ad());
        assertNull(atual.getName());
        assertNull(atual.getClient());
        assertNull(atual.getStartDate());
        assertNull(atual.getEndDate());
        assertNull(atual.getAmount());
        assertTrue(atual instanceof AdResponseDto);
    }

    @Test
    public void shouldCreateResponse(){
        AdResponseDto atual = new AdResponseDto(new Ad("teste","teste",
                LocalDate.of(2021,01,01),
                LocalDate.of(2021,02,01),10.0));

        assertEquals("teste",atual.getName());
        assertEquals("teste",atual.getClient());
        assertEquals(LocalDate.of(2021,01,01),atual.getStartDate());
        assertEquals(LocalDate.of(2021,02,01),atual.getEndDate());
        assertEquals(10.0,atual.getAmount());
    }

    @Test
    public void shouldGetAnId(){
        AdResponseDto atual = new AdResponseDto(new Ad());
        assertEquals(null,atual.getId());
    }
}