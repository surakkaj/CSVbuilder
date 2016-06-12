/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csvbuilder;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kaiser Daniel
 */
public class CSVbuilder {

    /**
     * @param args tiedostopolku joka on ensimmäisenä parametseissä. jos ei
     * parametrejä kysytään käyttäjältä polkua
     * @throws java.io.IOException
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String syote = "";

        Scanner scan = new Scanner(System.in);
        if (args.length != 0) {
            if (args[0].matches(".*\\.xml")) {
                syote = args[0];
            } else {
                System.out.println("ei xml tiedosto");

            }
        } else {
            System.out.println("Anna tiedoston nimi: ");

            while (syote.isEmpty()) {
                syote = scan.nextLine();
                if (!syote.matches((".*\\.xml"))) {
                    System.out.println("ei xml tiedosto");
                    syote = "";
                }
            }

            KuittiGeneraattori kg;
            try {
                kg = new KuittiGeneraattori(syote);

                System.out.println(kg.fvd());
                System.out.println(kg.generoiKuitti().toCSV());
                TiedostoIO.kirjoitaTiedostoon(kg.generoiKuitti().toCSV(), syote.replaceAll("xml", "csv"));
            } catch (IOException ex) {
                System.out.println("Tiedostoa ei löydy!");
            }
            scan.nextLine();
        }

    }

}
