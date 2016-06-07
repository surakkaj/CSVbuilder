/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csvbuilder;

import java.util.ArrayList;

/**
 *
 * @author Kaiser Daniel
 */
public class Kuitti {

    ArrayList<Tietue> tietueet;

    public Kuitti() {
        this.tietueet = new ArrayList<Tietue>();
    }

    public void addTietue(Tietue t) {
        this.tietueet.add(t);
    }

    public String toCSV() {

        StringBuilder sb = new StringBuilder("");
        for (Tietue t : this.tietueet) {
            sb.append(t.toCSV());
        }
        return sb.toString();
    }

}
