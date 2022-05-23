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

import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Cell {
    //Объект генерирующий фауну
    GeneratorFauna generatorFauna = new GeneratorFauna();
    //Объект отвечающий за передвижения
    FaunaMovement faunaMovement = new FaunaMovement();
    //Сеты с классами из пакетов Fauna.Herbivores и Fauna.Predators
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
        int countCreate = ThreadLocalRandom.current().nextInt(1, Herb.getMaxOnCell());
        for (int k = 0; k <= countCreate; k++) {
            herbs.add(new Herb());
        }
    }

    public void addHerb() {
        if (this.herbs.size() < Settings.herbsMaxOnCell) {
            int diff = Settings.herbsMaxOnCell - this.herbs.size();
            int getIntCalculate = ThreadLocalRandom.current().nextInt(1, diff);
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

    public String countEachHerbivore() {
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

    public void tryToReproduction() {
        generatorFauna.reproductionFauna(predatorsClasses, predators);
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
        for (Animal herbivore : herbivors) {
            if (herbivore.getStarvingTime() <= 0) {
                herbivors.remove(herbivore);
            } else {
                herbivore.decreaseSatiety();
            }
        }
    }

    public void tryToEat(){
        for (Animal predator : predators) {
            predator.eat(herbivors);
        }
        for (Animal herbivore : herbivors) {
            herbivore.eat(herbs);
        }
    }

    public void tryToMove(int positionY, int positionX) {
        Cell[][] island = Island.getStaticIsland();
        faunaMovement.movingFaunaInCells(predators, island, positionY, positionX);
        faunaMovement.movingFaunaInCells(herbivors, island, positionY, positionX);
    }

}
