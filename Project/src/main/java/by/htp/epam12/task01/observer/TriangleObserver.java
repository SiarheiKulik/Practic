package by.htp.epam12.task01.observer;

import by.htp.epam12.task01.action.TriangleAction;

import by.htp.epam12.task01.entity.Triangle;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.util.concurrent.locks.ReentrantLock;

public class TriangleObserver {

    private static TriangleObserver instance;
    private static ReentrantLock Lock = new ReentrantLock();
    private static boolean flag;

    private static final Logger logger = LogManager.getLogger();

    private TriangleObserver() {
    }

    public static TriangleObserver getInstance() {
        if (!flag) {
            Lock.lock();
            try {
                if (instance == null) {
                    instance = new TriangleObserver();
                    flag = true;
                }
            } finally {
                Lock.unlock();
            }
        }
        return instance;
    }

    public void update(Triangle triangle) {
        if (triangle == null) {
            logger.log(Level.ERROR, "The triangle is null");
            return;
        }
        TriangleAction action = new TriangleAction();
        double perimetr = action.definePerimetr(triangle);
        double area = action.defineArea(triangle);
        Warehouse.TRIANGLES_PERIMETRS.put(triangle.getId(), perimetr);
        Warehouse.TRIANGLES_AREAS.put(triangle.getId(), area);

    }
}



