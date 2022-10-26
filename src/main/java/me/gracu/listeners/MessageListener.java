package me.gracu.listeners;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.entities.emoji.Emoji;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;

public class MessageListener extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        User author = event.getAuthor();
        Message message = event.getMessage();
        MessageChannel channel = event.getChannel();
        TextChannel suggestions = event.getGuild().getTextChannelById("1033769806551334952");

        EmbedBuilder embedSuggestion = new EmbedBuilder();
        embedSuggestion.addField("Propozycję wysłał:", author.getAsMention(), false);
        embedSuggestion.setColor(Color.red);
        embedSuggestion.addField("Propozycja:", message.getContentRaw(), true);
        embedSuggestion.setAuthor(author.getName(), null, author.getAvatarUrl());
        embedSuggestion.setThumbnail("https://seeklogo.com/images/M/minecraft-logo-5EAD3A1535-seeklogo.com.png");

        //TODO: Add bot settings configuration to file.
        if (!event.getAuthor().isBot() && suggestions != null) {
            if (channel.equals(suggestions)) {
                message.delete().queue();
                Message embed = suggestions.sendMessageEmbeds(embedSuggestion.build()).complete();
                embed.addReaction(Emoji.fromCustom("tak", 1033797988650319872L, false)).queue();
                embed.addReaction(Emoji.fromCustom("nie", 1033798002520903752L, false)).queue();
                embed.createThreadChannel("Dyskusja").queue();
            }
        }
    }
}
