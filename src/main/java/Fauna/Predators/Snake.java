package Fauna.Predators;

/**
 * @author Nikolay Gabaraev
 * @created 14.05.2022
 * @project JavaRush_Module-2
 */

import Fauna.Animal;
import Fauna.Predator;
import Fauna.Predatorc;

public class Snake extends Predatorc implements Predator {

    private static int maxOnCell = 123;

    public Snake() {
        super(2, 1, 0.3, 15);
    }

    public static int getMaxOnCell() {
        return maxOnCell;
    }

}
