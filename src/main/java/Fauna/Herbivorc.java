package Fauna;

import Core.MovementDirection;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Nikolay Gabaraev
 * @created 14.05.2022
 * @project JavaRush_Module-2
 */
public class Herbivorc extends Animal implements Herbivor{

    public Herbivorc(double weight, int speed, double satiety, int starvingTime) {
        super(weight, speed, satiety, starvingTime);
    }

    @Override
    public void eat(List<?> listOfFood) {
        if (this.getSatiety() < this.getMaxSatiety()) {
            double diff = this.getMaxSatiety() - this.getSatiety();
            if (listOfFood.size() > diff) {
                this.setSatiety(this.getMaxSatiety());
                this.setStarvingTime(this.getMaxStarvingTime());
                listOfFood.subList(0, (int)diff).clear();
            }
        }
    }

    @Override
    public void reproduction() {

    }

    @Override
    public MovementDirection setDirection() {
        MovementDirection movementDirection;

        int moveDirection = ThreadLocalRandom.current().nextInt(0, 4);

        if (moveDirection == MovementDirection.UP.ordinal()) {
            movementDirection = MovementDirection.UP;
        } else if (moveDirection == MovementDirection.RIGHT.ordinal()) {
            movementDirection = MovementDirection.RIGHT;
        } else if (moveDirection == MovementDirection.DOWN.ordinal()) {
            movementDirection = MovementDirection.DOWN;
        } else if (moveDirection == MovementDirection.LEFT.ordinal()) {
            movementDirection = MovementDirection.LEFT;
        } else {
            movementDirection = null;
        }

        return movementDirection;
    }
}
