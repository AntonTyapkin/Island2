package Fauna.Predators;

/**
 * @author Nikolay Gabaraev
 * @created 14.05.2022
 * @project JavaRush_Module-2
 */

import Core.Settings;
import Fauna.Animal;
import Fauna.Predator;
import Fauna.Predatorc;

public class Fox extends Predatorc implements Predator {

    private static int maxOnCell = Settings.foxMaxOnCell;

    public Fox() {
        super(4, 3, 1, 8);
    }

    public static int getMaxOnCell() {
        return maxOnCell;
    }
}