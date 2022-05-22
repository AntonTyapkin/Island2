package Core;

/**
 * @author Nikolay Gabaraev
 * @created 21.05.2022
 * @project JavaRush_Module-2
 */

import Fauna.Animal;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

public class GeneratorFauna {

    public GeneratorFauna() {
    }

    public List<Animal> generateFauna(Set<Class> faunaClasses) {

        List<Animal> faunaArray = new CopyOnWriteArrayList<>();

        for (Class c : faunaClasses) {
            try {
                Field maxOnCellField = c.getDeclaredField("maxOnCell");
                maxOnCellField.setAccessible(true);
                int count = 1 + (int) (Math.random() * (((int) maxOnCellField.get(null) - 1)));
                Constructor<Animal> constr = c.getConstructor();
                for (int k = 0; k <= count; k++) {
                    Animal animal = constr.newInstance();
                    faunaArray.add(animal);
                }
            } catch (NoSuchFieldException | IllegalAccessException | NoSuchMethodException | InvocationTargetException |
                     InstantiationException e) {
                throw new RuntimeException(e);
            }
        }

        return faunaArray;
    }

    public void reproductionFauna(Set<Class> faunaClasses, List<Animal> fauna) {
        for (Class c : faunaClasses) {
            int reproductionChance = (int) (Math.random() * 2 + 1);
            if (reproductionChance == 1) {
                int male = 0;
                int female = 0;
                int childCount = 0;
                for (Animal predator : fauna) {
                    if (c.getSimpleName().equals(predator.getClass().getSimpleName())) {
                        if (predator.getGender() == 1) {
                            male++;
                        } else {
                            female++;
                        }
                    }
                }


                if (male >= female && female > 0) {
                    childCount = female;
                }if (female >= male && male > 0){
                    childCount = male;
                }
                if (childCount != 0) {
                    try {
                        Field maxOnCellField = c.getDeclaredField("maxOnCell");
                        maxOnCellField.setAccessible(true);
                        int count =(int) maxOnCellField.get(null);
                        if ((male + female + childCount) < count) {
                            Constructor<Animal> constr = c.getConstructor();
                            for (int k = 0; k <= childCount; k++) {
                                Animal animal = constr.newInstance();
                                fauna.add(animal);
                            }
                        } else {
                            count = count - (male + female);
                            if (count > 0) {
                                Constructor<Animal> constr = c.getConstructor();
                                for (int k = 0; k < count; k++) {
                                    Animal animal = constr.newInstance();
                                    fauna.add(animal);
                                }
                            }
                        }
                    } catch (NoSuchFieldException | IllegalAccessException | NoSuchMethodException | InvocationTargetException |
                             InstantiationException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }
}
