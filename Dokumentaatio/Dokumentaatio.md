Käyttöohje: Käynnistä CSVB.cmd tiedosto siten, että parametrinä on vain polku XML tiedostoon joka halutaan muokata CSV Formaattiin. Joko komentoriviltä, tai raahaamalla graafisessa käyttöjärjestelmässä halutun tiedoston CSVB.cmd tiedoston  päälle.


Ohjelman pääluokka ottaa parametristään tiedostopolun, jonka se syöttää TiedostoIO luokalle. TiedostoIO lukee tiedoston ja muuttaa sen ohjelman tunnistamaan formaattiin. Tämän jälkeen KuittiGeneraattori luokka käy tiedot läpi, ja hakee tiedoista säännöllisten lausekkeiden aulla jokaisen CSV tiedostoformaatissa löytyvän sarakkeen arvon. Säännölliset lausekkeet löytyvät hakurakenteesta, joiden tietopareina ovat halutun lauseen CSV tietueen indeksiarvo. Kun Kuitti on generoitu, muodostetaan CSV tiedostoformaatti ottamalla jokaisen kuitin tietueen tiedot omalle rivilleen. Tietueen tiedot generoidaan ottamalla jokainen arvo, ja sijoittamalla puolipiste niiden jälkeen.


Luokkakaavio:
![luokkakaavio](https://github.com/surakkaj/CSVbuilder/blob/master/Dokumentaatio/3d55cbfc.png)
