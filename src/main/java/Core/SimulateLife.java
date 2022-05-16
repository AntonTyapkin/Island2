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
                tryToEat(objects[i][j]);
                //tryToReproduction(objects[i][j]);
            }
        }

        this.iter++;
    }


    public void tryToReproduction(Cell cell) {
        cell.tryToReproductionPredators();
    }

    public void decreaseSatiety(Cell cell) {
        cell.decreaseSatiety();
    }

    //TO DO
    public void tryToEat(Cell cell) {
       // cell.tryToEatPredators();
        cell.tryToEatHerbivores();
    }
    public void tryToMove() {}


}
