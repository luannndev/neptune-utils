package dev.luan.javautility.discord.reciever;

import dev.luan.javautility.discord.parsed.ParsedCommand;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class ReceiveContext {

    private final ParsedCommand command;

    private final List<Object> args;

}