package Fauna.Predators;

/**
 * @author Nikolay Gabaraev
 * @created 14.05.2022
 * @project JavaRush_Module-2
 */

import Core.MovementDirection;
import Core.Settings;
import Fauna.Animal;
import Fauna.Predator;
import Fauna.Predatorc;

public class Wolf extends Predatorc implements Predator{

    private static int maxOnCell = Settings.wolfMaxOnCell;

    public Wolf() {
        super(50, 3, 8, 10);
    }

    @Override
    public void reproduction() {

    }

    public static int getMaxOnCell() {
        return maxOnCell;
    }
}
