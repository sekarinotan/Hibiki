/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author adminpc
 */
public class FFlogsCommand extends Command {

    private String token;

    public FFlogsCommand(String token) {
        this.token = token;
    }

    @Override
    public void onCommand(MessageReceivedEvent e, String[] args) {
        try {
            JSONArray json = jsonReader("https://www.fflogs.com/v1/parses/character/" + args[2] + "%20" + args[3] + "/" + args[1] + "/na?metric=dps&api_key=" + token);
            JSONObject jo = json.getJSONObject(json.length() - 1);
            EmbedBuilder eb = new EmbedBuilder();
            eb.setAuthor(jo.getString("characterName"));
            eb.setTitle(jo.getString("encounterName"), "https://www.fflogs.com/reports/" + jo.getString("reportID"));
            eb.addField("Job", jo.getString("spec"), true);
            eb.addField("DPS", String.valueOf(jo.getInt("total")), true);
            sendMessageEmbed(e, eb);
        } catch (IOException ex) {
            System.out.println("URL Error");
            ex.printStackTrace();
        }
    }

    @Override
    public List<String> getAliases() {
        return Arrays.asList("/fflog");
    }

    private JSONArray jsonReader(String url) throws MalformedURLException, IOException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            return new JSONArray(jsonText);
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
}
