package com.brano.print;

public enum TextStyle implements TextAttribute {

    BORDER("51"), INVERT("7"),
    BOLD("1"), CROSS("9"), ITALICS("3"), UNDERLINED("4"), UNDERLINED_BOLD("21");

    private final String code;

    TextStyle(String code) {
        this.code = code;
    }

    @Override
    public String code() {
        return code;
    }

    @Override
    public String toString() {
        return code();
    }

}
