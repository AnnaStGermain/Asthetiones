package commands;

import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.*;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.exceptions.PermissionException;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.util.List;

public class Moderation extends ListenerAdapter {

    public void onMessageReceived(MessageReceivedEvent event) {

        Message message = event.getMessage();
        String msg = message.getContentDisplay();
        MessageChannel channel = event.getChannel();
        if (msg.startsWith("+kick")) {
            if (message.isFromType(ChannelType.TEXT)) {

                if (message.getMentionedUsers().isEmpty()) {
                    channel.sendMessage("You need a user/users to kick.");
                } else {
                    Guild guild = event.getGuild();
                    Member selfMember = guild.getSelfMember();

                    if (!selfMember.hasPermission(Permission.KICK_MEMBERS)) {
                        channel.sendMessage("Did you really think I would do that?");
                        return;
                    }

                    List<User> mentionedUsers = message.getMentionedUsers();

                    for (User user : mentionedUsers) {

                        Member member = guild.getMember(user);

                        if (!selfMember.canInteract(member)) {

                            channel.sendMessage("Cannot kick member: ")
                                    .append(member.getAsMention())
                                    .append(", they're above you in rank.")
                                    .queue();

                            continue;
                        }

                        guild.getController().kick(member).queue(
                                success -> channel.sendMessage("Kicked ").append(member.getEffectiveName()).append(".").queue(),
                                error ->
                                {

                                    if (error instanceof PermissionException) {

                                        PermissionException pe = (PermissionException) error;
                                        Permission missingPermission = pe.getPermission();

                                        channel.sendMessage("PermissionError kicking [")
                                                .append(member.getEffectiveName()).append("]: ")
                                                .append(error.getMessage()).queue();
                                    } else {
                                        channel.sendMessage("Unknown error while kicking [")
                                                .append(member.getEffectiveName())
                                                .append("]: <").append(error.getClass().getSimpleName()).append(">: ")
                                                .append(error.getMessage()).queue();
                                    }
                                });

                    }
                }
            }
        }
    }

}
