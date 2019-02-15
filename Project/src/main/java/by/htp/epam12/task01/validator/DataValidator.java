package by.htp.epam12.task01.validator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataValidator {

    private static final String REGEX_LINE = "^\\d\\.\\d\\s\\d.\\d$";

    private boolean validData(String line) {
        return (line.matches(REGEX_LINE));
    }

    public List<String> checkCorrectData(List<String> dataList) {
        List<String> dataPoints = new ArrayList<>(dataList);
        Iterator<String> iter = dataPoints.iterator();
        while (iter.hasNext()) {
            if (!validData(iter.next())){
                iter.remove();
            }
        }
        return dataPoints;

    }
}
