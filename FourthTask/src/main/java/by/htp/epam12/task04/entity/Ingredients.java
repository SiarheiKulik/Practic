package by.htp.epam12.task04.entity;

import javax.xml.bind.annotation.*;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "Ingridients",
        propOrder = {"water", "sugar", "fructose", "chocolatetype", "vanilla"}
)
public class Ingredients {
    private int water;
    @XmlElement(
            required = true
    )
    @XmlSchemaType(
            name = "nonNegativeInteger"
    )
    private Integer sugar;
    @XmlElement(
            required = true
    )
    @XmlSchemaType(
            name = "nonNegativeInteger"
    )
    private Integer fructose;
    private String chocolatetype;
    @XmlElement(
            required = true
    )
    private Integer vanilla;

    public Ingredients() {
    }

    public Ingredients(int water, Integer sugar, Integer fructose, Integer vanilla, String chocolatetype) {
        this.water = water;
        this.sugar = sugar;
        this.fructose = fructose;
        this.chocolatetype = chocolatetype;
        this.vanilla = vanilla;
    }

    public int getWater() {
        return this.water;
    }

    public void setWater(int value) {
        this.water = value;
    }

    public Integer getSugar() {
        return this.sugar;
    }

    public void setSugar(Integer value) {
        this.sugar = value;
    }

    public Integer getFructose() {
        return this.fructose;
    }

    public void setFructose(Integer value) {
        this.fructose = value;
    }

    public String getChocolatetype() {
        return this.chocolatetype;
    }

    public void setChocolatetype(String value) {
        this.chocolatetype = value;
    }

    public Integer getVanilla() {
        return this.vanilla;
    }

    public void setVanilla(Integer value) {
        this.vanilla = value;
    }
}