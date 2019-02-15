package by.htp.epam12.task01.comporator;

import by.htp.epam12.task01.entity.Triangle;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CompositeComporator {
    List<Triangle> sortList = new ArrayList<>();
    Comparator<Triangle> idComparator = (o1, o2) -> Long.compare(o1.getId(), o2.getId());
    Comparator<Triangle> coordinateXComparator = (o1, o2) -> Double.compare(o1.getA().getX(), o2.getA().getX());
    Comparator<Triangle> coordinatYComparator = (o1, o2) -> Double.compare(o1.getA().getY(), o2.getA().getY());

    public void sortById() {
        //sortList.sort((o1, o2)->Long.compare(o1.getId(),o2.getId()));
        sortList.sort(Comparator.comparing(Triangle::getId));
    }

    public void sortByFirstPointX() {
        sortList.sort((o1, o2) -> Double.compare(o1.getA().getX(), o2.getA().getX()));

    }

    public void sortByFirstPointY() {
        sortList.sort((o1, o2) -> Double.compare(o1.getA().getY(), o2.getA().getY()));

    }


}
