package com.brano.print;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.jar.Attributes;
import java.util.stream.Collectors;

public class Print {

    public static Print form() {
        return form("");
    }

    public static Print form(Object o, TextAttribute...attributes) {
        return new Print(o, attributes);
    }

    private final Deque<Formatter> formatters;

    Print(Object o, TextAttribute... attributes) {
        formatters = new LinkedList<>();
        formatters.add(new Formatter(o.toString(), attributes));
    }


    public void print() {
        System.out.print(this);
    }

    public void println() {
        System.out.println(this);
    }

    public void printf(Object... arg) {
        System.out.printf(this.toString(), arg);
    }


    public Print and(Object o) {
        Formatter formatter = current();
        formatter.setText(formatter.getText() + o);
        return this;
    }

    public Print add(Object o) {
        formatters.add(new Formatter(o.toString()));
        return this;
    }


    public Print format(TextAttribute... attribute) {
        current().addAll(attribute);
        return this;
    }

    public Print newLine() {
        return and("\n");
    }

    public Print tab() {
        return and("\t");
    }

    public Print space() {
        return and(" ");
    }

    public Print dot() {
        return and(".");
    }

    public Print coma() {
        return and(",");
    }


    public Print black() {
        format(TextColor.BLACK);
        return this;
    }

    public Print red() {
        format(TextColor.RED);
        return this;
    }

    public Print green() {
        format(TextColor.GREEN);
        return this;
    }

    public Print yellow() {
        format(TextColor.YELLOW);
        return this;
    }

    public Print blue() {
        format(TextColor.BLUE);
        return this;
    }

    public Print purple() {
        format(TextColor.PURPLE);
        return this;
    }

    public Print cyan() {
        format(TextColor.CYAN);
        return this;
    }

    public Print white() {
        format(TextColor.WHITE);
        return this;
    }

    public Print bright() {
        TextColor color = current().getColor();
        if (color != null) {
            format(TextColor.bright(color));
        }
        return this;
    }



    public Print backgroundBlack() {
        format(BackgroundColor.BLACK);
        return this;
    }

    public Print backgroundRed() {
        format(BackgroundColor.RED);
        return this;
    }

    public Print backgroundGreen() {
        format(BackgroundColor.GREEN);
        return this;
    }

    public Print backgroundYellow() {
        format(BackgroundColor.YELLOW);
        return this;
    }

    public Print backgroundBlue() {
        format(BackgroundColor.BLUE);
        return this;
    }

    public Print backgroundPurple() {
        format(BackgroundColor.PURPLE);
        return this;
    }

    public Print backgroundCyan() {
        format(BackgroundColor.CYAN);
        return this;
    }

    public Print backgroundWhite() {
        format(BackgroundColor.WHITE);
        return this;
    }

    public Print backgroundBright() {
        BackgroundColor color = current().getBackgroundColor();
        if (color != null) {
            format(BackgroundColor.bright(color));
        }
        return this;
    }


    public Print border() {
        format(TextStyle.BORDER);
        return this;
    }

    public Print invert() {
        format(TextStyle.INVERT);
        return this;
    }

    public Print bold() {
        format(TextStyle.BOLD);
        return this;
    }

    public Print cross() {
        format(TextStyle.CROSS);
        return this;
    }

    public Print italic() {
        format(TextStyle.ITALICS);
        return this;
    }

    public Print underline() {
        format(TextStyle.UNDERLINED);
        return this;
    }

    public Print underlinedBold() {
        format(TextStyle.UNDERLINED_BOLD);
        return this;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Print print = (Print) o;
        return Objects.equals(formatters, print.formatters);
    }

    @Override
    public int hashCode() {
        return Objects.hash(formatters);
    }

    @Override
    public String toString() {
        return formatters.stream().map(Formatter::format).collect(Collectors.joining());
    }

    private Formatter current() {
        return formatters.getLast();
    }
}
