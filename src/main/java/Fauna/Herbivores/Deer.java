package Fauna.Herbivores;

/**
 * @author Nikolay Gabaraev
 * @created 14.05.2022
 * @project JavaRush_Module-2
 */

import Fauna.Animal;
import Fauna.Herbivor;
import Fauna.Herbivorc;

public class Deer extends Herbivorc implements Herbivor {

    private static int maxOnCell = 41;

    public Deer() {
        super(170, 3, 26, 4);
    }

    public static int getMaxOnCell() {
        return maxOnCell;
    }
}