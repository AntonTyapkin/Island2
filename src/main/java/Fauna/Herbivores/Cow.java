package Fauna.Herbivores;

/**
 * @author Nikolay Gabaraev
 * @created 14.05.2022
 * @project JavaRush_Module-2
 */

import Core.Settings;
import Fauna.Herbivor;
import Fauna.HerbivoreClass;

public class Cow extends HerbivoreClass implements Herbivor {

    private static int maxOnCell = Settings.cowMaxOnCell;

    public Cow() {
        super(350, 1, 53, 4);
    }

    public static int getMaxOnCell() {
        return maxOnCell;
    }
}