package dev.luan.javautility.discord;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class CommandManager extends ListenerAdapter {

    private final JDA jda;

    public CommandManager(JDA jda) {
        this.jda = jda;
    }
}
