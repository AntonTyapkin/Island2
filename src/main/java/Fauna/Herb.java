package Fauna;
/**
 * @author Nikolay Gabaraev
 * @created 14.05.2022
 * @project JavaRush_Module-2
 */

import Core.Settings;

public class Herb {
    private double weigh;
    private static int maxOnCell = Settings.herbsMaxOnCell;

    public Herb() {
        this.weigh = 1;
    }

    public static int getMaxOnCell() {
        return maxOnCell;
    }

}
