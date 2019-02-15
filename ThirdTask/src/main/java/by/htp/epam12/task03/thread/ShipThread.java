package by.htp.epam12.task03.thread;

import by.htp.epam12.task03.entity.Port;
import by.htp.epam12.task03.entity.Ship;
import by.htp.epam12.task03.exception.ProjectException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.Callable;

public class ShipThread implements Callable<Integer> {


    private final static Logger lOGGER = LogManager.getLogger();

    private Ship ship;
    private Port port;

    public ShipThread(Port port, Ship ship) {
        this.ship = ship;
        this.port = port;
    }


    @Override
    public Integer call() throws Exception {
        int currentCargoTrans = 0;
        try {
            if (port.dock()) {
                System.out.println("The ship with ID " + ship.getShipId() + " was docked.");
            }
        } catch (ProjectException e) {
            lOGGER.log(Level.ERROR, "Mooring exception.", e);
        }

        if (ship.hasCargo()) {
            System.out.println("Trying unload cargo with size " + ship.getCurrentCapasity() + " from " + ship.toString()
                    + " to Port.");

            if (port.unload(ship.getCurrentCapasity())) {
                currentCargoTrans += ship.getCurrentCapasity();
                ship.setCurrentCapasity(0);
            }
        }

        if (ship.hasSpace()) {
            System.out.println("Trying load cargo with size " + ship.getAvailableSpace() + " from Port to "
                    + ship.toString() + ".");
            currentCargoTrans += ship.getAvailableSpace();
            ship.addCargo(port.load(ship.getAvailableSpace()));
        }

        port.sail();
        System.out.println(ship.toString() + " sail away." + "\n");

        return currentCargoTrans;

    }
}
