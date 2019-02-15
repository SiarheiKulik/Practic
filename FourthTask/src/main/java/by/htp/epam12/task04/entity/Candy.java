package by.htp.epam12.task04.entity;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "Candy",
        propOrder = {"name", "energy", "ingredients", "value", "production"}
)
public class Candy {
    @XmlElement(
            required = true
    )
    private String name;
    @XmlElement(
            required = true
    )
    @XmlSchemaType(
            name = "nonNegativeInteger"
    )
    private Integer energy;
    @XmlElement(
            required = true
    )
    private Ingredients ingredients;
    @XmlElement(
            required = true
    )
    private Value value;
    @XmlElement(
            required = true
    )
    private String production;
    @XmlAttribute(
            name = "id",
            required = true
    )
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    private String id;
    @XmlAttribute(
            name = "type",
            required = true
    )
    private String type;
    @XmlAttribute(
            name = "topping"
    )
    private String topping;

    public Candy(String id, String type,String topping, String name, Integer energy, Ingredients ingredients, Value value, String production) {
        this.id = id;
        this.type = type;
        this.topping = topping;
        this.name = name;
        this.energy = energy;
        this.ingredients = ingredients;
        this.value = value;
        this.production = production;

    }

    public Candy() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public Integer getEnergy() {
        return this.energy;
    }

    public void setEnergy(Integer value) {
        this.energy = value;
    }

    public Ingredients getIngredients() {
        return this.ingredients;
    }

    public void setIngredients(Ingredients value) {
        this.ingredients = value;
    }

    public Value getValue() {
        return this.value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    public String getProduction() {
        return this.production;
    }

    public void setProduction(String value) {
        this.production = value;
    }

    public String getId() {
        return this.id;
    }


    public void setId(String id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setTopping(String topping) {
        this.topping = topping;
    }
}
