package Island;

/**
 * @author Nikolay Gabaraev
 * @created 14.05.2022
 * @project JavaRush_Module-2
 */

import Core.*;
import Fauna.Animal;
import Fauna.Herb;
import Fauna.Herbivor;
import Fauna.Herbivores.*;
import Fauna.Predator;
import Fauna.Predators.*;
import com.sun.tools.javac.Main;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Cell {

    GeneratorFauna generatorFauna = new GeneratorFauna();
    FaunaMovement faunaMovement = new FaunaMovement();
    Set<Class> predatorsClasses = ScanClasses.getPredatorsClasses();
    Set<Class> herbivoresClasses = ScanClasses.getHerbivoresClasses();

    private final List<Animal> predators = generatorFauna.generateFauna(predatorsClasses);
    //private final List<Animal> predators = Collections.synchronizedList(new ArrayList<>());
    private final List<Animal> herbivors = generatorFauna.generateFauna(herbivoresClasses);
    //private final List<Animal> herbivors = Collections.synchronizedList(new ArrayList<>());
    private final List<Herb> herbs = new CopyOnWriteArrayList<>();
    //private final List<Herb> herbs = Collections.synchronizedList(new ArrayList<>());

    public Cell() {
        generateHerbs();
    }

    private void generateHerbs() {
        int countCreate = 1 + (int) (Math.random() * ((Herb.getMaxOnCell() - 1)));
        for (int k = 0; k <= countCreate; k++) {
            herbs.add(new Herb());
        }
    }

    public Animal getPredator() {
        int randomIndex = 1 + (int) (Math.random() * ((predators.size() - 1)));
        return predators.get(randomIndex);
    }

    public void addHerb() {

        if (this.herbs.size() < Settings.herbsMaxOnCell) {
            int diff = Settings.herbsMaxOnCell - this.herbs.size();
            int getIntCalculate = 1 + (int) (Math.random() * ((diff - 1)));
            for (int i = 0; i < getIntCalculate; i++) {
                this.herbs.add(new Herb());
            }
        }
    }

    public void addAnimal(Animal animal) {
        if (animal instanceof Predator) {
            predators.add(animal);
        } else if (animal instanceof Herbivor){
            herbivors.add(animal);
        } else {
            System.out.println("Ошибка в addAnimal!");
        }
    }

    public void removeHerb() {
        this.herbs.remove(0);
    }

    public long countHerbs() {
        return herbs.size();
    }

    public long countPredators() {
        return predators.size();
    }

    public long countHerbivores() {
        return herbivors.size();
    }

    public String countEachPredator() {
        int wolf = 0;
        int snake = 0;
        int fox = 0;
        int bear = 0;
        int eagle = 0;
        StringBuilder st = new StringBuilder();
        for (Animal predator : predators) {
            if (predator.getClass().equals(Wolf.class)) {
                wolf++;
            } else if (predator.getClass().equals(Snake.class)) {
                snake++;
            } else if (predator.getClass().equals(Fox.class)) {
                fox++;
            } else if (predator.getClass().equals(Bear.class)) {
                bear++;
            } else if (predator.getClass().equals(Eagle.class)) {
                eagle++;
            }
        }
        st.append("Волков:").append(wolf)
                .append(" Змей: ").append(snake)
                .append(" Лис:").append(fox)
                .append(" Медведь:").append(bear)
                .append(" Орел:").append(eagle);

        return String.valueOf(st);
    }

    public String countEachHerbivor() {
        int horse = 0;
        int deer = 0;
        int rabbit = 0;
        int hamster = 0;
        int goat = 0;
        int sheep = 0;
        int kangoroo = 0;
        int cow = 0;
        int duck = 0;
        int caterpillar = 0;
        StringBuilder st = new StringBuilder();
        for (Animal herbivor : herbivors) {
            if (herbivor.getClass().equals(Horse.class)) {
                horse++;
            } else if (herbivor.getClass().equals(Deer.class)) {
                deer++;
            } else if (herbivor.getClass().equals(Rabbit.class)) {
                rabbit++;
            } else if (herbivor.getClass().equals(Hamster.class)) {
                hamster++;
            } else if (herbivor.getClass().equals(Goat.class)) {
                goat++;
            } else if (herbivor.getClass().equals(Sheep.class)) {
                sheep++;
            } else if (herbivor.getClass().equals(Kangoroo.class)) {
                kangoroo++;
            } else if (herbivor.getClass().equals(Cow.class)) {
                cow++;
            } else if (herbivor.getClass().equals(Duck.class)) {
                duck++;
            } else if (herbivor.getClass().equals(Caterpillar.class)) {
                caterpillar++;
            }
        }
        st.append("Лошадей:").append(horse)
                .append(" Оленей: ").append(deer)
                .append(" Зайцев:").append(rabbit)
                .append(" Хоямков:").append(hamster)
                .append(" Коз:").append(goat)
                .append(" Овец:").append(sheep)
                .append(" Кенгуру:").append(kangoroo)
                .append(" Коров:").append(cow)
                .append(" Уток:").append(duck)
                .append(" Гучениц:").append(caterpillar);

        return String.valueOf(st);
    }

    public void tryToReproductionPredators() {
        generatorFauna.reproductionFauna(predatorsClasses, predators);
    }
    public void tryToReproductionHerbivores() {
        generatorFauna.reproductionFauna(herbivoresClasses, herbivors);
    }

    public void decreaseSatiety() {
        for (Animal predator : predators) {
            if (predator.getStarvingTime() <= 0) {
                predators.remove(predator);
            } else {
                predator.decreaseSatiety();
            }
        }
        for (Animal herbivor : herbivors) {
            if (herbivor.getStarvingTime() <= 0) {
                herbivors.remove(herbivor);
            } else {
                herbivor.decreaseSatiety();
            }
        }
    }

    public void tryToEat(){
        for (Animal predator : predators) {
            predator.eat(herbivors);
        }
        for (Animal herbivor : herbivors) {
            herbivor.eat(herbs);
        }
    }

    public void tryToMove(int positionY, int positionX) {

        Cell[][] island = Island.getStaticIsland();
        //System.out.println("done");
        faunaMovement.movingFaunaInCells(predators, island, positionY, positionX);
        //System.out.println("done - Predators");
        faunaMovement.movingFaunaInCells(herbivors, island, positionY, positionX);
        //System.out.println("done - Herbivores");

    }

}
