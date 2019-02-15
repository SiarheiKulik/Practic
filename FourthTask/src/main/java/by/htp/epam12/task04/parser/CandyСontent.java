package by.htp.epam12.task04.parser;

public enum CandyСontent {
    CANDIES("candies"),
    CANDY("candy"),
    ID("id"),
    TOPPING("topping"),
    TYPE("type"),
    CHOCOLATE("chocolate"),
    CARAMEL("caramel"),
    SOUFFLE("souffle"),
    INGREDIENTS("ingredients"),
    NAME("name"),
    ENERGY("energy"),
    WATER("water"),
    SUGAR("sugar"),
    FRUCTOSE("fructose"),
    VANILLA("vanilla"),
    CHOCOLATETYPE("chocolatetype"),
    PROTEINS("proteins"),
    FATS("fats"),
    CARBOHYDRATES("carbohydrates"),
    PRODUCTION("production"),
    VALUE("value");

    private String value;

    public String getValue() {
        return value;
    }

    private CandyСontent(String value) {
        this.value = value;
    }

}
