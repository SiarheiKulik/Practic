package by.htp.epam12.task01.repository;

import by.htp.epam12.task01.entity.Point;
import by.htp.epam12.task01.entity.Triangle;

public class TriangleSpecificationByPoint implements TriangleSpecification {
    private Point desiredPoind;

    public TriangleSpecificationByPoint(Point desiredPoind) {
        this.desiredPoind = desiredPoind;
    }

    @Override
    public boolean specified(Triangle triangle) {
        return (triangle.getA().getX()== desiredPoind.getX());

    }
}
