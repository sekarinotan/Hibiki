/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Arrays;
import java.util.List;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

/**
 *
 * @author adminpc
 */
public class etcCommand extends Command {

    SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public void onCommand(MessageReceivedEvent e, String[] args) {
        switch (args[0]) {
            case "goodbot":
                sendMessage(e, "Arigathanks " + e.getAuthor().getAsMention());
                break;
            case "badbot":
                sendMessage(e, "slaps " + e.getAuthor().getAsMention());
                break;
            case "dumbbot":
                sendMessage(e, "punches " + e.getAuthor().getAsMention());
                break;
            case "cutebot":
                sendMessage(e, "You too " + e.getAuthor().getAsMention());
                break;
            case "/info":
                User info = e.getAuthor();
                Member user = e.getGuild().getMember(info);
                EmbedBuilder userinfo = new EmbedBuilder();
                userinfo.setTitle("User information of " + info.getName());
                userinfo.setThumbnail(info.getAvatarUrl());
                userinfo.addField("User id", info.getId(), false);
                userinfo.addField("Nickname", user.getEffectiveName(), false);
                userinfo.addField("Status", user.getOnlineStatus().toString().replace("_", ""), false);
                if (user.getGame() != null) {
                    userinfo.addField("Game", user.getGame().toString(), false);
                }
                userinfo.addField("Guild join date", user.getJoinDate().format(DateTimeFormatter.RFC_1123_DATE_TIME), false);
                userinfo.addField("Discord join date", info.getCreationTime().format(DateTimeFormatter.RFC_1123_DATE_TIME), false);
                userinfo.addField("Avatar url", info.getAvatarUrl(), true);
                sendMessageEmbed(e, userinfo);
                break;
            default:
                return;
        }
    }

    @Override
    public List<String> getAliases() {
        return Arrays.asList("goodbot", "badbot", "cutebot", "dumbbot", "/info");
    }

}
