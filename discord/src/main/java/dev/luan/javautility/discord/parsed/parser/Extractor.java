package dev.luan.javautility.discord.parsed.parser;

public abstract class Extractor<T> {

    public abstract T extract(String s);

}