package Core;

/**
 * @author Nikolay Gabaraev
 * @created 14.05.2022
 * @project JavaRush_Module-2
 */

import Island.Cell;

public class SimulateLife implements Runnable {

    private int iter;
    private Cell[][] objects;

    public SimulateLife(Cell[][] objects) {
        this.objects = objects;
    }

    @Override
    public void run() {
        System.out.println("СИМУЛЯЦИЯ ЖИЗНИ ПРОХОД " + this.iter + ".");
        for (int i = 0; i < objects.length; i++) {
            for (int j = 0; j < objects[i].length; j++) {
                decreaseSatiety(objects[i][j]);
                tryToreproduction(objects[i][j]);
            }
        }

        this.iter++;
    }


    public void tryToreproduction(Cell cell) {
        cell.tryToReproductionPredators();
    }

    public void decreaseSatiety(Cell cell) {
        cell.decreaseSatiety();
    }

    //TO DO
    public void tryToEat() {}
    public void tryToMove() {}


}
