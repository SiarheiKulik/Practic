package by.htp.epam12.task01.reader;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class DataFileReaderTest {

String path = "data/data.txt";

@Test
public void readDataTest(){
    List<String> expected = new ArrayList<>();
    expected.add("1.0 2.5");
    expected.add("2.5 4.0");
    expected.add("4.0 3.0");
    expected.add("1.5 2.5");
    expected.add("-5.0 2.0");
    expected.add("3.0 7.0");
    expected.add("5.0 1.0");
    expected.add("4/' 5.0");
    System.out.print(expected.toString());
    List<String> actual = null;
    actual=new DataFileReader().readData(path);
    Assert.assertEquals(actual,expected);
}

}
