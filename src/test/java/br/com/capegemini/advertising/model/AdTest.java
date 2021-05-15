package br.com.capegemini.advertising.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class AdTest {

    @Test
    public void shouldCreateANewAd(){
        Ad ad = new Ad("Vende Tudo","Capgemini", LocalDate.of(2021,03,01),
                LocalDate.of(2021,04,01),10.0);
        assertEquals("Vende Tudo",ad.getName());
        assertEquals("Capgemini",ad.getClient());
        assertEquals(LocalDate.of(2021,03,01),ad.getStartDate());
        assertEquals(LocalDate.of(2021,04,01),ad.getEndDate());
        assertEquals(10.0,ad.getAmount());

    }

    @Test
    public void testEquals() {
        Ad ad = new Ad();
        assertEquals(new Ad(), ad);
    }

    @Test
    public void testEquals2(){
        Ad ad = new Ad();
        assertNotEquals(new Ad("Vende Tudo","Capgemini", LocalDate.of(2021,03,01),
                LocalDate.of(2021,04,01),10.0),ad);
    }

    @Test
    public void testEquals3(){
        Ad ad = new Ad("Vende Tudo","Capgemini", LocalDate.of(2021,03,01),
                LocalDate.of(2021,04,01),10.0);
        assertNotEquals(new Ad(),ad);
    }

    @Test
    public void testEquals4(){
        Ad ad = new Ad();
        assertNotEquals(new Ad(null,null,null,null,10.0),ad);
    }

    @Test
    public void testEquals5(){
        Ad ad = new Ad();
        assertNotEquals(new Ad(null,null,null,LocalDate.of(2021,04,01),null),ad);
    }

    @Test
    public void testEquals6(){
        Ad ad = new Ad();
        assertNotEquals(new Ad(null,null,LocalDate.of(2021,04,01),null ,null),ad);
    }

    @Test
    public void testEquals7(){
        Ad ad = new Ad();
        assertNotEquals(new Ad(null,"Capgemini",null,null ,null),ad);
    }

    @Test
    public void testEquals8(){
        Ad ad = new Ad();
        assertNotEquals(new Ad("Vende Tudo",null,null,null ,null),ad);
    }

    @Test
    public void testHashCode() {
        assertEquals(28629151,(new Ad()).hashCode());
    }

    @Test
    public void testToString() {
        assertEquals("Ad{name:'null', client:'null', startDate:null, endDate:null, amount:null}",
                (new Ad()).toString());
    }

    @Test
    public void shouldTwoUsersInstanceNotBeEqualExceptIfEmpty(){
        Ad ad1 = new Ad("Vende Tudo","Capgemini", LocalDate.of(2021,03,01),
                LocalDate.of(2021,04,01),10.0);
        Ad ad2 = new Ad("Vendendo ainda mais","Capgemini", LocalDate.of(2021,03,01),
                LocalDate.of(2021,04,01),10.0);
        Ad ad3 = new Ad();
        Ad ad4 = new Ad();
        assertNotEquals(ad1.hashCode(),ad2.hashCode());
        assertNotEquals(ad3.hashCode(),ad1.hashCode());
        assertEquals(ad3.hashCode(),ad4.hashCode());
    }

    @Test
    public void shouldTwoIdenticalAdBeEqual(){
        Ad ad1 = new Ad("Vende Tudo","Capgemini", LocalDate.of(2021,03,01),
                LocalDate.of(2021,04,01),10.0);
        Ad ad2= new Ad("Vende Tudo","Capgemini", LocalDate.of(2021,03,01),
                LocalDate.of(2021,04,01),10.0);
        assertEquals(ad1.hashCode(),ad2.hashCode());
        assertEquals(ad1.getClient(),ad2.getClient());
    }
}