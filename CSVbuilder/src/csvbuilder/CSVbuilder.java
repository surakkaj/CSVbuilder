/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csvbuilder;

import java.io.IOException;

/**
 *
 * @author Kaiser Daniel
 */
public class CSVbuilder {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        if (args.length != 0) {
            if (args[0].matches(".*\\.xml")) {

                KuittiGeneraattori kg = new KuittiGeneraattori(args[0]);

                TiedostoIO.kirjoitaTiedostoon(kg.generoiKuitti().toCSV(), args[0].replaceAll("xml", "csv"));
            }
        } else {
            KuittiGeneraattori kg = new KuittiGeneraattori("emls.xml");
            System.out.println(kg.fvd());
            System.out.println(kg.generoiKuitti().toCSV());
            TiedostoIO.kirjoitaTiedostoon(kg.generoiKuitti().toCSV(), "eml.csv");
        }

    }

}
