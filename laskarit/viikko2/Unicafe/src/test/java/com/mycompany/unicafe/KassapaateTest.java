package com.mycompany.unicafe;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class KassapaateTest {
    
    Kassapaate paate;
    Maksukortti kortti;
    
    public KassapaateTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        paate = new Kassapaate();
        kortti = new Maksukortti(1000);
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void alkuTilanneOikein() {
        assertEquals(100000, paate.kassassaRahaa());
        assertEquals(0, paate.maukkaitaLounaitaMyyty());
        assertEquals(0, paate.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void kateisOstoToimiiJosRahaRiittaa_edullinen() {
        int tulos = paate.syoEdullisesti(1000);
        assertEquals(100000+240, paate.kassassaRahaa());
        assertEquals(1, paate.edullisiaLounaitaMyyty());
        assertEquals(1000-240, tulos);
    }
    
    @Test
    public void kateisOstoToimiiJosRahaRiittaa_maukas() {
        int tulos = paate.syoMaukkaasti(1000);
        assertEquals(100000+400, paate.kassassaRahaa());
        assertEquals(1, paate.maukkaitaLounaitaMyyty());
        assertEquals(1000-400, tulos);
    }
    
    @Test
    public void kateisOstoToimiiJosRahaEiRiita() {
        int tulos = paate.syoEdullisesti(100);
        assertEquals(100000, paate.kassassaRahaa());
        assertEquals(0, paate.edullisiaLounaitaMyyty());
        assertEquals(100, tulos);
        
        tulos = paate.syoMaukkaasti(200);
        assertEquals(100000, paate.kassassaRahaa());
        assertEquals(0, paate.maukkaitaLounaitaMyyty());
        assertEquals(200, tulos);
    }
    
    @Test
    public void korttiOstoToimiiJosRahaRiittaa() {
        boolean tulos = paate.syoEdullisesti(kortti);
        assertEquals(true, tulos);
        assertEquals(1000-240, kortti.saldo());
        assertEquals(1, paate.edullisiaLounaitaMyyty());
        assertEquals(100000, paate.kassassaRahaa());
        
        tulos = paate.syoMaukkaasti(kortti);
        assertEquals(1000-240-400, kortti.saldo());
        assertEquals(1, paate.maukkaitaLounaitaMyyty());
        assertEquals(100000, paate.kassassaRahaa());
    }
    
    @Test
    public void korttiOstoToimiiJosRahaEiRiita() {
        paate.syoMaukkaasti(kortti);
        paate.syoMaukkaasti(kortti);
        
        boolean tulos = paate.syoMaukkaasti(kortti);
        assertEquals(false, tulos);
        assertEquals(200, kortti.saldo());
        assertEquals(2, paate.maukkaitaLounaitaMyyty());
        assertEquals(100000, paate.kassassaRahaa());
        
        tulos = paate.syoEdullisesti(kortti);
        assertEquals(false, tulos);
        assertEquals(200, kortti.saldo());
        assertEquals(0, paate.edullisiaLounaitaMyyty());
        assertEquals(100000, paate.kassassaRahaa());
    }
    
    @Test
    public void rahanLatausKortilleToimii() {
        paate.lataaRahaaKortille(kortti, 1000);
        assertEquals(1000+1000, kortti.saldo());
        assertEquals(100000+1000, paate.kassassaRahaa());
        
        paate.lataaRahaaKortille(kortti, -1);
        assertEquals(1000+1000, kortti.saldo());
        assertEquals(100000+1000, paate.kassassaRahaa());
    }
}
