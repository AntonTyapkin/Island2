package Fauna.Predators;

/**
 * @author Nikolay Gabaraev
 * @created 14.05.2022
 * @project JavaRush_Module-2
 */

import Fauna.Animal;
import Fauna.Predator;
import Fauna.Predatorc;

public class Fox extends Predatorc implements Predator {

    private static int maxOnCell = 50;

    public Fox() {
        super(4, 3, 1, 8);
    }

    public static int getMaxOnCell() {
        return maxOnCell;
    }
}