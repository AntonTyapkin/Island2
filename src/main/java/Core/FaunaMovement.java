package Core;

/**
 * @author Nikolay Gabaraev
 * @created 21.05.2022
 * @project JavaRush_Module-2
 */

import Fauna.Animal;
import Fauna.Herbivor;
import Fauna.Predator;
import Island.Cell;

import java.lang.reflect.Field;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class FaunaMovement {


    public FaunaMovement() {
    }

    public void movingFaunaInCells(List<Animal> animalsList, Cell[][] island
            , int positionY, int positionX) {

        int MIN_Y = 0;
        int MIN_X = 0;
        int MAX_Y = island.length - 1;
        int MAX_X = island[MAX_Y].length - 1;

        for (Animal animal : animalsList) {
            int movementChance = ThreadLocalRandom.current().nextInt(0, 100);

            if (movementChance > 80) {

                int animalMove = ThreadLocalRandom.current().nextInt(0, animal.getSpeed());

                Field maxOnCellField = null;
                int maxOnCell = 0;
                try {
                    maxOnCellField = animal.getClass().getDeclaredField("maxOnCell");
                    maxOnCellField.setAccessible(true);
                    maxOnCell = (int) maxOnCellField.get(null);
                } catch (NoSuchFieldException | IllegalAccessException e) {
                    throw new RuntimeException(e);
                }


                MovementDirection movementDirection = animal.setDirection();

                int animalInCell = 0;
                if (animal instanceof Predator) {
                    animalInCell = (int) island[positionY][positionX].countPredators();
                } else if (animal instanceof Herbivor){
                    animalInCell = (int) island[positionY][positionX].countHerbivores();
                }
                if ( movementDirection.equals(MovementDirection.UP)) {
                    if ((positionY - animalMove) >= MIN_Y) {
                        if ((animalInCell + 1) <= maxOnCell) {
                            island[positionY - animalMove][positionX].addAnimal(animal);
                            animalsList.remove(animal);
                        }
                    }
                } else if (movementDirection.equals(MovementDirection.RIGHT)) {
                    if ((positionX + animalMove) <= MAX_X) {
                        if ((animalInCell + 1) <= maxOnCell) {
                            island[positionY][positionX + animalMove].addAnimal(animal);
                            animalsList.remove(animal);
                        }
                    }
                } else if (movementDirection.equals(MovementDirection.DOWN)) {
                    if ((positionY + animalMove) <= MAX_Y) {
                        if((animalInCell + 1) <= maxOnCell) {
                            island[positionY + animalMove][positionX].addAnimal(animal);
                            animalsList.remove(animal);
                        }
                    }
                } else if (movementDirection.equals(MovementDirection.LEFT)) {
                    if ((positionX - animalMove) >= MIN_X) {
                        if ((animalInCell + 1) <= maxOnCell ) {
                            island[positionY][positionX - animalMove].addAnimal(animal);
                            animalsList.remove(animal);
                        }
                    }
                }
            }
        }
    }
}
