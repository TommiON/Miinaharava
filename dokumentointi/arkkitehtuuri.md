# MineSweeper: arkkitehtuuri

## Pakkaus- ja luokkarakenne

Luokat on jaettu neljään pakkaukseen:

_Model_-pakkaus sisältää sovelluksen datan ja tätä dataa suoraan muokkaavan toiminnallisuuden. _Grid_-luokka mallintaa _Tile_-olioista koostuvan pelilaudan. _Grid_-luokan merkittävin toiminnallisuus on satunnaisen pelilaudan generoiminen, mutta se tarjoaa testejä varten myös vaihtoehtoisen konstruktorin, jolle voi antaa ei-satunnaisen pelilaudan merkkijonona. Itse pelitilanne on pohjimmiltaan tallennettuna _Tile_-olioissa. Erillisenä luokkana on vielä _Timing_, joka huolehtii ajanotosta.

_Ui_-pakkaus sisältää käyttöliittymäkomponentit. Pakkauksen pääluokka on _MainWindow_. Se käynnistetään sovelluksen käynnistyessä ja ylläpitää pääikkunaa. Yksittäisten ruutujen näyttäminen ja klikkauksiin reagoiminen on delegoitu _TileDisplayManager_-olioille, jotka ylläpitävät jokaiselle ruudulle pelitilanteen mukaista graafista ilmettä ja hiirenklikkauksiin reagoivia käsittelijämetodeita. Ikkunan alalaidan statustekstistä ja ylälaidan kontrollipainikkeesta _MainWindow_ huolehtii suoraan itse. (Pakkaus sisältää myös tekstikäyttöliittymästä huolehtivan _TextUI_-luokan, joka oli tarpeellinen sovelluksen kehitysvaiheessa, mutta joka ei nykyisessä graafisessa versiossa oletusarvoisesti käynnisty. Luokkaa ei kuitenkaan ole poistettu, sillä se saattaa osoittautua hyödylliseksi sovelluksen mahdollisessa jatkokehityksessä.)

Arkkitehtuurissa _ui_- ja _model_-pakettien luokat eivät kommunikoi suoraan. Välittäjänä toimii _engine_-pakkaus, joka sisältää pelin "moottorin". Aiemmassa, tekstipohjaisessa versiossa pelin kulku oli mallinnettu while-silmukkana _GameRound_-luokassa, joka on teksikäyttöliittymän tavoin yhä passiivisena osana sovellusta. Graafinen versio sen sijaan toimii reaktiivisesti (kun käyttäjä klikkaa jotain ruutua) ja tätä kontrolloi _GameController_-luokka. Yksittäinen siirto on mallinnettu _Move_-oliona. _MoveResolver_ laskee ja palauttaa yksittäisen siirron lopputuloksen. _ExpositionHandler_ on edellisestä eriytetty apuluokka, joka huolehtii nollaruutualueiden paljastamisesta käyttäen leveyshakutyyppistä algorimia.

Lisäksi sovelluksessa on _Main_-paketti, joka sisältää vain _Main_-luokan. Tämä luokka vastaanottaa ja validoi mahdolliset komentoriviparametrit ja siirtää sitten suorituksen sovelluksen todelliselle pääluokalle (_GameController_).

![](MineSweeper_architecture.png)



## Esimerkki luokkien toiminnasta

Pelin keskeisin tapahtumaketju on käyttäjän siirron lukeminen ja käsittely. Tekstipohjaisessa versiossa tämä oli toteuttu silmukkana _GameRound_-luokassa:

![](MineSweeper_sequence.png)

Graafisessa versiossa arkkitehtuuri on muutettu reaktiiviseksi: aloite tulee _TileDisplayManager_-luokalta, joka rekisteröi käyttäjän klikkauksen, luo _Move_-olion ja informoi tästä _GameController_-luokkaa:

![](MineSweeper_sequence2.png)

## Ohjelman rakenteeseen jääneet heikkoudet

Ajanpuutteen vuoksi ohjelmaan jäi arkkitehtuurin näkökulmasta ainakin seuraavat puutteet:

* Graafista käyttöliittymää päivittävä koodi on optimoimatonta. Jotta ExpostionHandler-luokan tekemä massapaljastus heijastuisi  käyttöliittymään, _koko ruudukon_ päivittävää toiminnallisuutta kutsutaan jokaisen siirron jälkeen, vaikka TileDisplayManager-luokka osaa päivittää yksittäisen ruudun ja useimmissa tapauksissa tämä olisi riittävää. Yhdessä JavaFX:n yleisen tehottomuuden kanssa tämä tekee käyttöliittymästä hieman hitaan. Asian olisi voinut ratkaista esim. lisäämällä MoveResolver-luokan palautusarvoihin uuden arvon, joka kertoo, milloin kyseessä on massapaljastus.
* Kehityksen tuoksinassa koordinaattijärjestelmä pääsi hajaantumaan kahteen paikkaan: _Grid_-luokka ylläpitää koordinaatistoa, mutta lisäksi jokainen _Tile_-olio tietää koordinaattinsa. Tämä rikkoo "single source of truth" -ajattelua ja on potentiaalinen bugien lähde. Parempi ratkaisu olisi todennäköisesti se, että koordinaatisto on täysin _Gridin_ vastuulla ja yksittäinen _Tile_ ei edes tiedä sijaintiaan kokonaiskuvassa.
* MoveResolver-luokan palautusarvo ilmaistaan kovakoodattuina kokonaislukuina, mikä on potentiaalinen bugien lähde ja epäilmeistä koodin lukijalle. Parempi ratkaisu olisi enumeraatiotyyppi, joka sisältää mahdolliset lopputulemat.
