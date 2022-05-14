package Fauna;

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
    public void eat() {
        System.out.println("Травоядное пытается поесть");
    }

    @Override
    public void reproduction() {

    }

    @Override
    public void setDirection() {

    }
}
