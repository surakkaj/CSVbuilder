/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csvbuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Kaiser Daniel
 */
public class KuittiGeneraattori {

    private String finvoiceData;
    private final Map<Integer, String> laskuTietueRegex;
    private final Map<Integer, String> laskuriviTietueRegex;

    public KuittiGeneraattori(String polku) throws IOException {
        this.finvoiceData = TiedostoIO.lueTiedosto(polku);
        this.laskuTietueRegex = getTietueRegexArray();
        this.laskuriviTietueRegex = getRivitietueRegexArray();
    }

    public String fvd() {
        return this.finvoiceData;
    }

    private static HashMap<Integer, String> getRivitietueRegexArray() {
        HashMap<Integer, String> palautus = new HashMap<>();
        palautus.put(1, "(?<=ArticleName>)([^<]+)");
        palautus.put(2, "(?<=ArticleIdentifier>)([^<]+)");
        palautus.put(3, "(?<=OrderedQuantity)([^<]+)");
        palautus.put(4, "(?<=UnitPriceUnitCode=\")([^\"]+)");
        palautus.put(5, "(?<=UnitPriceAmount)([^<]+)");
        palautus.put(6, "alepros");
        palautus.put(7, "(?<=RowVatRatePercent>)([^<]+)");
        return palautus;
    }

    private static HashMap<Integer, String> getTietueRegexArray() {

        HashMap<Integer, String> palautus = new HashMap<>();
        palautus.put(0, "(?<=InvoiceTypeCode )([^<]+)");
        palautus.put(1, "(?<=AmountCurrencyIdentifier=\")([^\"]+)");
        palautus.put(4, "(?<=BuyerPartyIdentifier>)([^<]+)");
        palautus.put(6, "(?<=BuyerOrganisationName>)([^<]+)");
        palautus.put(11, "(?<=PaymentOverDueFinePercent>)([^<]+)");
        palautus.put(12, "(?<=InvoiceDate )([^<]+)");
        palautus.put(16, "(?=<BuyerOrganisationName>)(.+?)(</CountryCode>)");
        palautus.put(17, "(?=<DeliveryOrganisationName>)(.+?)(</CountryCode>)");
        palautus.put(18, "(?<=InvoiceFreeText>)([^<]+)");
        return palautus;
    }

    public LaskuTietue generoiTiedot(String data) {
        LaskuTietue tietue = new LaskuTietue();
        for (int i : this.laskuTietueRegex.keySet()) {

            if (regexHalkoja(laskuTietueRegex.get(i), data).length != 0 && i != 17 && i != 16) {
                tietue.set(i, regexHalkoja(laskuTietueRegex.get(i), data)[0].replaceAll(".*?>", ""));
            } else if (regexHalkoja(laskuTietueRegex.get(i), data).length != 0 && (i == 17 || i == 16)) {

                tietue.set(i, osoitteistoHalkoja(regexHalkoja(laskuTietueRegex.get(i), data)[0]));
            } else {
                tietue.set(i, "");
            }

        }
        return tietue;
    }

    public LaskuriviTietue generoiRivi(String data) {
        LaskuriviTietue tietue = new LaskuriviTietue();
        for (int i : this.laskuriviTietueRegex.keySet()) {

            if (regexHalkoja(laskuriviTietueRegex.get(i), data).length != 0) {
                tietue.set(i, regexHalkoja(laskuriviTietueRegex.get(i), data)[0].replaceAll(".*?>", ""));
            } else {
                tietue.set(i, "");
            }

        }
        return tietue;
    }

    public Kuitti generoiKuitti() {
        Kuitti kuitti = new Kuitti();
        kuitti.addTietue(generoiTiedot(regexHalkoja("<Finvoice(.+?)<InvoiceRow", finvoiceData)[0]));
        for (String s : regexHalkoja("InvoiceRow>(.+?)<.?InvoiceRow", finvoiceData)) {
            kuitti.addTietue(generoiRivi(s));
        }
        return kuitti;
    }

    private static String[] regexHalkoja(String regex, String data) {
        Pattern pattern = Pattern.compile(regex, Pattern.DOTALL);
        Matcher matcher = pattern.matcher(data);
        ArrayList<String> lista = new ArrayList<>();
        while (matcher.find()) {
            lista.add(matcher.group().trim());
        }
        return lista.toArray(new String[lista.size()]);
    }

    private static String osoitteistoHalkoja(String data) {
        System.out.println(data);
        try {
            String nimi, tarkenne, katuosoite, postinumero, kaupunki, maakoodi;
            tarkenne = "";
            if (data.contains("Tähän tarkenteen xml tagit")) {
                tarkenne = regexHalkoja("", data)[0] + "\\";
            }
            nimi = regexHalkoja("(?<=OrganisationName>)([^<]+)", data)[0] + "\\";
            katuosoite = regexHalkoja("(?<=StreetName>)([^<]+)", data)[0] + "\\";
            postinumero = regexHalkoja("(?<=PostCodeIdentifier>)([^<]+)", data)[0] + "\\";
            kaupunki = regexHalkoja("(?<=TownName>)([^<]+)", data)[0] + "\\";
            maakoodi = regexHalkoja("(?<=CountryCode>)([^<]+)", data)[0];
            return nimi + tarkenne + katuosoite + postinumero + kaupunki + maakoodi;
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            return data.replaceAll("<.*?>", "/").replaceAll("/\\W*/", "/");
        }

    }
}
