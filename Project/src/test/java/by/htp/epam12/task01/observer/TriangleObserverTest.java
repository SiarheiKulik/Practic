package by.htp.epam12.task01.observer;

import by.htp.epam12.task01.action.TriangleAction;
import by.htp.epam12.task01.entity.Point;
import by.htp.epam12.task01.entity.Triangle;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class TriangleObserverTest {
    Point a, b, c;
    Point a1;
    long triangleId = 1;
    Triangle triangle = new Triangle(triangleId, a, b, c);
    TriangleAction action = new TriangleAction();

    @BeforeClass
    public void setUp() {
        a = new Point(2, 1);
        b = new Point(1, 5);
        c = new Point(6, 1);
        a1 = new Point(3, 1);


    }


    @Test
    public void update() {

        Warehouse warehouse ;
        double startPerimetr = 14.52622986305051;
        double startArea = 8.000000000000004;

        long expected = 13L;
        long chengedArea = 4L;

        triangle.setA(a1);
        System.out.println( action.definePerimetr(triangle));
        long actualPerim = Warehouse.TRIANGLES_PERIMETRS.get(triangleId).longValue();
        Assert.assertEquals(actualPerim,expected);




    }
}
