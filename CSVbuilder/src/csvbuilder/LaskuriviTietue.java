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
public class LaskuriviTietue extends Tietue {

    public LaskuriviTietue() {
        this.tietueet = new String[17];
    }
    /**
     * 
     * @param i
     * 0  Tyhjä
     * 1  Tuotteen Kuvaus
     * 2  Tuotteen koodi
     * 3  Määrä
     * 4  Yksikkö
     * 5  Yksikköhinta
     * 6  Rivin aleprosentti
     * 7  Rivin ALVprosentti
     * 8  Rivikommentti
     * 9  ei
     * 10 ei
     * 11 ei
     * 12 ei
     * 13 Kirjanpitiotili
     * 14 ALV vähennysprosentti
     * 15 ALV tyyppi
     * 16 ALV-status
     * 
     * @param a Sarakkeen arvo
     * @return 
     */
    @Override
    public boolean set(int i, String a){
        return super.set(i,a);
    }

}
