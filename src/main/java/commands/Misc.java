package commands;

import net.dv8tion.jda.core.entities.ChannelType;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;


public class Misc extends ListenerAdapter {


    public void onMessageReceived(MessageReceivedEvent event) {

        Message message = event.getMessage();
        String msg = message.getContentDisplay();
        MessageChannel channel = event.getChannel();

        if (event.isFromType(ChannelType.TEXT)) {

            if (msg.equalsIgnoreCase("+ping")) {
                long startTime = System.currentTimeMillis();

                if (!event.getMember().getUser().isBot()) {

                    long passedTime = System.currentTimeMillis();
                    channel.sendMessage( ":ping_pong: " + (startTime - passedTime) + "ms.").queue();

                }
            } else if (msg.equalsIgnoreCase("+ravedog")) {

                channel.sendMessage("https://cdn.discordapp.com/emojis/549677453266649108.gif?v=1").queue();

            }
        }
    }
}
