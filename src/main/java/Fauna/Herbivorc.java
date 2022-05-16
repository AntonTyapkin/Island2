package Fauna;

import java.util.List;

/**
 * @author Nikolay Gabaraev
 * @created 14.05.2022
 * @project JavaRush_Module-2
 */
public class Herbivorc extends Animal {

    public Herbivorc(double weight, int speed, double satiety, int starvingTime) {
        super(weight, speed, satiety, starvingTime);
    }

    @Override
    public void eat() {}
    @Override
    public void eat(List<Herb> herbs) {
        if (this.getSatiety() < this.getMaxSatiety()) {
            double diff = this.getMaxSatiety() - this.getSatiety();
            this.setSatiety(this.getMaxSatiety());
            for (int i = 0; i < diff; i++) {
                herbs.remove(i);
            }
            System.out.println("Травоядное ест травы - " + diff);
        }
    }

    @Override
    public void reproduction() {

    }

    @Override
    public void setDirection() {

    }
}
