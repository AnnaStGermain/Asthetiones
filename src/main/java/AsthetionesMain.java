import commands.Embeds;
import commands.Misc;
import moderation.Kick;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.security.auth.login.LoginException;

public class AsthetionesMain extends ListenerAdapter {

    public static void main(String[] args) throws LoginException{
        JDA jda = new JDABuilder(args[0]).setActivity(Activity.playing("+help to see commands")).build();

        jda.addEventListener(
                new AsthetionesMain(),
                new Embeds(),
                new Misc(),
                new Kick()
        );
    }

    public void onMessageReceived(MessageReceivedEvent event) {

        System.out.println("New message from " +
                event.getAuthor().getName() + ": " +
                event.getMessage().getContentDisplay()
        );
    }
}
