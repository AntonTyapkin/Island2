package Fauna.Herbivores;

/**
 * @author Nikolay Gabaraev
 * @created 14.05.2022
 * @project JavaRush_Module-2
 */

import Core.Settings;
import Fauna.Herbivor;
import Fauna.Herbivorc;

public class Caterpillar extends Herbivorc implements Herbivor {

    private static int maxOnCell = Settings.caterpillarMaxOnCell;

    public Caterpillar() {
        super(0.01, 1, 0.0025, 1);
    }

    public static int getMaxOnCell() {
        return maxOnCell;
    }
}