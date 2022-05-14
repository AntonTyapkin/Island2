package Fauna;

/**
 * @author Nikolay Gabaraev
 * @created 14.05.2022
 * @project JavaRush_Module-2
 */
public abstract class Animal {
    private double weight;
    private int speed;
    private double satiety;
    private int starvingTime;
    private int gender;

    public Animal(double weight, int speed, double satiety, int starvingTime) {
        this.weight = weight;
        this.speed = speed;
        this.satiety = satiety;
        this.starvingTime = starvingTime;
        setGender();
    }

    private void setGender() {
        this.gender = (int) (Math.random() * 2 + 1);
    }

    public int getGender() {
        return this.gender;
    }

    public abstract void eat();

    public abstract void reproduction();

    public abstract void setDirection();

    public double getSatiety() {
        return satiety;
    }

    public void decreaseSatiety() {
        this.satiety--;
    }

}
