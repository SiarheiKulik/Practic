package by.htp.epam12.task01.repository;

import by.htp.epam12.task01.entity.Triangle;

public class TtiangleSpecificationById implements TriangleSpecification {
    private long desiredTriangleId;

    public TtiangleSpecificationById(long desiredTriangleId) {
        this.desiredTriangleId = desiredTriangleId;
    }
    @Override
    public boolean specified(Triangle triangle) {
        return (desiredTriangleId == triangle.getId());
    }
}
