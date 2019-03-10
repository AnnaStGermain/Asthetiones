package commands;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.ChannelType;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.awt.*;

public class Embeds extends ListenerAdapter {


    public void onMessageReceived(MessageReceivedEvent event) {

        Message message = event.getMessage();
        String msg = message.getContentDisplay();
        EmbedBuilder embed = new EmbedBuilder();

        if (event.isFromType(ChannelType.TEXT)) {

            if (msg.equalsIgnoreCase("+help")) {

                embed.setAuthor(null, null, null);
                embed.setTitle("Asthetiones Commands");
                embed.setColor(Color.pink);
                embed.setDescription("+ and the command name to trigger the command.");
                embed.addField("Informaton", "owner", true);
                embed.addField("Fun", "ping, ravedog", true);
                embed.addField("Moderation", "kick", true);
                message.getChannel().sendMessage(embed.build()).complete();

            } else if (msg.equalsIgnoreCase("+owner")) {

                embed.setTitle("Asthetiones");
                embed.setThumbnail("https://cdn.discordapp.com/emojis/549677453266649108.gif?v=1");
                embed.setDescription("Creation date: 09/04/19");
                embed.addField("NotAnna", "https://github.com/AnnaStGermain", true);
                message.getChannel().sendMessage(embed.build()).complete();

            }
        }
    }
}
