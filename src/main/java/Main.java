/**
 * @author Nikolay Gabaraev
 * @created 29.04.2022
 * @project JavaRush_Module-2
 */

import Core.ScanClasses;
import Core.PrintStatictic;
import Core.SimulateLife;
import Island.Cell;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Генерируем карту
        Cell[][] objects = new Cell[2][2];
        for (int i = 0; i < objects.length; i++) {
            for (int j = 0; j < objects[i].length; j++) {
                objects[i][j] = new Cell();
            }
        }

        //Объект отвечающий за роста растений и статистика системы
        PrintStatictic prs = new PrintStatictic(objects);
        //Объект отвечающий за симуляцию жизни
        SimulateLife simLife = new SimulateLife(objects);
        //Шедулер потока статистики и роста
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(1);
        ScheduledExecutorService ses2 = Executors.newScheduledThreadPool(10);
        ScheduledFuture<?> sF = ses.scheduleAtFixedRate(prs, 0, 2, TimeUnit.SECONDS);
        ScheduledFuture<?> simulateLife = ses.scheduleAtFixedRate(simLife, 1, 1, TimeUnit.SECONDS);

        int iter = 0;
        while (true) {
            try {
                //System.out.println(iter);
                Thread.sleep(3000);
                iter++;
                //System.out.println("simulate-life is done - " + simulateLife.isDone() + " is Canceled - " + simulateLife.isCancelled());
                //System.out.println("printstat-life is done - " + sF.isDone() + " is Canceled - " + sF.isCancelled());
                if (iter > 1000) {
                    System.out.println("Конец итерациям!");
                    sF.cancel(true);
                    simulateLife.cancel(true);
                    ses.shutdown();
                    ses2.shutdown();
                    break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }



}
