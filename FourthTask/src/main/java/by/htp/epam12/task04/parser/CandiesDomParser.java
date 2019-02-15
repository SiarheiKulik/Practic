package by.htp.epam12.task04.parser;

import by.htp.epam12.task04.builder.XMLBuilder;
import by.htp.epam12.task04.entity.Candy;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CandiesDomParser implements XMLBuilder {

    private final static Logger lOGGER = LogManager.getLogger();
    private List<Candy> candies;
    private DocumentBuilder documentBuilder;

    public CandiesDomParser() {
        candies = new ArrayList<>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            documentBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            lOGGER.log(Level.FATAL, "e ");
        }

    }

    public List<Candy> buildListCandies(String fileName) {
        try {
            Document doc = documentBuilder.parse(fileName);
            doc.getDocumentElement().normalize();
            NodeList candyNodeList = doc.getElementsByTagName("candy");

            for (int i = 0; i < candyNodeList.getLength(); i++) {
                Node node = candyNodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    candies.add(createCandyFromElement((Element) node));
                }
            }
        } catch (SAXException | IOException e) {
            lOGGER.log(Level.ERROR, "e");
        }
        return candies;
    }

    private Candy createCandyFromElement(Element candyElement) {

        Candy candy = new Candy();
        candy.setId(candyElement.getAttribute(CandyСontent.ID.getValue()));
        candy.setType(candyElement.getAttribute(CandyСontent.TYPE.getValue()));
        if (candyElement.hasAttribute(CandyСontent.TOPPING.getValue())) {
            candy.setTopping(candyElement.getAttribute(CandyСontent.TOPPING.getValue()));
        } else {
            candy.setTopping("");
        }

        candy.setName(candyElement.getElementsByTagName(CandyСontent.NAME.getValue()).item(0).getTextContent());
        candy.setEnergy(Integer.valueOf(candyElement.getElementsByTagName(CandyСontent.ENERGY.getValue()).item(0).getTextContent()));
        String water = candyElement.getElementsByTagName(CandyСontent.WATER.getValue()).item(0).getTextContent();
        candy.getIngredients().setWater(Integer.valueOf(water));
        String sugar = candyElement.getElementsByTagName(CandyСontent.SUGAR.getValue()).item(0).getTextContent();
        candy.getIngredients().setSugar(Integer.valueOf(sugar));
        String fructose = candyElement.getElementsByTagName(CandyСontent.FRUCTOSE.getValue()).item(0).getTextContent();
        candy.getIngredients().setFructose(Integer.valueOf(fructose));
        String vanilla = candyElement.getElementsByTagName(CandyСontent.VANILLA.getValue()).item(0).getTextContent();
        candy.getIngredients().setVanilla(Integer.valueOf(vanilla));
        if (candyElement.getElementsByTagName(CandyСontent.CHOCOLATETYPE.getValue()).item(0) != null) {
            candy.getIngredients()
                    .setChocolatetype(candyElement.getElementsByTagName(CandyСontent.CHOCOLATETYPE.getValue()).item(0).getTextContent());
        } else {
            candy.getIngredients().setChocolatetype("");
        }
        String proteins = candyElement.getElementsByTagName(CandyСontent.PROTEINS.getValue()).item(0).getTextContent();
        candy.getValue().setProteins(Integer.valueOf(proteins));
        candy.getValue().setFats(Integer.valueOf(candyElement.getElementsByTagName(CandyСontent.FATS.getValue()).item(0).getTextContent()));
        candy.getValue().setCarbohydrates(Integer.valueOf(candyElement.getElementsByTagName(CandyСontent.CARBOHYDRATES.getValue()).item(0).getTextContent()));
        candy.setProduction(candyElement.getElementsByTagName(CandyСontent.PRODUCTION.getValue()).item(0).getTextContent());

        return candy;
    }


    public List<Candy> getCandies() {

        return candies;
    }

    private static String getElementTextContent(Element element, String elementName) {
        NodeList nList = element.getElementsByTagName(elementName);
        Node node = nList.item(0);
        String text = node.getTextContent();
        return text;
    }


}
