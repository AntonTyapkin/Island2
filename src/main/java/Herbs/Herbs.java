package Herbs;

import java.util.Objects;

public class Herbs {
    private final double weight = 1;
    private static final int maxOnCell = 10000;

    public Herbs() {

    }

    public double getWeight() {
        return weight;
    }

    public int getMaxOnCell() {
        return maxOnCell;
    }

    @Override
    public String toString() {
        return "Herbs{" +
                "weight=" + weight +
                ", maxOnCell=" + maxOnCell +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Herbs)) return false;
        Herbs herbs = (Herbs) o;
        return Double.compare(herbs.getWeight(), getWeight()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getWeight());
    }
}
