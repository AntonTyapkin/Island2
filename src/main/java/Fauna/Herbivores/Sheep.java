package Fauna.Herbivores;

/**
 * @author Nikolay Gabaraev
 * @created 14.05.2022
 * @project JavaRush_Module-2
 */

import Fauna.Animal;
import Fauna.Herbivor;
import Fauna.Herbivorc;

public class Sheep extends Herbivorc implements Herbivor {

    private static int maxOnCell = 156;

    public Sheep() {
        super(45, 1, 7, 5);
    }

    public static int getMaxOnCell() {
        return maxOnCell;
    }
}