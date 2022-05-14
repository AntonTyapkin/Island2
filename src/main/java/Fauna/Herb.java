package Fauna;
/**
 * @author Nikolay Gabaraev
 * @created 14.05.2022
 * @project JavaRush_Module-2
 */

import java.util.Objects;

public class Herb {
    private double weigh;
    private static int maxOnCell = 10000;

    public Herb() {
        this.weigh = 1;
    }

    public double getWeigh() {
        return weigh;
    }

    public static int getMaxOnCell() {
        return maxOnCell;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Herb herb = (Herb) o;
        return Double.compare(herb.weigh, weigh) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(weigh);
    }
}
