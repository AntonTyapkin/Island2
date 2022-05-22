/**
 * @author Nikolay Gabaraev
 * @created 29.04.2022
 * @project JavaRush_Module-2
 */

import Core.ScanClasses;
import Core.PrintStatictic;
import Core.Settings;
import Core.SimulateLife;
import Island.Cell;
import Island.Island;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Settings settings = new Settings();
        //Генерируем карту
//        Cell[][] objects = new Cell[2][2];
//        for (int i = 0; i < objects.length; i++) {
//            for (int j = 0; j < objects[i].length; j++) {
//                objects[i][j] = new Cell();
//            }
//        }

        Island island = new Island();

        //Объект отвечающий за рост растений и статистику системы
        PrintStatictic prs = new PrintStatictic(island.getIsland());
        //Объект отвечающий за симуляцию жизни
        SimulateLife simLife = new SimulateLife(island.getIsland());
        //Шедулер потока статистики и роста
        ScheduledExecutorService sesStatictic = Executors.newScheduledThreadPool(1);
        ScheduledExecutorService sesSimulateLife = Executors.newScheduledThreadPool(10);
        ScheduledFuture<?> sF = sesStatictic.scheduleAtFixedRate(prs, 0, 3, TimeUnit.SECONDS);
        ScheduledFuture<?> simulateLife = sesSimulateLife.scheduleAtFixedRate(simLife, 1, 1, TimeUnit.SECONDS);

        int iter = 0;
        while (true) {
            try {
                Thread.sleep(3000);
                iter++;
                //System.out.println("simulate-life is done - " + simulateLife.isDone() + " is Canceled - " + simulateLife.isCancelled());
                //System.out.println("printstat-life is done - " + sF.isDone() + " is Canceled - " + sF.isCancelled());
                if (iter > 1000) {
                    System.out.println("Конец итерациям!");
                    sF.cancel(true);
                    simulateLife.cancel(true);
                    sesStatictic.shutdown();
                    sesSimulateLife.shutdown();
                    break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }



}
