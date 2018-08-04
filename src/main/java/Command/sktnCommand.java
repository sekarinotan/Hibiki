/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command;

import java.time.format.DateTimeFormatter;
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
public class sktnCommand extends Command {

    @Override
    public void onCommand(MessageReceivedEvent e, String[] args) {
        if (e.getAuthor().getId().equals("204543702927015937")) {
            switch (args[0]) {
                case "nee?":
                    sendMessage(e, "nee");
                    break;
                case "oyoyo":
                    sendMessage(e, "ufufu");
                    break;
                case "hehehe":
                    sendMessage(e, "hehehe");
                    break;
                case "^_^":
                    sendMessage(e, "cute");
                    break;
                default:
                    return;
            }
        }
    }

    @Override
    public List<String> getAliases() {
        return Arrays.asList("nee?", "oyoyo", "hehehe","^_^"); //To change body of generated methods, choose Tools | Templates.
    }

}
