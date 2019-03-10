import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.*;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import javax.security.auth.login.LoginException;
import commands.Embeds;
import commands.ImageCommands;
import commands.Misc;
import commands.Moderation;

public class AsthetionesMain extends ListenerAdapter {

    public static void main(String[] args) throws LoginException{
        JDABuilder builder = new JDABuilder(AccountType.BOT);
        String token = "NTQ4NzIwMTQ2Nzg1NjMyMjU2.D1Jhsw.6EW_9aF1YifM42RZcny7Is0YG-g";
        builder.setToken(token);

        builder.addEventListener(
                new AsthetionesMain(),
                new Embeds(),
                new ImageCommands(),
                new Misc(),
                new Moderation()
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
