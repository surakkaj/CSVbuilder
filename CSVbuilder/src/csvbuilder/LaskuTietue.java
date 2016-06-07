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
        this.tietueet = new String[46];
    }
    
    /**
     * 
     * @param i
     * 1  Laskutyyppi
     * 2  Valuuttakoodi
     * 3  Viitenumero
     * 4  Pankkitili
     * 5  Y-tunnus/HETU/ALV
     * 6  Maksutapa
     * 7  Liikekumppanin nimi
     * 8  Toimitustapa
     * 9  Laskun ale
     * 10 Sis.alv koodi tf
     * 11 Hyvityslaskukoodi
     * 12 Viivästyskorko
     * 13 Laskun päivämäärä
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
