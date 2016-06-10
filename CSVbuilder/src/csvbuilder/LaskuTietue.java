/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csvbuilder;

/**
 *
 * @author Kaiser Daniel
 */
public class LaskuTietue extends Tietue {
    public LaskuTietue(){
        this.tietueet = new String[47];
        tietueet[1] = "EUR";
        tietueet[25] = "2";
    }
    
    /**
     * 
     * @param i
     * 0  Laskutyyppi
     * 1  Valuuttakoodi
     * 2  Viitenumero
     * 3  Pankkitili
     * 4  Y-tunnus/HETU/ALV
     * 5  Maksutapa
     * 6  Liikekumppanin nimi
     * 7  Toimitustapa
     * 8  Laskun ale
     * 9  Sis.alv koodi tf
     * 10 Hyvityslaskukoodi
     * 11 Viivästyskorko
     * 12 Laskun päivämäärä
     * 13 ToimitusPäivämäärä
     * 14 Eräpäivämäärä
     * 15 Liikekumppanin osoite
     * 16 Laskutusosoite
     * 17 Toimitusosoite
     * 18 Laskun lisätiedot
     * 19 Muistiinpanot
     * 20 Sähköpostiosoite
     * 21 Maksupäivämäärä
     * 22 Valuuttakurssi
     * 23 Laskun loppusumma
     * 24 ALV prosentti
     * 25 Laskukanava
     * 26 Verkkolaskuosoite
     * 27 Tilausviite
     * 28 Kirjanpito riveittäin koodi tf
     * 29 Finvoice-osoite
     * 30 Finvoice-osoite
     * 31 Asiakasnumero
     * 32 Automaattinen lähetys tai maksettu muualla tieto
     * 33 Liitetiedoston nimi ZIP-paketissa
     * 34 Yhteyshenkilö
     * 35 Liikekumppanin pankin SWIFT tunnus
     * 36 Verkkolaskuoperaattori
     * 37 Liikekumppanin OVT-Tunnus
     * 38 Laskuttajan laskunumero
     * 39 Faktoring-rahoitussopimuksen numero
     * 40 ALV-käsittelyn maakoodi
     * 41 Kielikoodi
     * 42 Käteisalennuksen päivien lukumäärä
     * 43 Käteisalennuksen prosentti
     * 44 ALV-v'hennysprosentti
     * 45 Alv-tyyppi
     * 46 Alv-Status
     * @param a Sarakkeen sisältö
     * @return palauttaa tosi jos asetus onnistui. 
     */ 
    @Override
    public boolean set(int i, String a){
        return super.set(i,a);
    }
}
