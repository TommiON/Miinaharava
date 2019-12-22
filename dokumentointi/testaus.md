# Miinaharava: testausraportti

Sovellusta on testattu automaattisilla yksikkö- ja integraatiotesteillä (JUnit) sekä manuaalisilla käyttöliittymä- ja järjestelmätesteillä.

## Yksikkö- ja integraatiotestit

Integraatiotestauksessa keskityttiin siihen, miten _Engine_ -pakkauksen luokat ja _Grid_-luokka vuorovaikuttavat keskenään. Tässä hyödynnettiin mock-olioiden ohella _Gridin_ vaihtoehtoista, nimenomaan testejä varten luotua staattista konstruktoria, jolle voi antaa ei-satunnaisen pelilaudan merkkijonoparametrina. (_Engine_-pakkauksen luokkien järkevä testaaminen olisi jokseenkin mahdotonta, jos testin käynnistyessä pelilaudan sisältö olisi mitä milloinkin sattuu.)

## Käyttöliittymätestaus

Manuaalinen käyttöliittymätestaus koostui kahdesta osiosta: graafisen käyttöliittymän erilaisten käyttötapausten kokeilemisesta (melko nopeasti tehty, koska käyttöliittymä on verraten yksinkertainen) sekä komentorivin parametrien validointitestauksesta (sovellukselle syötettiin käynnistettäessä erilaisia, sekä luvallisia että luvattomia paramtereja). Kummassakaan osiossa ei havaittu vakavia puutteita. Graafisen käyttöliittymän testauksessa havaittiin kuitenkin lieviä suorituskykyongelmia ts. hetkittäistä hidastumista. Tämän syistä lyhyt analyysi arkkitehtuurikuvauksen lopussa.

## Järjestelmätestaus

