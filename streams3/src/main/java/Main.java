import interfaces.ThreeFunction;

import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        ThreeFunction<Integer, Integer, Integer, Color> produceColor = Color::new;

        System.out.println("New Color - " + produceColor.apply(2,23,54));
        System.out.println("New Color - " + produceColor.apply(243,33,66));
        System.out.println("New Color - " + produceColor.apply(234,232,234));

        Color[] colors = {
                produceColor.apply(2,23,54),
                produceColor.apply(150,123,66),
                produceColor.apply(234,232,234)
        };

        ThreeFunction<Color[], Predicate<Integer>, Predicate<Integer>, List<Color>> colorFilter =
                (c, p1, p2) -> Arrays.stream(c)
                                    .filter(color -> p1.test(color.getRed()))
                                    .filter(color -> p2.test(color.getGreen()))
                                    .collect(Collectors.toList());

        System.out.println("R > 100 and G > 100");
        colorFilter.apply(colors, r -> r > 100, g -> g >100)
                .forEach(System.out::println);

        System.out.println("R > 150 and G > 150");
        colorFilter.apply(colors, r -> r > 150, g -> g > 150)
                .forEach(System.out::println);

    }
}
