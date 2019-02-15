package by.htp.epam12.task03.entity;


import by.htp.epam12.task03.exception.ProjectException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

public class Port {

    private final static Logger lOGGER = LogManager.getLogger();

    private static Port instance;
    private static ReentrantLock lock = new ReentrantLock();
    private static AtomicBoolean create = new AtomicBoolean(false);
    private final static int PIRS_NUMBER = 3;
    private Semaphore semaphore;
    private int currentCapasity ;
    private int maxCapasity;
    private final Queue<Ship> ships = new LinkedList<>();

    private Port(int currentCapasity, int maxCapasity) {
        this.currentCapasity = currentCapasity;
        this.maxCapasity = maxCapasity;
        semaphore = new Semaphore(PIRS_NUMBER);
    }

    public static Port getInstance(int currentCapasity, int maxCapasity) {
        if (!create.get()) {
            try {
                lock.lock();
                if (instance == null) {
                    instance = new Port(currentCapasity,maxCapasity);
                    create.set(true);
                }
            } finally {
                lock.unlock();
            }
        }
        return instance;
    }
    public boolean dock() throws ProjectException {
        try {
            semaphore.acquire();
            TimeUnit.MILLISECONDS.sleep(10);
        } catch (InterruptedException e) {
            lOGGER.log(Level.ERROR, "Interrupt in dock method.");
            throw new ProjectException("Interrupt in dock method.", e);
        }
        return true;
    }

    public boolean unload(int weight) {
        if (currentCapasity + weight > maxCapasity) {
            return false;
        }
        currentCapasity += weight;
        return true;
    }

    public int load(int max) {
        int cargo = tryLoad(max);
        if (cargo > 0) {

            return cargo;
        }
        return 0;
    }

    public void sail() {
        semaphore.release();

    }

    @Override
    public String  toString() {
        return "Port{" +
                "currentCapasity=" + currentCapasity +
                ", maxCapasity=" + maxCapasity +
                ", ships=" + ships +
                '}';
    }

    private int tryLoad(int max) {
        if (currentCapasity >= max) {
            currentCapasity -= max;
            return max;
        } else {
            int weight = currentCapasity;
            currentCapasity = 0;
            return weight;
        }
    }



}


