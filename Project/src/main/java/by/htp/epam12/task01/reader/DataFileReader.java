package by.htp.epam12.task01.reader;

import by.htp.epam12.task01.validator.DataValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class DataFileReader {
    private final static Logger logger = LogManager.getLogger();
    private final static String DEFAULT_FILE_PATH = "data/defaultData.txt";


    public List<String> readData(String filePath) {

        if (!Files.exists(Paths.get(filePath))) {
            filePath = DEFAULT_FILE_PATH;
            logger.log(Level.ERROR, "Data file not found! Used default data file.");
        }

        List<String> dataList;

        try {
            dataList = Files.lines(Paths.get(filePath)).collect(Collectors.toList());

        } catch (IOException e) {
            logger.log(Level.FATAL, "Can't read file: " + filePath, e);
            throw new RuntimeException("Can't read file ", e);
        }
        DataValidator validator = new DataValidator();


        return validator.checkCorrectData(dataList);
    }


}
