package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(10);
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti!=null);      
    }
    
    @Test
    public void saldoAlussaOikein() {
        assertEquals(10, kortti.saldo());
    }
    
    @Test
    public void saldoKasvaaOikein() {
        kortti.lataaRahaa(5);
        assertEquals(15, kortti.saldo());
        kortti.lataaRahaa(0);
        assertEquals(15, kortti.saldo());
    }
    
    @Test
    public void ottoToimiiOikeinJosRahaRiittaa() {
        boolean tulos = kortti.otaRahaa(5);
        assertEquals(true, tulos);
        assertEquals(5, kortti.saldo());
    }
    
    @Test
    public void ottoToimiiOikeinJosRahaEiRiita() {
        boolean tulos = kortti.otaRahaa(11);
        assertEquals(false, tulos);
        assertEquals(10, kortti.saldo());
    }
    
    @Test
    public void tulostaaTilansaOikein() {
        assertEquals("saldo: 0.10", kortti.toString());
    }
}
