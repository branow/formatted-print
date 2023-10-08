package com.brano.print;

public enum TextColor implements TextAttribute {

    BLACK("30"), RED("31"), GREEN("32"), YELLOW("33"), BLUE("34"),
    PURPLE("35"), CYAN("36"), WHITE("37"),

    BLACK_BRIGHT("90"), RED_BRIGHT("91"), GREEN_BRIGHT("92"), YELLOW_BRIGHT("93"),
    BLUE_BRIGHT("94"), PURPLE_BRIGHT("95"), CYAN_BRIGHT("96"), WHITE_BRIGHT("97");

    public static TextColor bright(TextColor color) {
        String suffix = "_BRIGHT";
        String name = color.name();
        if (name.contains(suffix))
            return color;
        String bright = name + suffix;
        return TextColor.valueOf(bright);
    }

    private final String code;

    TextColor(String code) {
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
