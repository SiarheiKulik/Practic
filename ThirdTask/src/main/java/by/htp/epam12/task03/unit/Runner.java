package by.htp.epam12.task03.unit;

import by.htp.epam12.task03.entity.Port;
import by.htp.epam12.task03.entity.Ship;
import by.htp.epam12.task03.thread.ShipThread;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;
import java.util.concurrent.*;

public class Runner {

    private static final Logger lOGGER = LogManager.getLogger();

    private static final int COUNT_THREAD = 5;
    private static final int MAX_PORT_CAPACITY = 500;
    private static final int CURRENT_PORT_CAPACITY = 100;

    private static int currentCargoTrans;


    public static void main(String[] args) throws InterruptedException {

        Queue<Ship> ships = new ArrayDeque<>();

        ships.add(new Ship(30, 30));
        ships.add(new Ship(0, 30));
        ships.add(new Ship(15, 15));
        ships.add(new Ship(25, 30));
        ships.add(new Ship(20, 30));

        Port port = Port.getInstance(CURRENT_PORT_CAPACITY,MAX_PORT_CAPACITY);

        ExecutorService service = Executors.newFixedThreadPool(COUNT_THREAD);
        List<Future<Integer>> futureList = new ArrayList<>();
        for (Ship ship : ships) {
            futureList.add(service.submit(new ShipThread(port, ship)));
        }

        for (Future future : futureList) {
            try {
                currentCargoTrans += (Integer) future.get();
            } catch (ExecutionException e) {
                lOGGER.log(Level.ERROR, "Thread has interrupted or attempting ", e);
            }
        }
        System.out.println("Total cargo were serviced :  " + currentCargoTrans);
        service.shutdown();
    }


}



