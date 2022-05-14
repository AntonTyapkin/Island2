package Fauna.Predators;

/**
 * @author Nikolay Gabaraev
 * @created 14.05.2022
 * @project JavaRush_Module-2
 */

import Fauna.Animal;
import Fauna.Predator;
import Fauna.Predatorc;

public class Bear extends Predatorc implements Predator {

    private static int maxOnCell = 7;

    public Bear() {
        super(250, 2, 38, 15);
    }

    public static int getMaxOnCell() {
        return maxOnCell;
    }

}