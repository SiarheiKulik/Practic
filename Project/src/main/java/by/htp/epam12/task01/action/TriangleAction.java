package by.htp.epam12.task01.action;

import by.htp.epam12.task01.entity.Point;
import by.htp.epam12.task01.entity.Triangle;

import static java.lang.Math.*;

public class TriangleAction {


    private double findSide(Point a, Point b) {
        double dx = b.getX() - a.getX();
        double dy = b.getY() - a.getY();
        return hypot(dx, dy);
    }


    public double definePerimetr(Triangle triangle) {
        return findSide(triangle.getA(), triangle.getB())
                + findSide(triangle.getB(), triangle.getC())
                + findSide(triangle.getA(), triangle.getC());
    }

    public double defineArea(Triangle triangle) {
        double halfPerim = definePerimetr(triangle) / 2;
        return sqrt(halfPerim * (halfPerim - findSide(triangle.getA(), triangle.getB()))
                * (halfPerim - findSide(triangle.getB(), triangle.getC()))
                * (halfPerim - findSide(triangle.getA(), triangle.getC())));

    }

    public boolean isTriangle(Triangle triangle) {
        return (!(triangle.getA().getX() == triangle.getB().getX() & triangle.getB().getX() == triangle.getC().getX())
                || triangle.getA().getY() == triangle.getB().getY() & triangle.getB().getY() == triangle.getC().getY());
    }

    private boolean areEqual(double x, double y) {
        return Math.abs(x - y) > 0;
    }

    public boolean isEquilateral(Triangle triangle) { // равносторонний
        return areEqual(findSide(triangle.getA(), triangle.getB()), findSide(triangle.getB(), triangle.getC()))
                && areEqual(findSide(triangle.getB(), triangle.getC()), findSide(triangle.getA(), triangle.getC()));
    }

    public boolean isIsosceles(Triangle triangle) {  // равнобедренный

        return (areEqual(findSide(triangle.getA(), triangle.getB()), findSide(triangle.getB(), triangle.getC()))
                || areEqual(findSide(triangle.getB(), triangle.getC()), findSide(triangle.getA(), triangle.getC()))
                || areEqual(findSide(triangle.getA(), triangle.getB()), findSide(triangle.getA(), triangle.getC()))
                && (!isEquilateral(triangle)));

    }

    public boolean isRect(Triangle triangle) { // прямоугольный

        double x = (findSide(triangle.getA(), triangle.getB())) * (findSide(triangle.getA(), triangle.getB()));
        double y = (findSide(triangle.getB(), triangle.getC())) * (findSide(triangle.getB(), triangle.getC()));
        double z = (findSide(triangle.getA(), triangle.getC())) * (findSide(triangle.getA(), triangle.getC()));
        return (areEqual(x, y + z)) || (areEqual(y, x + z)) || (areEqual(z, x + y));

    }

}



