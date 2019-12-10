# Miinaharava

[Maven-projektin päähakemistoon](https://github.com/TommiON/ot-harjoitustyo/tree/master/MineSweeper)

[MineSweeper pre-release](https://github.com/TommiON/ot-harjoitustyo/releases/tag/viikko5)

## Sovelluksen tarkoitus

Sovellus toteuttaa klassisen Miinaharva-pelin. Sovellus ei sisällä omia sääntölisäyksiä tai -muunnelmia, vaan noudattaa alkuperäisen pelin sääntöjä, jotka [löytyvät esimerkiksi Wikipediasta](https://fi.wikipedia.org/wiki/Miinaharava_(peli)).

## Dokumentaatio

[Vaatimusmäärittely](https://github.com/TommiON/ot-harjoitustyo/blob/master/dokumentointi/vaatimusmäärittely.md)

[Arkkitehtuurin kuvaus](https://github.com/TommiON/ot-harjoitustyo/blob/master/dokumentointi/arkkitehtuuri.md)

[Käyttöohje](https://github.com/TommiON/ot-harjoitustyo/blob/master/dokumentointi/käyttöohje.md)

[Työaikakirjanpito](https://github.com/TommiON/ot-harjoitustyo/blob/master/dokumentointi/tyoaikakirjanpito.md)

## Komentorivitoiminnot

#### Kääntäminen ja ajaminen

```shell
mvn compile exec:java -Dexec.mainClass=main.Main
```

Suoritettavan .jar-tiedoston generoiminen

```shell
mvn package
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

#### Dokumentointi

JavaDocin generointi:

```shell
mvn javadoc:javadoc
```
