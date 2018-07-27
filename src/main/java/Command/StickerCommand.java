/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

/**
 *
 * @author adminpc
 */
public class StickerCommand extends Command {

    String[] urlimage = new String[]{"http://vampy.moe/images/emojis/aoshi/",
        "http://vampy.moe/images/emojis/shaa/",
        "http://vampy.moe/images/emojis/mei/",
        "http://vampy.moe/images/emojis/skye/",
        "http://vampy.moe/images/emojis/kai/",
        "http://vampy.moe/images/emojis/official1/",
        "http://vampy.moe/images/emojis/official2/",
        "http://vampy.moe/images/emojis/fanart/",
        "http://vampy.moe/images/emojis/vyrn/"};

    @Override
    public void onCommand(MessageReceivedEvent e, String[] args) {
        EmbedBuilder eb = new EmbedBuilder();
        if (args.length > 2) {
        } else {
            String emote = args[1].toString();
            try {
                for (int i = 0; i < urlimage.length; i++) {
                    URL url = new URL(urlimage[i] + "" + args[1] + ".png");
                    HttpURLConnection urlConn = (HttpURLConnection) url.openConnection();
                    urlConn.connect();
                    if (urlConn.getResponseCode() == 200) {
                        eb.setImage(urlimage[i] + "" + args[1] + ".png");
                        sendMessageEmbed(e, eb);
                    }
                }
            } catch (IOException ex) {
                System.out.println("Error creating HTTP connection");
                ex.printStackTrace();
            }
        }

    }

    @Override
    public List<String> getAliases() {
        return Arrays.asList("/gbf");
    }

}
