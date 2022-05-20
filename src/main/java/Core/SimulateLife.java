package Core;

/**
 * @author Nikolay Gabaraev
 * @created 14.05.2022
 * @project JavaRush_Module-2
 */

import Island.Cell;

public class SimulateLife implements Runnable {

    private int iterSimulate;
    private final Cell[][] objects;

    public SimulateLife(Cell[][] objects) {
        this.objects = objects;
    }

    @Override
    public void run() {
        //System.out.println("СИМУЛЯЦИЯ ЖИЗНИ ПРОХОД " + this.iterSimulate + ".");
        for (int i = 0; i < objects.length; i++) {
            for (int j = 0; j < objects[i].length; j++) {
                //System.out.println("Уменьшаю сытость");
                objects[i][j].decreaseSatiety();
                //jSystem.out.println("Пробую есть");
                tryToEat(objects[i][j]);
                //tryToReproduction(objects[i][j]);
            }
        }
        this.iterSimulate++;
    }


    public void tryToReproduction(Cell cell) {
        cell.tryToReproductionPredators();
    }

    //TO DO
    public synchronized void tryToEat(Cell cell) {
        //cell.tryToEatPredators();
        cell.tryToEatHerbivores();
    }
    public void tryToMove() {}


}
