
import Command.FFCommand;
import Command.FFlogsCommand;
import Command.RollCommand;
import Command.StickerCommand;
import Command.VoteCommand;
import javax.security.auth.login.LoginException;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;

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
        builder.buildAsync();
    }
}
