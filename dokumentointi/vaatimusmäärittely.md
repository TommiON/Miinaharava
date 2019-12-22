# Miinaharava: vaatimusmäärittely

## Käyttäjät ja käyttäjäroolit

Sovellus on "anonyymi" yksinpeli eikä sisällä toiminnallisuuksia esimerkiksi pelaajanimien tai -tilien luomiseen. Käyttäjärooleja on siis tasan yksi: anonyymi pelaajainstanssi, joka luodaan pelikierroksen alkaessa ja katoaa sen loppuessa.

## Toiminnallisuus

* Perusversio generoi pelin alkaessa 9 x 9 ruudun pelilaudan, johon on satunnaisesti sijoitettu 10 miinaa. Sovelluksen käynnistyksen yhteydessä voi myös antaa komentoriviparemetreina oletusasetuksen kumoavan pelilaudan koon ja miinamäärän. 
* Sovellus sisältää myös toiminnallisuuden staattisen eli ei-satunnaisen pelilaudan luomiseen, mutta tämä on tarkoitettu vain sisäisesti testien käyttöön eikä näy käyttäjälle.
* Pelaajalla on Miinaharava-sääntöjen mukaisesti käytössään kaksi toimintoa, tyhjäksi arvaamansa ruudun paljastaminen ja miinoitetuksi arvaamansa ruudun merkitseminen. Nämä toiminnot on toteuttu hiiren vasemman ja oikean napin painalluksina.
* Jos paljastettava ruutu ei ole miinoitettu, se näyttää, monessako sen naapuriruudussa on miina.
* Jos paljastetulla ruudulla ei ole yhtään miinoitettua naapuria, paljastetaan kaikki siihen yhteydessä olevat nollaruudut ja tämän alueen reunalla olevat ei-miinoitetut ruudut.
* Peli päättyy, kun kaikki miinoittamattomat ruudut on paljastettu (voitto) tai paljastetaan ruutu, jossa on miina (häviö). Peli voidaan myös lopettaa ennenaikaisesti käyttöliittymässä olevalla painikkeella.
* Pelin päätyttyä koko ruudukko paljastetaan ja näytetään kulunut aika. Käyttäjä voi aloittaa uuden pelin, jolloin luodaan uusi satunnainen pelilauta.
* Sovellus sisältää graafisen käyttöliittymän ohella myös tekstipohjaisen käyttöliittymän, mutta se ei oletusarvoisesti käynnisty. Teksikäyttöliittymä oli tarpeellinen kehityksen alkuvaiheessa ja jätettiin edelleen osaksi sovellusta mahdollista jatkokehitystä varten.

## Vaillinaiseksi jääneet toiminnot ja mahdollinen jatkokehitys

Ajanpuutteen vuoksi jotkin alkuperäisessä vaatimusmäärittelyssä olleet ideat jäivät vaillinaisiksi tai kokonaan puuttumaan:

* Sovellukseen oli tarkoitus rakentaa reaaliaikainen (kerran sekunnissa päivittyvä) kello, mutta TimerTask-säikeen ja käyttöliittymäsäikeen välillä oli mystinen kommunikaatio-ongelma, jota en käytettävissä olevassa ajassa ehtinyt ratkaista. Nyt sovellus näyttää ajan vasta pelin päätyttyä.
* Sovellusta voi nykyversiossa parametrisoida vain komentoriviltä käynnistettäessä. Ei ollut aikaa rakentaa graafista käyttöliittymää, jossa pelaaja voisi vaikuttaa pelilaudan koostumukseen esim. ennen jokaista kierrosta.
* Sovellus ei tarjoa minkäänlaista persistenssiä. Alunperin oli tarkoitus rakentaa hall of fame -toiminnallisuus, joka olisi pitänyt kirjaa esim. viidestä parhaasta peliajasta.
