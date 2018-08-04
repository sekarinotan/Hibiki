
import Command.FFCommand;
import Command.FFlogsCommand;
import Command.LodestoneCommand;
import Command.RollCommand;
import Command.SearchCommand;
import Command.StickerCommand;
import Command.VoteCommand;
import Command.etcCommand;
import Command.sktnCommand;
import javax.security.auth.login.LoginException;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import util.GoogleSearch;

public class Hibiki {

    public static void main(String[] args) throws LoginException, InterruptedException {
        setup();
    }

    private static void setup() throws LoginException {
        Configuration conf = ConfigurationManager.getInstance().getConfiguration();

        JDABuilder builder = new JDABuilder(AccountType.BOT).setToken(conf.getBotToken());
        builder.addEventListener(new RollCommand());
        builder.addEventListener(new FFCommand());
        builder.addEventListener(new VoteCommand());
        builder.addEventListener(new StickerCommand());
        builder.addEventListener(new etcCommand());
        builder.addEventListener(new LodestoneCommand());
        builder.addEventListener(new FFlogsCommand(conf.getFfLogsToken()));
        builder.addEventListener(new sktnCommand());

        if (conf.getGoogleToken() != null && !conf.getGoogleToken().isEmpty()) {
            GoogleSearch.setup(conf.getGoogleToken());
            builder.addEventListener(new SearchCommand());
        } else {
            System.out.println("No Google API Key provided, all search commands disabled");
        }
        builder.buildAsync();
    }
}
