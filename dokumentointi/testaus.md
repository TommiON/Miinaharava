# Miinaharava: testausraportti

## Yksikkö- ja integraatiotestit

Integraatiotestauksessa keskityttiin siihen, miten _Engine_ -pakkauksen luokat ja _Grid_-luokka vuorovaikuttavat keskenään. Tässä hyödynnettiin mock-olioiden ohella _Gridin_ vaihtoehtoista, nimenomaan testejä varten luotua staattista konstruktoria, jolle voi antaa ei-satunnaisen pelilaudan merkkijonoparametrina. (_Engine_-pakkauksen luokkien järkevä testaaminen olisi jokseenkin mahdotonta, jos testin käynnistyessä pelilaudan sisältö olisi mitä milloinkin sattuu.)

## Järjestelmätestaus
