/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command;

import java.io.File;
import java.util.List;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.MessageBuilder;
import net.dv8tion.jda.core.entities.ChannelType;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageEmbed;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import net.dv8tion.jda.core.requests.restaction.MessageAction;

public abstract class Command extends ListenerAdapter {

    public abstract void onCommand(MessageReceivedEvent e, String[] args);

    public abstract List<String> getAliases();

    @Override
    public void onMessageReceived(MessageReceivedEvent e) {
        if (e.getAuthor().isBot() && !respondToBots()) {
            return;
        }
        if (containsCommand(e.getMessage())) {
            onCommand(e, commandArgs(e.getMessage()));
        }
    }

    protected boolean containsCommand(Message message) {
        return getAliases().contains(commandArgs(message)[0]);
    }

    protected String[] commandArgs(Message message) {
        return commandArgs(message.getContentDisplay());
    }

    protected String[] commandArgs(String string) {
        return string.split(" ");
    }

    protected Message sendMessage(MessageReceivedEvent e, Message message) {
        if (e.isFromType(ChannelType.PRIVATE)) {
            return e.getPrivateChannel().sendMessage(message).complete();
        } else {
            return e.getTextChannel().sendMessage(message).complete();
        }
    }

    protected Message sendMessage(MessageReceivedEvent e, String message) {
        return sendMessage(e, new MessageBuilder().append(message).build());
    }

    protected Message sendMessageEmbed(MessageReceivedEvent e, EmbedBuilder eb) {
        if (e.isFromType(ChannelType.PRIVATE)) {
            return e.getPrivateChannel().sendMessage(eb.build()).complete();
        } else {
            return e.getTextChannel().sendMessage(eb.build()).complete();
        }
    }

    protected Message sendFile(MessageReceivedEvent e, File file) {
        if (e.isFromType(ChannelType.PRIVATE)) {
            return e.getPrivateChannel().sendFile(file).complete();
        } else {
            return e.getTextChannel().sendFile(file).complete();
        }
    }

    protected Message sendFileMessage(MessageReceivedEvent e, File file, String message) {
        if (e.isFromType(ChannelType.PRIVATE)) {
            return e.getPrivateChannel().sendFile(file, message).complete();
        } else {
            return e.getTextChannel().sendFile(file, message).complete();
        }
    }

    protected boolean respondToBots() {
        return false;
    }

}
