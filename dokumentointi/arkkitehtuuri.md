# MineSweeper: arkkitehtuuri

## Pakkaus- ja luokkarakenne

Luokat on jaettu neljään pakkaukseen:

_model_-pakkaus sisältää sovelluksen datan ja tätä dataa suoraan muokkaavan toiminnallisuuden. _Grid_-luokka mallintaa _Tile_-olioista koostuvan pelilaudan. Näistä erillisenä on _Timing_-luokka, joka huolehtii ajanotosta.

_ui_-pakkaus sisältää käyttöliittymäkomponentit. Pakkauksen pääluokka on _MainWindow_. Se käynnistetään sovelluksen käynnistyessä ja ylläpitää pääikkunaa, johon käyttöliittymä rakennetaan asianmukaisista olioista. Itse pelilaudan näyttäminen on delegoitu _GridDisplayManager_-oliolle, joka edelleen delegoi yksittäisten ruutujen näyttämisen ja klikkauksiin reagoimisen _TileDisplayManager_-oliolle. _StatusDisplayManager_ huolehtii pelitilanteen ja ajan näyttämisestä.

Arkkitehtuurissa _ui_- ja _model_-pakettien luokat eivät kommunikoi suoraan. Välittäjänä toimii _engine_-pakkaus, joka sisältää pelin "moottorin". Aiemmassa, tekstipohjaisessa versiossa pelin kulku oli mallinnettu while-silmukkana _GameRound_-luokassa. Graafinen versio toimii reaktiivisesti (kun käyttäjä klikkaa jotain ruutua) ja ajastetusti (kellon päivittäminen). Näistä toimista ja pelin loppumisesta huolehtii _GameController_-luokka. Yksittäinen siirto on mallinnettu _Move_-oliona. _MoveResolver_ laskee ja palauttaa yksittäisen siirron lopputuloksen. _ExpositionHandler_ on edellisestä eriytetty apuluokka, joka huolehtii nollaruutualueiden paljastamisesta käyttäen leveyshakutyyppistä algorimia.

Lisäksi sovelluksessa on _Main_-paketti, joka sisältää vain _Main_-luokan ja huolehtii tärkeimpien varsinaisten työolioiden luomisesta ja alustamisesta.

![](MineSweeper_architecture.png)



## Esimerkki sekvenssistä



![](MineSweeper_sequence.png)
