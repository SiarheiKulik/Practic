package by.htp.epam12.task04.parser;

import by.htp.epam12.task04.entity.Candy;
import by.htp.epam12.task04.exception.ProjectException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import static java.lang.String.valueOf;

public class CandyHandler extends DefaultHandler {

    private final static Logger lOGGER = LogManager.getLogger();

    private List<Candy> candiesList;
    private Candy currentCandy;
    private CandyСontent сontent;
    private EnumSet<CandyСontent> withText;

    public CandyHandler() {
        candiesList = new ArrayList<Candy>();
        withText = EnumSet.range(CandyСontent.NAME, CandyСontent.PRODUCTION);
    }

    public List<Candy> getCandies() {
        return candiesList;
    }


    @Override
    public void startDocument() throws SAXException {
        lOGGER.log(Level.INFO, "Start to parse the document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attrs) throws SAXException {
        if (CandyСontent.CANDY.equals(localName)) {
            currentCandy = new Candy();
            currentCandy.setId(attrs.getValue(valueOf(CandyСontent.ID)));
            currentCandy.setType(setTypeAtribute(attrs));

            if (attrs.getValue(valueOf(CandyСontent.TOPPING)) != null) {
                currentCandy.setTopping(attrs.getValue(valueOf(CandyСontent.TOPPING)));
            } else {
                currentCandy.setTopping("none");
            }

        } else {
            CandyСontent temp = CandyСontent.valueOf(localName.toUpperCase());
            if (withText.contains(temp)) {
                сontent = temp;
            }
        }
    }

    private String setTypeAtribute(Attributes attr) {
        String type = new String(attr.getValue(valueOf(CandyСontent.TYPE)));
        switch (сontent) {
            case CARAMEL:
                currentCandy.setType(type);
                break;
            case SOUFFLE:
                currentCandy.setType(type);
            case CHOCOLATE:
                currentCandy.setType(type);
                break;
            default:
                try {
                    throw new ProjectException();
                } catch (ProjectException e) {
                    lOGGER.log(Level.ERROR, "can't find attribute with such name ");
                }

        }return type;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (CandyСontent.CANDY.equals(localName)) {
            candiesList.add(currentCandy);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String text = new String(ch, start, length).trim();
        if (сontent != null) {
            switch (сontent) {
                case NAME:
                    currentCandy.setName(text);
                    break;
                case ENERGY:
                    currentCandy.setEnergy(Integer.parseInt(text));
                    break;
                case WATER:
                    currentCandy.getIngredients().setWater(Integer.parseInt(text));
                    break;
                case SUGAR:
                    currentCandy.getIngredients().setSugar(Integer.parseInt(text));
                    break;
                case FRUCTOSE:
                    currentCandy.getIngredients().setFructose(Integer.parseInt(text));
                    break;
                case VANILLA:
                    currentCandy.getIngredients().setVanilla(Integer.parseInt(text));
                    break;
                case CHOCOLATETYPE:
                    currentCandy.getIngredients().setChocolatetype(text);
                    break;
                case PROTEINS:
                    currentCandy.getValue().setProteins(Integer.parseInt(text));
                    break;
                case FATS:
                    currentCandy.getValue().setFats(Integer.parseInt(text));
                    break;
                case CARBOHYDRATES:
                    currentCandy.getValue().setCarbohydrates(Integer.parseInt(text));
                    break;
                default:
                    try {
                        throw new ProjectException();
                    } catch (ProjectException e) {
                        lOGGER.log(Level.ERROR, "can't find attribute with such name ");
                    }
            }
            сontent = null;
        }

    }

    @Override
    public void endDocument() throws SAXException {
        lOGGER.log(Level.INFO, "Start to parse the document");

    }


}

