package by.htp.epam12.task01.creater;

import by.htp.epam12.task01.creation.TriangleCreater;
import by.htp.epam12.task01.entity.Point;
import by.htp.epam12.task01.entity.Triangle;
import by.htp.epam12.task01.generator.IdGenerator;
import org.junit.Before;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class TriangleCreaterTest {

    Triangle triangle1;
    Triangle triangle2;
    @BeforeClass
    public void setUp() {
        Point a1 = new Point(1.0, 2.5);
        Point b1 = new Point(2.5, 4.0);
        Point c1 = new Point(4.0, 3.0);
        Point a2 = new Point(1.5, 2.5);
        Point b2 = new Point(3.0, 7.0);
        Point c2 = new Point(5.0, 1.0);
        triangle1 = new Triangle(1l, a1, b1, c1);
        triangle2 = new Triangle(2l, a2, b2, c2);

    }


    @Test
    public void createTriangleTest() {

        TriangleCreater creater = new TriangleCreater();
        List<Triangle> actual = creater.createTriagles(Arrays.asList(
                "1.0 2.5",
                "2.5 4.0",
                "4.0 3.0",
                "1.5 2.5",
                "3.0 7.0",
                "5.0 1.0"
        ));
        List<Triangle> axpected = Arrays.asList(triangle1,triangle2);
        Assert.assertEquals(actual, axpected);
    }
}
