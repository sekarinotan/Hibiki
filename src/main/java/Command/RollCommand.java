/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

/**
 *
 * @author adminpc
 */
public class RollCommand extends Command {

    private final Random rand = new Random();

    @Override
    public void onCommand(MessageReceivedEvent e, String[] args) {
        int roll;
        switch (args[0]) {
            case "/roll":
                roll = rand.nextInt(99) + 1;
                sendMessage(e, e.getAuthor().getAsMention() + " Your roll : " + roll);
                break;
            case "/checkdps":
                roll = rand.nextInt(20000) + 1;
                sendMessage(e, e.getAuthor().getAsMention() + " Your dps : " + roll);
                break;
            default:
                return;
        }
    }

    @Override
    public List<String> getAliases() {
        return Arrays.asList("/checkdps", "/roll");
    }
}
