package by.htp.epam12.task01.creation;

import by.htp.epam12.task01.generator.IdGenerator;
import by.htp.epam12.task01.validator.DataValidator;
import by.htp.epam12.task01.entity.Point;
import by.htp.epam12.task01.entity.Triangle;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TriangleCreater {
    static final String REGEX_SEPERATOR = "\\s";

    private Point createPoint(String line) {
        String[] points = line.trim().split(REGEX_SEPERATOR);
        double x = Double.valueOf(points[0]);
        double y = Double.valueOf(points[1]);
        return new Point(x, y);
    }

    private Triangle createTriangle(List<String> listPoints) {
        Point a = createPoint(listPoints.get(0));
        Point b = createPoint(listPoints.get(1));
        Point c = createPoint(listPoints.get(2));
        long triangleId = IdGenerator.getTriangleId();
        return new Triangle(triangleId, a, b, c);
    }

    public List<Triangle> createTriagles(List<String> dataList) {
        List<String> listPoints = new ArrayList<>();
        List<Triangle> triangles = new ArrayList<>();
        int indexFrom = 0;
        int indexTo = 3;
        int size = dataList.size();
        while (indexTo <= size) {
            triangles.add(createTriangle(dataList.subList(indexFrom, indexTo)));
            indexFrom += 3;
            indexTo += 3;
        }
        return triangles;
    }
}





