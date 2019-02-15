package by.htp.epam12.task04.validator;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

public class CandyErrorHandler extends DefaultHandler {

    private final static Logger lOGGER = LogManager.getLogger();

    public CandyErrorHandler() {
    }

    @Override
    public void warning(SAXParseException e) throws SAXException {
        lOGGER.log(Level.WARN, "", e);
    }

    @Override
    public void error(SAXParseException e) throws SAXException {
        lOGGER.log(Level.ERROR, "", e);
    }

    @Override
    public void fatalError(SAXParseException e) throws SAXException {
        lOGGER.log(Level.FATAL, "", e);
    }
}
