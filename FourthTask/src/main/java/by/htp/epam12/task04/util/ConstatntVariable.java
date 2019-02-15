package by.htp.epam12.task04.util;

public enum ConstatntVariable {
    NEWLINE("\n"),
    TAB("\t"),
    SLASH_REG_EXP("\\\\"),
    EMPTY_STRING("");

    private String value;

    ConstatntVariable(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
