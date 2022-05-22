package Fauna;

import Core.MovementDirection;
import Core.Settings;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

/**
 * @author Nikolay Gabaraev
 * @created 14.05.2022
 * @project JavaRush_Module-2
 */
public class Predatorc extends Animal implements Predator{

    public Predatorc(double weight, int speed, double satiety, int starvingTime) {
        super(weight, speed, satiety, starvingTime);
    }

    @Override
    public void eat(List<?> listOfFood) {
        try {
            int eatChance = ThreadLocalRandom.current().nextInt(0, 100);
            Map<String,Integer> mapOfChanceHunt = null;
            List<String> listOfHunts = null;
            String animalToEat = null;
            int ch = 0;
            if (this.getStarvingTime() == 0) {

                if (this.getClass().getSimpleName().equals("Wolf")) {
                    mapOfChanceHunt = Settings.wolfMap;
                } else if (this.getClass().getSimpleName().equals("Snake")) {
                    mapOfChanceHunt = Settings.snakeMap;
                } else if (this.getClass().getSimpleName().equals("Fox")) {
                    mapOfChanceHunt = Settings.foxMap;
                } else if (this.getClass().getSimpleName().equals("Bear")) {
                    mapOfChanceHunt = Settings.bearMap;
                } else if (this.getClass().getSimpleName().equals("Eagle")) {
                    mapOfChanceHunt = Settings.eagleMap;
                }

                if (mapOfChanceHunt != null) {
                    listOfHunts = mapOfChanceHunt.entrySet().stream()
                            .filter(entry -> eatChance <= entry.getValue())
                            .map(Map.Entry::getKey)
                            .collect(Collectors.toList());

                }
                if (listOfHunts != null && listOfHunts.size() > 0) {
                    ch = ThreadLocalRandom.current().nextInt(0, listOfHunts.size());
                    animalToEat = listOfHunts.get(ch);
                    for (Object herbivor : listOfFood) {
                        Herbivor herbivor1 = (Herbivor) herbivor;
                        if (animalToEat.equals(herbivor1.getClass().getSimpleName())) {
                            listOfFood.remove(herbivor);
                        }
                    }
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
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
