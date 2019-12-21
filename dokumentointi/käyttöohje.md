# Miinaharava: käyttöohje

## Lataus ja käynnistys

Lataa tiedosto [MineSweeper.jar](https://github.com/TommiON/ot-harjoitustyo/releases/download/v0.9/MineSweeper.jar). Mene hakemistoon, jossa tiedosto sijaitsee, ja anna komento

```shell
java -jar MineSweeper.jar
```

Sovellukselle voi antaa komentoriviltä kolme parametria, joista ensimmäinen määrittelee pelilaudan leveyden, toinen korkeuden ja kolmas sijoitettavien miinojen määrän. Esimerkiksi alla oleva komento luo 5 x 10 ruudun pelilaudan, jossa 5 miinaa:

```shell
java -jar MineSweeper.jar 5 10 5
```

Pelilaudan sivun pituus voi olla maksimissaan 20 ruutua. Miinoja voi olla enintään yhtä monta kuin laudalla on ruutuja ja vähintään niitä pitää olla yksi. Sovellus pakottaa arvot näihin rajoihin, jos sille yrittää antaa liian suuren/pienen arvon.

Jos parametreja ei anneta tai ne ovat virheellisiä, sovellus käynnistyy oletusarvoilla: 9 x 9 ruudun pelilauta, jossa 10 miinaa.

## Pelaaminen

Pelin tavoitteena on paljastaa kaikki miinoittamattomat ruudut ja olla paljastamatta yhtään miinoitettua ruutua.

Ruutu paljastetaan klikkaamalla sitä. Jos ruudussa on miina (M), se RÄJÄHTÄÄ ja peli päättyy tappioon. Jos ruutu on miinoittamaton, paljastettaessa se näyttää, montako miinaa sitä ympäröivissä kahdeksassa ruudussa on. Jos tämä luku on nolla, paljastetaan myös kaikki paljastettuun ruutuun yhteydessä olevat ruudut, joita ympäröivissä ruuduissa on myös nolla miinaa, sekä kaikki tätä aluetta reunustavat miinoittamattomnat ruudut.

![](UI_example.png)

Ruudun voi myös liputtaa (#), jos päättelee sen olevan miinoitettu. Lippu on varokeino, jolla voi varmistaa, ettei vahingossa paljasta miinoitettua ruutua. Liputtaminen tehdään klikkaamalla hiiren oikeata/toissijaista nappia. Liputettua ruutua ei voi paljastaa, mutta lipun voi poistaa klikkaamalla ruutua uudelleen hiiren oikealla/toissijaisella napilla.

Pelin päätyttyä joko voittoon tai tappioon alalaidan statusrivillä näytetään kulunut aika. Tämän jälkeen voi aloittaa uuden pelin painamalla sovelluksen ainoata pelilaudan ulkopuolista painiketta. Pelin aikana samalla painikkeella voi peruuttaa pelin (pakotettu häviö).
