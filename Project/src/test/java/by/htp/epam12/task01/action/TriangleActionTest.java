package by.htp.epam12.task01.action;

import by.htp.epam12.task01.action.TriangleAction;
import by.htp.epam12.task01.entity.Point;
import by.htp.epam12.task01.entity.Triangle;
import by.htp.epam12.task01.generator.IdGenerator;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TriangleActionTest {
    private Point a,b,c;
    long triangleId= IdGenerator.getTriangleId();
    private TriangleAction triangleAction = new TriangleAction();

    @BeforeClass
    public void setUp(){

        a = new Point(2,1);
        b = new Point(1,5);
        c = new Point(6,1);

    }

    @Test
    public void defindePerimetrTest(){
        Triangle triangle = new Triangle(triangleId,a,b,c);
        double expected = 13.6;
        double actual = triangleAction.definePerimetr(triangle);
        Assert.assertEquals(actual, expected);
    }
    @Test
    public void defindeAreaTest(){
        Triangle triangle = new Triangle(triangleId,a,b,c);
        double expected = 7.998;
        double actual = triangleAction.defineArea(triangle);
        Assert.assertEquals(actual,expected);
    }


}
