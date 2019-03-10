import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.*;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import javax.security.auth.login.LoginException;
import commands.Embeds;
import commands.Misc;
import moderation.Kick;

public class AsthetionesMain extends ListenerAdapter {

    public static void main(String[] args) throws LoginException{
        JDABuilder builder = new JDABuilder(AccountType.BOT);
        String token = args[0];
        builder.setToken(token);

        builder.addEventListener(
                new AsthetionesMain(),
                new Embeds(),
                new Misc(),
                new Kick()
        );
        builder.setGame(Game.playing("+help to see commands"));
        builder.buildAsync();
    }

    public void onMessageReceived(MessageReceivedEvent event) {

        System.out.println("New message from " +
                event.getAuthor().getName() + ": " +
                event.getMessage().getContentDisplay()
        );
    }
}
