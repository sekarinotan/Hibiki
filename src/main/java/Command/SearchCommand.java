/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command;

import java.util.Arrays;
import java.util.List;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import org.apache.commons.lang3.StringUtils;
import util.GoogleSearch;
import util.SearchResult;

/**
 *
 * @author adminpc
 */
public class SearchCommand extends Command {

    @Override
    public void onCommand(MessageReceivedEvent e, String[] args) {
        String filter = null;
        switch (args[0]) {
            case "/google":
            case "/g":
                break;
            default:
                return;
        }

        List<SearchResult> results = GoogleSearch.performSearch(
                "018291224751151548851%3Ajzifriqvl1o",
                StringUtils.join(args, "+", 1, args.length)
                + ((filter != null) ? ("+" + filter) : ""));

        sendMessage(e, results.get(0).getSuggestedReturn());
    }

    @Override
    public List<String> getAliases() {
        return Arrays.asList("/google", "/g");
    }

}
