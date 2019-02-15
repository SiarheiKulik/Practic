package by.htp.epam12.task01.repository;

import by.htp.epam12.task01.creation.TriangleCreater;
import by.htp.epam12.task01.entity.Triangle;
import by.htp.epam12.task01.reader.DataFileReader;

import java.util.*;

public class Repository implements TriangleRepository {

    private Map<Long, Triangle> triangles = new HashMap<>();


    @Override
    public void addTriangle(Triangle triangle) {
        triangles.put(triangle.getId(), triangle);
        System.out.println(triangles.get(triangle.getId()));
    }

    @Override
    public void removeTriangle(Triangle triangle) {
        triangles.remove(triangle.getId());

    }

    @Override
    public void upDateTriangle(Triangle triangle) {

    }

    @Override
    public List<Triangle> query(TriangleSpecification specification) {
        List<Triangle> triangleList = new ArrayList<>();
        for (Map.Entry<Long, Triangle> tr : triangles.entrySet()) {
            if (specification.specified(tr.getValue())) {
                triangleList.add(tr.getValue());
            }
        }

        return triangleList;
    }


}



