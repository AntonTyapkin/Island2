package Fauna.Herbivores;

/**
 * @author Nikolay Gabaraev
 * @created 14.05.2022
 * @project JavaRush_Module-2
 */

import Core.Settings;
import Fauna.Herbivor;
import Fauna.HerbivoreClass;

public class Horse extends HerbivoreClass implements Herbivor {

    private static int maxOnCell = Settings.horseMaxOnCell;

    public Horse() {
        super(300, 3, 45, 5);
    }

    public static int getMaxOnCell() {
        return maxOnCell;
    }
}