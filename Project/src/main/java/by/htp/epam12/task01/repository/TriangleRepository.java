package by.htp.epam12.task01.repository;

import by.htp.epam12.task01.entity.Triangle;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface TriangleRepository {
    void addTriangle(Triangle triangle);
    void removeTriangle(Triangle triangle);
    void upDateTriangle(Triangle triangle);

    List<Triangle> query(TriangleSpecification specification);


}
