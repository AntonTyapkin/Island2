package Fauna.Herbivores;

/**
 * @author Nikolay Gabaraev
 * @created 14.05.2022
 * @project JavaRush_Module-2
 */

import Core.Settings;
import Fauna.Herbivor;
import Fauna.HerbivoreClass;

public class Rabbit extends HerbivoreClass implements Herbivor {

    private static int maxOnCell = Settings.rabbitMaxOnCell;

    public Rabbit() {
        super(3, 3, 0.45, 7);
    }

    public static int getMaxOnCell() {
        return maxOnCell;
    }
}