package Fauna.Predators;

/**
 * @author Nikolay Gabaraev
 * @created 14.05.2022
 * @project JavaRush_Module-2
 */

import Core.Settings;
import Fauna.Predator;
import Fauna.PredatorClass;

public class Snake extends PredatorClass implements Predator {

    private static int maxOnCell = Settings.snakeMaxOnCell;

    public Snake() {
        super(2, 1, 0.3, 15);
    }

    public static int getMaxOnCell() {
        return maxOnCell;
    }

}
