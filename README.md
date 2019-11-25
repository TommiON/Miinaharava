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

Perusversio generoi pelin alkaessa 9 x 9 ruudun pelilaudan, johon on satunnaisesti sijoitettu 10 miinaa. Pelaajalla on Miinaharava-sääntöjen mukaisesti käytössään kaksi toimintoa, tyhjäksi arvaamansa ruudun paljastaminen ja miinoitetuksi arvaamansa ruudun merkitseminen. Nämä toiminnot toteutetaan todennäköisesti hiiren vasemman ja oikean napin painalluksina.

Peli sisältää lisäksi reaaliaikaisen, jatkuvasti näkyvillä olevan kellon, joka käynnistyy pelin alkaessa ja pysähtyy sen päättyessä.

Perusversion käyttöliittymä on siinä määrin ilmeinen, että siitä ei ole tässä graafista hahmotelmaa.

#### Tämänhetkisen version valmiusaste

Tällä hetkellä pelin peruslogiikka toteutettu ja sitä voi pelata yksinkertaisella tekstikäyttöliittymällä (paitsi miinoitetuksi epäiltyjen ruutujen liputtaminen, joka vielä toteuttamatta). Graafinen käyttöliittymä ja ajanotto vielä toteuttamatta.

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
