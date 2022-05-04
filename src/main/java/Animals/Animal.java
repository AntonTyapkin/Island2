package Animals;

/**
 * @author Nikolay Gabaraev
 * @created 29.04.2022
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

    public abstract void eat();

    public abstract void reproduction();

    public abstract void setDirection();



    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public double getSatiety() {
        return satiety;
    }

    public void setSatiety(double satiety) {
        this.satiety = satiety;
    }

    public int getStarvingTime() {
        return starvingTime;
    }

    public void setStarvingTime(int starvingTime) {
        this.starvingTime = starvingTime;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(){
        this.gender = (int) ( Math.random() * 2 + 1);
    }
}
