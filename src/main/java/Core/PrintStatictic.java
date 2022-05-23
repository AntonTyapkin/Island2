package Core;

/**
 * @author Nikolay Gabaraev
 * @created 14.05.2022
 * @project JavaRush_Module-2
 */

import Island.Cell;

public class PrintStatictic implements Runnable {

    private int iterPrintStatic;
    private final Cell[][] objects;

    public PrintStatictic(Cell[][] objects) {
        this.objects = objects;
    }

    @Override
    public void run() {
        System.out.println("Итерация - " + this.iterPrintStatic + ". Печатаю статистку");
        addHerbs(objects);
        printStat(objects);
        this.iterPrintStatic++;
    }

    public static void printStat(Cell[][] objects) {
        for (int i = 0; i < objects.length; i++) {
            for (int j = 0; j < objects[i].length; j++) {
                System.out.print("Ячейка - " + i + "x" + j);
                System.out.println(" Растений - " + objects[i][j].countHerbs()
                        + " Хищников - " + objects[i][j].countPredators() + " Травоядных - " + objects[i][j].countHerbivores() + "\n"
                        + objects[i][j].countEachPredator() + "\n"
                        + objects[i][j].countEachHerbivore());
            }
        }
        System.out.println("------------------");
    }

    public static void addHerbs(Cell[][] objects) {
        for (int i = 0; i < objects.length; i++) {
            for (int j = 0; j < objects[i].length; j++) {
                objects[i][j].addHerb();
            }
        }
    }

}
