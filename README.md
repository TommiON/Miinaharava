# Miinaharava

[Maven-projektin päähakemistoon](https://github.com/TommiON/ot-harjoitustyo/tree/master/MineSweeper)

[Työaikakirjanpito](https://github.com/TommiON/ot-harjoitustyo/blob/master/dokumentointi/tyoaikakirjanpito.md)

## Sovelluksen tarkoitus

Sovellus toteuttaa klassisen Miinaharva-pelin. Sovellus ei sisällä omia sääntölisäyksiä tai -muunnelmia, vaan noudattaa alkuperäisen pelin sääntöjä, jotka [löytyvät esimerkiksi Wikipediasta](https://fi.wikipedia.org/wiki/Miinaharava_(peli)).

## Arkkitehtuuri

[Arkkitehtuurikaavio](https://github.com/TommiON/ot-harjoitustyo/blob/master/dokumentointi/arkkitehtuuri.md)

## Käyttäjät ja käyttäjäroolit

Sovellus on "anonyymi" yksinpeli eikä sisällä toiminnallisuuksia esimerkiksi pelaajanimien tai -tilien luomiseen. Käyttäjärooleja on siis tasan yksi: anonyymi Pelaaja-instanssi, joka luodaan pelikierroksen alkaessa ja katoaa sen loppuessa.

## Perusversion tarjoama toiminnallisuus

Perusversio generoi pelin alkaessa 9 x 9 ruudun pelilaudan, johon on satunnaisesti sijoitettu 10 miinaa _(tehty)_. Pelaajalla on Miinaharava-sääntöjen mukaisesti käytössään kaksi toimintoa, tyhjäksi arvaamansa ruudun paljastaminen ja miinoitetuksi arvaamansa ruudun merkitseminen. _(tehty)_ Nämä toiminnot toteutetaan todennäköisesti hiiren vasemman ja oikean napin painalluksina. _(Tällä hetkellä käytössä väliaikainen ja melkoisen kömpelö tekstikäyttöliittymä, graafinen käyttöliittymä ei vielä pelivalmis)_ Jos paljastetaan ruutu, jonka yhdessäkään naapurissa ei ole miinaa, peli paljastaa kaikki siihen yhteydessä olevat ruudut, joissa ei myöskään ole miinaa, sekä tämän alueen reunoilla olevat miinattomat ruudut _(tehty)_ Peli päättyy, kun miina räjähtää tai kaikki miinoitetut ruudut on paljastettu. _(tehty)_

Peli sisältää lisäksi reaaliaikaisen, jatkuvasti näkyvillä olevan kellon, joka käynnistyy pelin alkaessa ja pysähtyy sen päättyessä. _(Tällä hetkellä toteutettu kello, joka näyttää ajan pelin päätyttyä. Päivittyvä kello tulee osaksi graafista käyttöliittymää.)_

Perusversion käyttöliittymä on siinä määrin ilmeinen, että siitä ei ole tässä graafista hahmotelmaa. 

## Komentorivitoiminnot

#### Kääntäminen ja ajaminen

```shell
mvn compile exec:java -Dexec.mainClass=main.Main
```

#### Testit ja staattinen analyysi

Testien ajaminen

```shell
mvn test
```

Testikattavuusraportti (Jacoco). Kattavuusraportti löytyy tiedostosta _target/site/jacoco/index.html_

```shell
mvn jacoco:report
```

Koodityylin tarkistus (Checkstyle). Tyyliraportti löytyy tiedostosta _target/site/checkstyle.html_

```shell
mvn jxr:jxr checkstyle:checkstyle
```

## Mahdollinen jatkokehitys

Perusversion valmistuttua sovellusta täydennetään ajan salliessa esimerkiksi seuraavilla toiminnoilla:

* Pelin vaikeustason säätäminen ennen pelin alkua (ruudukon koko, miinojen määrä)
* Parhaiden pelikierrosten top5- tai top10-listan ylläpitäminen: mitattu aika ja päivämäärä, jolloin peli on pelattu.
* Heksagoni-moodi, jossa pelilauta muodostetaan neliöiden asemesta kuusikulmioista.
