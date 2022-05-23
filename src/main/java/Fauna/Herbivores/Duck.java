package Fauna.Herbivores;

/**
 * @author Nikolay Gabaraev
 * @created 14.05.2022
 * @project JavaRush_Module-2
 */

import Core.Settings;
import Fauna.Herbivor;
import Fauna.HerbivoreClass;

public class Duck extends HerbivoreClass implements Herbivor {

    private static int maxOnCell = Settings.duckMaxOnCell;

    public Duck() {
        super(1, 1, 0.15, 4);
    }

    public static int getMaxOnCell() {
        return maxOnCell;
    }
}