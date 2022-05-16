package Fauna;

import java.util.List;

/**
 * @author Nikolay Gabaraev
 * @created 14.05.2022
 * @project JavaRush_Module-2
 */
public abstract class Animal {
    private double weight;
    private int speed;
    private double maxSatiety;
    private double satiety;
    private int starvingTime;
    private int gender;

    public Animal(double weight, int speed, double satiety, int starvingTime) {
        this.weight = weight;
        this.speed = speed;
        this.maxSatiety = satiety;
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

    public abstract void eat(List<Herb> herbs);

    public abstract void reproduction();

    public abstract void setDirection();

    public double getSatiety() {
        return satiety;
    }
    public void setSatiety(double satiety) {
        this.satiety = satiety;
    }

    public void decreaseSatiety() {
        if(this.satiety == 0) {
            this.starvingTime--;
        } else {
            this.satiety--;
        }
    }

    public int getStarvingTime() {
        return starvingTime;
    }

    public double getMaxSatiety() {
        return maxSatiety;
    }
}
