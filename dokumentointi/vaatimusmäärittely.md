# Vaatimusmäärittely

## Käyttäjät ja käyttäjäroolit

Sovellus on "anonyymi" yksinpeli eikä sisällä toiminnallisuuksia esimerkiksi pelaajanimien tai -tilien luomiseen. Käyttäjärooleja on siis tasan yksi: anonyymi Pelaaja-instanssi, joka luodaan pelikierroksen alkaessa ja katoaa sen loppuessa.

## Perusversion tarjoama toiminnallisuus ja valmiusaste

_Yleistä valmiusasteesta: toiminnallisesti sovellus on ottanut hetkellistä takapakkia, koska kaikkia sovelluslogiikan osia ei ole vielä siirretty graafiseen käyttöliittymään. Kaikki logiikka on kuitenkin olemassa ja toimii tekstikäyttöliittymässä (joka nykyversiossa ei käynnisty)._

* Perusversio generoi pelin alkaessa 9 x 9 ruudun pelilaudan, johon on satunnaisesti sijoitettu 10 miinaa. _Tehty._
* Perusversion käyttöliittymä on siinä määrin ilmeinen, että siitä ei ole tässä graafista hahmotelmaa. _Käyttöliittymä tällä hetkellä ruma ja vaillinainen, sisältää vasta itse peliruudukon ja statustekstin._
* Pelaajalla on Miinaharava-sääntöjen mukaisesti käytössään kaksi toimintoa, tyhjäksi arvaamansa ruudun paljastaminen ja miinoitetuksi arvaamansa ruudun merkitseminen. Nämä toiminnot toteutetaan hiiren vasemman ja oikean napin painalluksina. _Jo käytöstä poistetussa teksikäyttöliittymässä toimivat molemmat, graafisessa käyttöliittymässä vasta ruudun paljastaminen._
* Jos paljastetulla ruudulla ei ole yhtään miinoitettua naapuria, paljastetaan kaikki siihen yhteydessä olevat nollaruudut ja tämän alueen reunalla olevat ei-miinoitetut ruudut. _Toiminnallisuus olemassa ja toimii tekstikäyttöliittymässä, mutta ei vielä graafisessa käyttöliittymässä._
* Peli sisältää lisäksi reaaliaikaisen, jatkuvasti näkyvillä olevan kellon, joka käynnistyy pelin alkaessa ja pysähtyy sen päättyessä. _Tällä hetkellä sovellus ottaa aikaa ja tulostaa sen pelin päättyessä. Lopullisessa versiossa reaaliaikainen kello._
* Peli päättyy, kun kaikki miinoittamattomat ruudut on paljastettu (voitto) tai paljastetaan ruutu, jossa on miina (häviö). _Tehty._
* Pelin päätyttyä koko ruudukko paljastetaan ja käyttäjä voi aloittaa uuden pelin.

## Mahdollinen jatkokehitys

Perusversion valmistuttua sovellusta täydennetään ajan salliessa esimerkiksi seuraavilla toiminnoilla:

* Pelin vaikeustason säätäminen ennen pelin alkua (ruudukon koko, miinojen määrä)
* Parhaiden pelikierrosten top5- tai top10-listan ylläpitäminen: mitattu aika ja päivämäärä, jolloin peli on pelattu.
* Heksagoni-moodi, jossa pelilauta muodostetaan neliöiden asemesta kuusikulmioista.
