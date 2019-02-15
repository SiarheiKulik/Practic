package by.htp.epam12.task04.validator;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class XmlValidator {
    private final static Logger lOGGER = LogManager.getLogger();

    private Path filePath;
    private Path schemaPath;

    public XmlValidator(Path filePath, Path schemaPath) {
        this.filePath = filePath;
        this.schemaPath = schemaPath;
    }

    public boolean validate() {
        String language = "http://www.w3.org/2001/XMLSchema";
        SchemaFactory factory = SchemaFactory.newInstance(language);


        try {
            Schema schema = factory.newSchema(schemaPath.toFile());
            Validator validator = schema.newValidator();
            Source source = new StreamSource(filePath.toFile());
            validator.validate(source);
            lOGGER.log(Level.INFO, "Document is valid!");
            return true;
        } catch (SAXException var9) {
            lOGGER.log(Level.ERROR, "Validation error. " + var9.getMessage());
        } catch (IOException var10) {
            lOGGER.log(Level.ERROR, ("File is not valid. " + var10.getMessage()));
        }
        return false;
    }
}
