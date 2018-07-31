/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import org.jsoup.nodes.Element;
import util.Lodestone;
import util.LodestoneManager;

/**
 *
 * @author adminpc
 */
public class LodestoneCommand extends Command {

    @Override
    public void onCommand(MessageReceivedEvent e, String[] args) {
        if (args.length == 4) {
            try {
                Lodestone ls = LodestoneManager.getInstance(args).getLodestone();
                EmbedBuilder eb = new EmbedBuilder();
                eb.setAuthor(ls.getCharacterName(), ls.getLodestoneLink(), ls.getAvatarLink());
                eb.setImage(ls.getGlamourLink());
                sendMessageEmbed(e, eb);
            } catch (IOException ex) {
                Logger.getLogger(LodestoneCommand.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public List<String> getAliases() {
        return Arrays.asList("/glamour");
    }

}
