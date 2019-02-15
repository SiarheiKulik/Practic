package by.htp.epam12.task04.parser;

import by.htp.epam12.task04.builder.XMLBuilder;
import by.htp.epam12.task04.entity.Candy;
import by.htp.epam12.task04.entity.Ingredients;
import by.htp.epam12.task04.entity.Value;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.ArrayList;

import java.util.List;

@SuppressWarnings("unused")
public class CandiesStAXParser implements XMLBuilder {

    private final static Logger lOGGER = LogManager.getLogger();

    private List<Candy> candies;
    private XMLInputFactory inputFactory;

    public CandiesStAXParser() {
        candies = new ArrayList<>();
        inputFactory = XMLInputFactory.newInstance();
    }

    public List<Candy> getCandies() {
        return candies;
    }

    public List<Candy> buildListCandies(String fileName) {
        FileInputStream inputStream = null;
        XMLStreamReader streamReader = null;
        String name;

        try {

            inputStream = new FileInputStream(new File(fileName));
            streamReader = inputFactory.createXMLStreamReader(inputStream);

            while (streamReader.hasNext()) {
                int type = streamReader.next();
                if (type == XMLStreamConstants.START_ELEMENT) {
                    name = streamReader.getLocalName();
                    if (CandyСontent.valueOf(name.toUpperCase()) == CandyСontent.CANDY) {
                        Candy item = bildCandy(streamReader);
                        candies.add(item);
                    }
                }
            }
        } catch (IOException | XMLStreamException e) {
            e.printStackTrace();
        }
        return candies;
    }


    private Candy bildCandy(XMLStreamReader streamReader) throws XMLStreamException {
        Candy candy = new Candy();
        candy.setId(streamReader.getAttributeValue(null, CandyСontent.ID.getValue()));
        candy.setType(setCandyType(streamReader));

        String name;
        CandyСontent content;
        while (streamReader.hasNext()) {
            int type = streamReader.getEventType();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = streamReader.getLocalName();
                    content = CandyСontent.valueOf(name.toUpperCase());
                    switch (content) {
                        case NAME:
                            candy.setName(getXMLText(streamReader));
                            break;
                        case ENERGY:
                            candy.setEnergy(Integer.parseInt(getXMLText(streamReader)));
                            break;
                        case INGREDIENTS:
                            candy.setIngredients(getXMLIngredients(streamReader));
                            break;
                        case VALUE:
                            break;
                        case PRODUCTION:
                            candy.setProduction(getXMLText(streamReader));
                    }
                case XMLStreamConstants.END_ELEMENT:
                    name = streamReader.getLocalName();
                    if (CandyСontent.valueOf(name.toUpperCase()).equals(CandyСontent.CANDY)) {
                        return candy;
                    }
                    break;
            }
            streamReader.next();
        }
        throw new XMLStreamException("Unknown element in tag Candy");

    }

    private String setCandyType(XMLStreamReader reader) throws XMLStreamException {
        String name = null;

        if (getXMLText(reader).equals(CandyСontent.CARAMEL.getValue())) {
            name = CandyСontent.CARAMEL.getValue();
        }
        if (getXMLText(reader).equals(CandyСontent.CHOCOLATE.getValue())) {
            name = CandyСontent.CHOCOLATE.getValue();
        } else {
            name = CandyСontent.SOUFFLE.getValue();
        }

        return name;
    }

    private String setCandyTopping(XMLStreamReader reader) {
        String name = "none";
        if (reader.hasText()) {
            name = reader.getText();
        }
        return name;

    }

    private Ingredients getXMLIngredients(XMLStreamReader reader) throws XMLStreamException {
        Ingredients ingredients = new Ingredients();
        int type;
        String name;
        while (reader.hasNext()) {
            type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (CandyСontent.valueOf(name.toUpperCase())) {
                        case WATER:
                            ingredients.setWater(Integer.parseInt(getXMLText(reader)));
                            break;
                        case SUGAR:
                            ingredients.setSugar(Integer.parseInt(getXMLText(reader)));
                            break;
                        case FRUCTOSE:
                            ingredients.setFructose(Integer.parseInt(getXMLText(reader)));
                            break;
                        case VANILLA:
                            ingredients.setVanilla(Integer.parseInt(getXMLText(reader)));
                            break;
                        case CHOCOLATETYPE:
                            ingredients.setChocolatetype(getXMLText(reader));
                            break;
                    }
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (CandyСontent.valueOf(name.toUpperCase()).equals(CandyСontent.INGREDIENTS.getValue())) {
                        return ingredients;
                    }

            }
        }
        throw new XMLStreamException("Unknown element in tag Ingredients");
    }

    private Value getXMLValue(XMLStreamReader reader) throws XMLStreamException {
        Value value = new Value();
        int type;
        String name;
        while (reader.hasNext()) {
            type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (CandyСontent.valueOf(name.toUpperCase())) {
                        case PROTEINS:
                            value.setProteins(Integer.parseInt(getXMLText(reader)));
                            break;
                        case FATS:
                            value.setFats(Integer.parseInt(getXMLText(reader)));
                            break;
                        case CARBOHYDRATES:
                            value.setCarbohydrates(Integer.parseInt(getXMLText(reader)));
                            break;

                    }
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (CandyСontent.valueOf(name.toUpperCase()).equals(CandyСontent.VALUE.getValue()))

                        return value;
            }
        }
        throw new XMLStreamException("Unknown element in tag Value");
    }

    private String getXMLText(XMLStreamReader reader) throws XMLStreamException {
        String text = null;
        if (reader.hasNext()) {
            reader.next();
            text = reader.getText();
        }
        return text;
    }

}