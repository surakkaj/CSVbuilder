/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csvbuilder;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Kaiser Daniel
 */
public class TiedostoIO {

    public static boolean kirjoitaTiedostoon(String teksti, String polku) {
        try {
            FileWriter kirjoittaja = new FileWriter(polku, false);
            kirjoittaja.write(teksti);
            kirjoittaja.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static String lueTiedosto(String polku) throws IOException {
        BufferedReader lukija = new BufferedReader(  new InputStreamReader(new FileInputStream(polku), "ISO-8859-15"));
        String rivi = "";
        StringBuilder sb = new StringBuilder("");

        try {
            while ((rivi = lukija.readLine()) != null) {
                sb.append(rivi);
            }
            return sb.toString().replace('\\', '/');
        } finally {
            lukija.close();
        }
    }

    public static String lueTiedostoa(String polku) {
        String palautus = "";

        FileReader fLukija = null;
        BufferedReader bLukija = null;
        try {

            fLukija = new FileReader(polku);
            bLukija = new BufferedReader(fLukija);

        } catch (Exception e) {
            return e.getMessage();
        }
        try {
            String rivi = bLukija.readLine();
            StringBuilder sb = new StringBuilder("");
            while (rivi != null) {
                sb.append(rivi);
                rivi = bLukija.readLine();
            }
            palautus = sb.toString();

        } catch (Exception e) {
            return "No file found" + e.getMessage();
        }
        try {
            bLukija.close();
            fLukija.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return palautus;
    }

}
