package Fauna.Predators;

/**
 * @author Nikolay Gabaraev
 * @created 14.05.2022
 * @project JavaRush_Module-2
 */

import Core.Settings;
import Fauna.Predator;
import Fauna.PredatorClass;

public class Eagle extends PredatorClass implements Predator {

    private static int maxOnCell = Settings.eagleMaxOnCell;

    public Eagle() {
        super(6, 4, 1, 6);
    }

    public static int getMaxOnCell() {
        return maxOnCell;
    }

}