package Fauna;

import java.util.List;

/**
 * @author Nikolay Gabaraev
 * @created 14.05.2022
 * @project JavaRush_Module-2
 */
public class Predatorc extends Animal {

    public Predatorc(double weight, int speed, double satiety, int starvingTime) {
        super(weight, speed, satiety, starvingTime);
    }

    @Override
    public void eat() {
        double satiety = this.getSatiety();
        //if ()
    }

    @Override
    public void eat(List<Herb> herbs) {

    }

    @Override
    public void reproduction() {

    }

    @Override
    public void setDirection() {

    }
}
