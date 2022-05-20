package Core;

import com.google.common.reflect.ClassPath;
import java.io.IOException;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Nikolay Gabaraev
 * @created 19.05.2022
 * @project JavaRush_Module-2
 */
public class ScanClasses {

    private static Set<Class> predatorsClasses;
    private static Set<Class> herbivoresClasses;

    static {
        {
            try {
                predatorsClasses = findAllClassesUsingGoogleGuice(
                        "fauna.predators");
                herbivoresClasses = findAllClassesUsingGoogleGuice(
                        "fauna.herbivores");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static Set<Class> findAllClassesUsingGoogleGuice(String packageName) throws IOException {
        return ClassPath.from(ClassLoader.getSystemClassLoader())
                .getAllClasses()
                .stream()
                .filter(clazz -> clazz.getPackageName()
                        .equalsIgnoreCase(packageName))
                .map(clazz -> clazz.load())
                .collect(Collectors.toSet());
    }

    public static Set<Class> getPredatorsClasses() {
        return predatorsClasses;
    }

    public static Set<Class> getHerbivoresClasses() {
        return herbivoresClasses;
    }
}
