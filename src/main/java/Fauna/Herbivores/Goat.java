package Fauna.Herbivores;

/**
 * @author Nikolay Gabaraev
 * @created 14.05.2022
 * @project JavaRush_Module-2
 */

import Core.Settings;
import Fauna.Animal;
import Fauna.Herbivor;
import Fauna.Herbivorc;

public class Goat extends Herbivorc implements Herbivor {

    private static int maxOnCell = Settings.goatMaxOnCell;

    public Goat() {
        super(65, 1, 10, 5);
    }

    public static int getMaxOnCell() {
        return maxOnCell;
    }
}