package Fauna;

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
        System.out.println("Хищник пытается поесть");
    }

    @Override
    public void reproduction() {

    }

    @Override
    public void setDirection() {

    }
}
