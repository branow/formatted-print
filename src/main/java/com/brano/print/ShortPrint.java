package com.brano.print;

import java.util.Objects;

public class ShortPrint {

    public static ShortPrint form() {
        return form("");
    }

    public static ShortPrint form(Object o, TextAttribute...attributes) {
        return new ShortPrint(Print.form(o, attributes));
    }

    public static ShortPrint form(Print print) {
        return new ShortPrint(print);
    }

    private final Print print;

    ShortPrint(Print print) {
        this.print = print;
    }


    public void print() {
        print.print();
    }

    public void println() {
        print.println();
    }

    public void printf(Object... arg) {
        print.printf(arg);
    }


    public ShortPrint and(Object o) {
        return form(print.and(o));
    }

    public ShortPrint add(Object o) {
        return form(print.add(o));
    }


    public ShortPrint format(TextAttribute... attribute) {
        return form(print.format(attribute));
    }


    public ShortPrint rp(int count) {
        return form(print.rp(count));
    }

    public ShortPrint ln() {
        return form(print.newLine());
    }

    public ShortPrint tab() {
        return form(print.tab());
    }

    public ShortPrint sp() {
        return form(print.space());
    }

    public ShortPrint dot() {
        return form(print.dot());
    }

    public ShortPrint com() {
        return form(print.coma());
    }


    public ShortPrint black() {
        return form(print.black());
    }

    public ShortPrint red() {
        return form(print.red());
    }

    public ShortPrint green() {
        return form(print.green());
    }

    public ShortPrint yellow() {
        return form(print.yellow());
    }

    public ShortPrint blue() {
        return form(print.blue());
    }

    public ShortPrint purple() {
        return form(print.purple());
    }

    public ShortPrint cyan() {
        return form(print.cyan());
    }

    public ShortPrint white() {
        return form(print.white());
    }

    public ShortPrint br() {
        return form(print.bright());
    }


    public ShortPrint bgBlack() {
        return form(print.backgroundBlack());
    }

    public ShortPrint bgRed() {
        return form(print.backgroundRed());
    }

    public ShortPrint bgGreen() {
        return form(print.backgroundGreen());
    }

    public ShortPrint bgYellow() {
        return form(print.backgroundYellow());
    }

    public ShortPrint bgBlue() {
        return form(print.backgroundBlue());
    }

    public ShortPrint bgPurple() {
        return form(print.backgroundPurple());
    }

    public ShortPrint bgCyan() {
        return form(print.backgroundCyan());
    }

    public ShortPrint bgWhite() {
        return form(print.backgroundWhite());
    }

    public ShortPrint bgBr() {
        return form(print.backgroundBright());
    }


    public ShortPrint bord() {
        return form(print.border());
    }

    public ShortPrint inv() {
        return form(print.invert());
    }

    public ShortPrint b() {
        return form(print.bold());
    }

    public ShortPrint cr() {
        return form(print.cross());
    }

    public ShortPrint it() {
        return form(print.italic());
    }

    public ShortPrint und() {
        return form(print.underline());
    }

    public ShortPrint undB() {
        return form(print.underlinedBold());
    }


    @Override
    public String toString() {
        return print.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShortPrint that = (ShortPrint) o;
        return Objects.equals(print, that.print);
    }

    @Override
    public int hashCode() {
        return Objects.hash(print);
    }
}
