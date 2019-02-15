package by.htp.epam12.task04.entity;


import javax.xml.bind.annotation.XmlRegistry;

@XmlRegistry

public class ObjectFactory {
    public ObjectFactory() {
    }

    public Candy createCandy() {
        return new Candy();
    }

    public Candies createCandies() {
        return new Candies();
    }

    public Ingredients createIngridients() {
        return new Ingredients();
    }

    public Value createCandyValue() {
        return new Value();
    }
}
