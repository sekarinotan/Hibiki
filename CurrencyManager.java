package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import org.json.JSONObject;

public class CurrencyManager {
    public double getRate(String[] args) throws IOException {
        double rate = 0;
        JSONObject json = jsonReader("http://free.currencyconverterapi.com/api/v5/convert?q=" + args[1] + "_" + args[2] + "&compact=y");
        return json.getJSONObject(args[1].toUpperCase() + "_" + args[2].toUpperCase()).getDouble("val");
    }

    private JSONObject jsonReader(String url) throws MalformedURLException, IOException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            return new JSONObject(jsonText);
        } finally {
            is.close();
        }
    }

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public boolean isNumeric(String str) {
        try {
            double d = Double.parseDouble(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
