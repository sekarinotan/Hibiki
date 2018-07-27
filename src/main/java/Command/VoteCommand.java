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
public class VoteCommand extends Command{

    private final Random rand = new Random();
    
    @Override
    public void onCommand(MessageReceivedEvent e, String[] args) {
        
        int choose = rand.nextInt(args.length-1)+1;
        System.out.println(choose);
        sendMessage(e,"**" + args[choose] + "**");
    }

    @Override
    public List<String> getAliases() {
        return Arrays.asList("/choose");
    }
}
