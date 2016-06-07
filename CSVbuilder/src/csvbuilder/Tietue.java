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
public abstract class Tietue {

    String[] tietueet;

    public boolean set(int i, String a) {
        try {
            tietueet[i] = a;
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public String get(int i) {
        try {
            return tietueet[i];
        } catch (NullPointerException e) {
            return "ERROR";
        }
    }

    @Override
    public String toString() {
        return "";
    }

    public String toCSV() {
        StringBuilder ret = new StringBuilder("");
        for (String t : tietueet) {
            if (t == null) {
                t = "";
            }
            ret.append(t + ";");
        }
        ret.append(System.lineSeparator());
        return ret.toString();
    }
}
