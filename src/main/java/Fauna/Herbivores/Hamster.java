package Fauna.Herbivores;

/**
 * @author Nikolay Gabaraev
 * @created 14.05.2022
 * @project JavaRush_Module-2
 */

import Fauna.Animal;
import Fauna.Herbivor;
import Fauna.Herbivorc;

public class Hamster extends Herbivorc implements Herbivor {

    private static int maxOnCell = 10000;

    public Hamster() {
        super(0.03, 1, 0.0075, 3);
    }

    public static int getMaxOnCell() {
        return maxOnCell;
    }
}