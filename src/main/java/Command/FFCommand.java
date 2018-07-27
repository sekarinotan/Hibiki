package Command;

import java.util.Arrays;
import java.util.List;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author adminpc
 */
public class FFCommand extends Command {

    @Override
    public void onCommand(MessageReceivedEvent e, String[] args) {
        List<User> mu = e.getMessage().getMentionedUsers();
        switch (args[0]) {
            case "/slap":
                if (checkMention(mu)) {
                    if (mu.get(0).isBot()) {
                        sendMessage(e, mu.get(0).getAsMention()+ " slaps " + e.getAuthor().getAsMention() );
                    } else {
                        sendMessage(e, e.getAuthor().getAsMention() + " slaps " + mu.get(0).getAsMention());
                    }
                }
                break;
            case "/yoldance":
//                sendMessage(e, e.getAuthor().getAsMention() + " Your dps : " + roll);
                break;
            default:
                return;
        }
    }

    @Override
    public List<String> getAliases() {
        return Arrays.asList("/slap", "/yoldance");
    }

    public boolean checkMention(List list) {
        if (list.isEmpty()) {
            return false;
        } else if (list.size() > 2) {
            return false;
        } else {
            return true;
        }
    }
}
