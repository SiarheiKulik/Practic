package by.htp.epam12.task04.parser;

import by.htp.epam12.task04.entity.Candy;
import by.htp.epam12.task04.entity.Ingredients;
import by.htp.epam12.task04.entity.Value;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.LinkedList;
import java.util.List;

public class ParserTest {
    private List<Candy> expectedCandyList;
    private List<Candy> actualCandyList;
    private static final Path FILE_PATH = Paths.get("files", "Task4.xml");

    @BeforeTest
    public void initialize() {
        expectedCandyList = new LinkedList<>();
        expectedCandyList.add(new Candy("c1003","chocolate","coconut crisp","Alyonka",40,
                new Ingredients(40,70,0,5,"milk"),
                new Value(20,10,40),"Spartak"));
        expectedCandyList.add(new Candy("c1000","chocolate","no","Stolichnye",10,
                new Ingredients(10,45,0,5,"dark"),
                new Value(20,10,40),"Spartak"));
        expectedCandyList.add(new Candy("c1000","chocolate","no","Stolichnye",10,
                new Ingredients(10,45,0,5,"dark"),
                new Value(20,10,40),"Spartak"));

    }

    @AfterTest
    public void destroy() {
        expectedCandyList = null;
        actualCandyList = null;
    }

    @Test
    public void testSAXParser() {
        CandiesSAXParser candiesSAXParser = new CandiesSAXParser();
        candiesSAXParser.buildListCandies(FILE_PATH.toFile().getPath());
        actualCandyList = candiesSAXParser.getCandies();
        Assert.assertTrue(expectedCandyList.equals(actualCandyList));
    }

    @Test
    public void testDOMParser() {
        CandiesDomParser candiesDomParser = new CandiesDomParser();
        candiesDomParser.buildListCandies(FILE_PATH.toFile().getPath());
        actualCandyList = candiesDomParser.getCandies();
        Assert.assertTrue(expectedCandyList.equals(actualCandyList));
    }

    @Test
    public void testStAXParser() {
        CandiesStAXParser candiesStAXParser = new CandiesStAXParser();
        candiesStAXParser.buildListCandies(FILE_PATH.toFile().getPath());
        actualCandyList = candiesStAXParser.getCandies();
        Assert.assertTrue(expectedCandyList.equals(actualCandyList));
    }
}
