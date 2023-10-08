package com.brano.print;

import java.util.*;
import java.util.jar.Attributes;
import java.util.stream.Collectors;

public class Formatter {


    public static String compose(List<TextAttribute> attributes) {
        return "\033[" + attributes.stream()
                .map(TextAttribute::code)
                .collect(Collectors.joining(";")) + "m";
    }

    public static String reset() {
        return compose(List.of());
    }




    private String text;
    private final Set<TextStyle> attributes;
    private TextColor color;
    private BackgroundColor backgroundColor;


    public Formatter(String text, TextAttribute ... attributes) {
        this.text = text;
        this.attributes = new HashSet<>();
        addAll(attributes);
    }


    public void addAll(TextAttribute ... attributes) {
        Arrays.stream(attributes).forEach(this::add);
    }

    public void add(TextAttribute attribute) {
        if (attribute instanceof TextColor)
            setColor((TextColor) attribute);
        if (attribute instanceof BackgroundColor)
            setBackgroundColor((BackgroundColor) attribute);
        if (attribute instanceof TextStyle)
            getAttributes().add((TextStyle) attribute);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Set<TextStyle> getAttributes() {
        return attributes;
    }

    public TextColor getColor() {
        return color;
    }

    public void setColor(TextColor color) {
        this.color = color;
    }

    public BackgroundColor getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(BackgroundColor backgroundColor) {
        this.backgroundColor = backgroundColor;
    }


    public String format() {
        List<TextAttribute> format = new ArrayList<>();
        if (attributes != null)
            format.addAll(attributes);
        if (color != null)
            format.add(color);
        if (backgroundColor != null)
            format.add(backgroundColor);

        if(format.isEmpty())
            return text;
        return compose(format) + text + reset();
    }

    @Override
    public String toString() {
        return "Formatter{" +
                "text='" + text + '\'' +
                ", attributes=" + attributes +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Formatter formatter = (Formatter) o;
        return Objects.equals(text, formatter.text) && Objects.equals(attributes, formatter.attributes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text, attributes);
    }
}
