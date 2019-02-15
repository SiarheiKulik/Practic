package by.htp.epam12.task03.entity;


import by.htp.epam12.task03.generator.IdGenerator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.util.Objects;




public class Ship {

    private final static Logger lOGGER = LogManager.getLogger();

    private long shipId;
    private int currentCapasity;
    private int maxCapasity;

    public Ship(int currentCapasity, int maxCapasity) {
        this.currentCapasity = currentCapasity;
        this.maxCapasity = maxCapasity;
        this.shipId = IdGenerator.generateId();

    }

    public boolean isEmpty() {
      return getCurrentCapasity() == 0;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ship ship = (Ship) o;
        return shipId == ship.shipId &&
                currentCapasity == ship.currentCapasity &&
                maxCapasity == ship.maxCapasity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(shipId, currentCapasity, maxCapasity);
    }


    public long getShipId() {
        return shipId;
    }

    public void setShipId(long shipId) {
        this.shipId = shipId;
    }

    public int getCurrentCapasity() {
        return currentCapasity;
    }

    public void setCurrentCapasity(int currentCapasity) {
        this.currentCapasity = currentCapasity;
    }

    public int getMaxCapasity() {
        return maxCapasity;
    }

    public void setMaxCapasity(int maxCapasity) {
        this.maxCapasity = maxCapasity;
    }
    public boolean hasCargo() {
        return currentCapasity > 0;
    }

    public boolean hasSpace() {
        return currentCapasity < maxCapasity;
    }

    public int getAvailableSpace() {
        return maxCapasity - currentCapasity;
    }

    public void addCargo(int weight) {
        currentCapasity += weight;
    }


    @Override
    public String toString() {
        return "Ship{" +
                "shipId=" + shipId +
                ", currentCapasity=" + currentCapasity +
                ", maxCapasity=" + maxCapasity +
                '}';
    }
}
