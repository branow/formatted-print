package com.brano;

import com.brano.print.*;
import org.junit.jupiter.api.Test;

import java.util.List;

class ConsoleTest {

    @Test
    public void combineFormatting() {
        List<Formatter> list = List.of(
                new Formatter("blue + purple", TextColor.BLUE, TextColor.PURPLE),
                new Formatter("bg cyan + bg green", BackgroundColor.CYAN, BackgroundColor.GREEN),
                new Formatter("bg cyan + purple", BackgroundColor.CYAN, TextColor.PURPLE),
                new Formatter("purple + bg cyan", TextColor.PURPLE, BackgroundColor.CYAN),
                new Formatter("border + red", TextStyle.BORDER, TextColor.RED),
                new Formatter("red + border", TextColor.RED, TextStyle.BORDER),
                new Formatter("bg blue + border", BackgroundColor.BLUE, TextStyle.BORDER),
                new Formatter("border + bg blue", TextStyle.BORDER, BackgroundColor.BLUE),
                new Formatter("invert + purple", TextStyle.INVERT, TextColor.PURPLE),
                new Formatter("invert + bg purple", TextStyle.INVERT, BackgroundColor.PURPLE),
                new Formatter("bold + yellow + bg blue + italic + underlined", TextStyle.BOLD, TextColor.YELLOW, BackgroundColor.BLUE, TextStyle.ITALICS, TextStyle.UNDERLINED),
                new Formatter("border + invert + cross + green", TextStyle.BORDER, TextStyle.INVERT, TextStyle.CROSS, TextColor.GREEN),
                new Formatter("underlined_bold + purple + bc red", TextStyle.UNDERLINED_BOLD, TextColor.PURPLE, BackgroundColor.RED),
                new Formatter("underlined_bold", TextStyle.UNDERLINED_BOLD),
                new Formatter("underlined", TextStyle.UNDERLINED),
                new Formatter("bold", TextStyle.BOLD)
        );
        list.stream().map(Formatter::format).forEach(System.out::println);
    }

    @Test
    public void outAllCodes() {
        String data = "Hello World!";

        for (int i=0; i<150; i++) {
            String info = i + " " + data;
            String prefix = "\033[" + i + "m";
            String suffix = "\033[m";
            System.out.println(prefix + info + suffix);
        }
    }

}
