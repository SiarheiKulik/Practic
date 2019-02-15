package by.htp.epam12.task01.entity;

import by.htp.epam12.task01.generator.IdGenerator;
import by.htp.epam12.task01.observer.TriangleObserver;

public class Triangle {
    private long triangleId;
    private Point a;
    private Point b;
    private Point c;

    private static TriangleObserver triangleObserver = TriangleObserver.getInstance();


    public Triangle(long triangleId, Point a, Point b, Point c) {
        this.triangleId = triangleId;
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public String toString() {
        return getClass().getName() +" "
                + getId() + " "
                + getA().toString() + " "
                + getB().toString() + " "
                + getC().toString();
    }

    public Point getA() {
        return a;
    }

    public void setA(Point a) {
        this.a = a;
        triangleObserver.update(this);


    }

    public Point getB() {
        return b;
    }

    public void setB(Point b) {
        this.b = b;
        triangleObserver.update(this);
    }

    public Point getC() {
        return c;
    }

    public void setC(Point c) {
        this.c = c;
        triangleObserver.update(this);
    }

    public boolean equalsTriangle(Triangle triangle) {
        if (this == triangle) {
            return true;
        }
        if (triangle == null) {
            return false;
        }

        if (triangleId == triangle.getId()) {
            return true;
        }
        return (this.hashCode() == triangle.hashCode());
    }

    public long getId() {
        return triangleId;
    }

    public void setId(long id) {
        this.triangleId = id;
    }
}
