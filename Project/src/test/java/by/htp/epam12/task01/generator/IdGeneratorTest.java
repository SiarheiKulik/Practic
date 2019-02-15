package by.htp.epam12.task01.generator;

import by.htp.epam12.task01.entity.Point;
import by.htp.epam12.task01.entity.Triangle;

import org.testng.Assert;
import org.testng.annotations.Test;

public class IdGeneratorTest {
    Point a, b, c ;
    long triangleId=1;

    Triangle triangle = new Triangle(triangleId,a,b,c);


    @Test
    public void getTriangleIdTest(){
        long expected = triangleId;
        long actual = triangle.getId();
        Assert.assertEquals(actual,expected);
    }

}
