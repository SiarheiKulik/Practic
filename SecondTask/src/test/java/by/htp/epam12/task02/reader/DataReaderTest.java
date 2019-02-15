package by.htp.epam12.task02.reader;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class DataReaderTest {



    @Test
    public void readDataFileTest(){
        String PATH = "/data.txt";
        List<String> expected = Arrays.asList(" It has survived - not only (five) centures, but also the leap into 13<<2 electronic\n" +
                "typesetting, remaining 3>>5 essentially ~6&9|(3&4) unchanged.");
        List<String> actual = new DataReader().readDataFile(PATH);

        Assert.assertEquals(expected,actual);
    }
}
