package by.htp.epam12.reader;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataReader {

    private static final Logger logger = LogManager.getLogger();

    private static final String DATA_PATH = "/data/data.txt";

    public List<String> reader(String path){
        List<String> text = new ArrayList<>();
        File file = new File(path);
        if (!file.isFile()|| !file.exists()){
            path =  DATA_PATH;
            logger.log(Level.ERROR,"Wrong file for reading ");
        }
        try{
            text = Files.lines(Paths.get(path)).collect(Collectors.toList());
            for (String t:text) {
                System.out.println(t);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


        return text;
    }

}
