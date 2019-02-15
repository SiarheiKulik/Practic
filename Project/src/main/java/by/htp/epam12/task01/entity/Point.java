package by.htp.epam12.task01.entity;

import java.util.Objects;

public class Point {
    private long pointId;
    private double x;
    private double y;


    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public boolean equals(Point point) {
        if (this == point) return true;
        if (point == null) return false;
        return pointId == point.pointId &&
                Double.compare(point.x, x) == 0 &&
                Double.compare(point.y, y) == 0;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(pointId, x, y);
    }

    public long getId() {
        return pointId;
    }

    public void setId(long id) {
        this.pointId = id;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }


}
