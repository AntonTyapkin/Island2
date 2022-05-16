package Island;

/**
 * @author Nikolay Gabaraev
 * @created 14.05.2022
 * @project JavaRush_Module-2
 */

import Fauna.Animal;
import Fauna.Herb;
import Fauna.Herbivor;
import Fauna.Herbivores.*;
import Fauna.Predators.*;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Cell {
    private final List<Animal> predators = new CopyOnWriteArrayList<>();
    private final List<Animal> herbivors = new CopyOnWriteArrayList<>();
    private final List<Herb> herbs = new CopyOnWriteArrayList<>();

    public Cell() {
        generatePredators();
        generateHerbivores();
        generateHerbs();
    }

    private void generatePredators() {
        int countCreateWolf = 1 + (int) (Math.random() * ((Wolf.getMaxOnCell() - 1)));
        int countCreateBear = 1 + (int) (Math.random() * ((Bear.getMaxOnCell() - 1)));
        int countCreateEagle = 1 + (int) (Math.random() * ((Eagle.getMaxOnCell() - 1)));
        int countCreateFox = 1 + (int) (Math.random() * ((Fox.getMaxOnCell() - 1)));
        int countCreateSnake = 1 + (int) (Math.random() * ((Snake.getMaxOnCell() - 1)));
        for (int k = 0; k <= countCreateWolf; k++) {
            predators.add(new Wolf());
        }
        for (int k = 0; k <= countCreateBear; k++) {
            predators.add(new Bear());
        }
        for (int k = 0; k <= countCreateEagle; k++) {
            predators.add(new Eagle());
        }
        for (int k = 0; k <= countCreateFox; k++) {
            predators.add(new Fox());
        }
        for (int k = 0; k <= countCreateSnake; k++) {
            predators.add(new Snake());
        }
    }

    private void generateHerbivores() {
        int countCreateHorse = 1 + (int) (Math.random() * ((Horse.getMaxOnCell() - 1)));
        int countCreateDeer = 1 + (int) (Math.random() * ((Deer.getMaxOnCell() - 1)));
        int countCreateRabbit = 1 + (int) (Math.random() * ((Rabbit.getMaxOnCell() - 1)));
        int countCreateHamster = 1 + (int) (Math.random() * ((Hamster.getMaxOnCell() - 1)));
        int countCreateGoat = 1 + (int) (Math.random() * ((Goat.getMaxOnCell() - 1)));
        int countCreateSheep = 1 + (int) (Math.random() * ((Sheep.getMaxOnCell() - 1)));
        int countCreateKangoroo = 1 + (int) (Math.random() * ((Kangoroo.getMaxOnCell() - 1)));
        int countCreateCow = 1 + (int) (Math.random() * ((Cow.getMaxOnCell() - 1)));
        int countCreateDuck = 1 + (int) (Math.random() * ((Duck.getMaxOnCell() - 1)));
        int countCreateCaterpillar = 1 + (int) (Math.random() * ((Caterpillar.getMaxOnCell() - 1)));
        for (int k = 0; k <= countCreateHorse; k++) {
            herbivors.add(new Horse());
        }
        for (int k = 0; k <= countCreateDeer; k++) {
            herbivors.add(new Deer());
        }
        for (int k = 0; k <= countCreateRabbit; k++) {
            herbivors.add(new Rabbit());
        }
        for (int k = 0; k <= countCreateHamster; k++) {
            herbivors.add(new Hamster());
        }
        for (int k = 0; k <= countCreateGoat; k++) {
            herbivors.add(new Goat());
        }
        for (int k = 0; k <= countCreateSheep; k++) {
            herbivors.add(new Sheep());
        }
        for (int k = 0; k <= countCreateKangoroo; k++) {
            herbivors.add(new Kangoroo());
        }
        for (int k = 0; k <= countCreateCow; k++) {
            herbivors.add(new Cow());
        }
        for (int k = 0; k <= countCreateDuck; k++) {
            herbivors.add(new Duck());
        }
        for (int k = 0; k <= countCreateCaterpillar; k++) {
            herbivors.add(new Caterpillar());
        }
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
        //int getIntCalculate = 1 + (int) (Math.random() * ((this.herbs.size() - 1)));
        if (this.herbs.size() < 10000) {
            this.herbs.add(new Herb());
        }
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
        int wolf = 0;
        int snake = 0;
        int fox = 0;
        int bear = 0;
        int eagle = 0;
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
        if (wolf < Wolf.getMaxOnCell()) {
            predators.add(new Wolf());
        }
        if (snake % 2 == 0 && snake < Snake.getMaxOnCell()) {
            predators.add(new Snake());
        }
        if (fox % 2 == 0 && fox < Fox.getMaxOnCell()) {
            predators.add(new Fox());
        }
        if (bear % 2 == 0 && bear < Bear.getMaxOnCell()) {
            predators.add(new Bear());
        }
        if (eagle % 2 == 0 && eagle < Eagle.getMaxOnCell()) {
            predators.add(new Eagle());
        }
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

    public void tryToEatPredators(){

    }

    public void tryToEatHerbivores() {
        herbivors.forEach(animal -> animal.eat(herbs));
    }

}
