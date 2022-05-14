package Fauna.Predators;

/**
 * @author Nikolay Gabaraev
 * @created 14.05.2022
 * @project JavaRush_Module-2
 */

import Fauna.Animal;
import Fauna.Predator;
import Fauna.Predatorc;

public class Eagle extends Predatorc implements Predator {

    private static int maxOnCell = 166;

    public Eagle() {
        super(6, 4, 1, 6);
    }

    public static int getMaxOnCell() {
        return maxOnCell;
    }

}