package by.htp.epam12.task01.validator;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class DataValidatorTest {

    @Test
    public void checkCorrectDataTest(){
        DataValidator dataValidator = new DataValidator();

        List<String> expected = new ArrayList<>();
        expected.add("1.0 2.5");
        expected.add("2.5 4.0");
        expected.add("4.0 3.0");
        List<String> actual = new ArrayList<>(expected);
        Assert.assertEquals(dataValidator.checkCorrectData(actual),expected);



    }
}
