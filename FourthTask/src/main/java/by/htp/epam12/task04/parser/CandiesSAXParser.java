package by.htp.epam12.task04.parser;

import by.htp.epam12.task04.builder.XMLBuilder;
import by.htp.epam12.task04.entity.Candy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.util.List;

public class CandiesSAXParser implements XMLBuilder {

    private final static Logger lOGGER = LogManager.getLogger();

    private List<Candy> candies;
    private CandyHandler candyHandler;
    private XMLReader reader;
    private static final String FILE_NAME = "files/Task4.xml";

    public CandiesSAXParser(){
        candyHandler = new CandyHandler();
        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(candyHandler);
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    public List<Candy> buildListCandies(String fileName) {
        try {
            reader.parse(FILE_NAME);
        } catch (IOException e) {

        } catch (SAXException e) {
            e.printStackTrace();
        }
        candies=candyHandler.getCandies();

        return candies;

    }
    public List<Candy> getCandies(){

        return candies;
    }
}
