/**
 * @author Nikolay Gabaraev
 * @created 29.04.2022
 * @project JavaRush_Module-2
 */

import Core.PrintStatictic;
import Core.SimulateLife;
import Island.Cell;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        //Генерируем карту
        Cell[][] objects = new Cell[2][2];
        for (int i = 0; i < objects.length; i++) {
            for (int j = 0; j < objects[i].length; j++) {
                objects[i][j] = new Cell();
            }
        }
        //Объект отвечающий за роста растений и статистика системы
        PrintStatictic prs = new PrintStatictic(objects);
        SimulateLife simLife = new SimulateLife(objects);
        //Шедулер потока статистики и роста
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(1);
        ScheduledExecutorService ses2 = Executors.newScheduledThreadPool(10);
        ScheduledFuture<?> sF = ses.scheduleAtFixedRate(prs, 0, 2, TimeUnit.SECONDS);
        ScheduledFuture<?> simulateLife = ses2.scheduleAtFixedRate(simLife, 0, 500, TimeUnit.MILLISECONDS);

        int iter = 0;
        while (true) {
            try {
                //System.out.println(iter);
                Thread.sleep(3000);
                iter++;
                if (iter > 3) {
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
