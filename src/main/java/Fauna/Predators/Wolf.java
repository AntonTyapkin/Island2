package Fauna.Predators;

/**
 * @author Nikolay Gabaraev
 * @created 14.05.2022
 * @project JavaRush_Module-2
 */

import Fauna.Animal;
import Fauna.Predator;

public class Wolf extends Animal implements Predator {

    private static int maxOnCell = 30;

    public Wolf() {
        super(50, 3, 8, 10);
    }

    @Override
    public void eat() {
        System.out.println("Волк пытается поесть");
    }

    @Override
    public void reproduction() {

    }

    @Override
    public void setDirection() {

    }

    public static int getMaxOnCell() {
        return maxOnCell;
    }
}
