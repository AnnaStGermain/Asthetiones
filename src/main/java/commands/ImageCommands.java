package commands;

import net.dv8tion.jda.core.entities.ChannelType;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class ImageCommands extends ListenerAdapter {


    public void onMessageReceived(MessageReceivedEvent event) {

        MessageChannel channel = event.getChannel();
        Message message = event.getMessage();
        String msg = message.getContentDisplay();

        if (event.isFromType(ChannelType.TEXT)) {



    }
}

