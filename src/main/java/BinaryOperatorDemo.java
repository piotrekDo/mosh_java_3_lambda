import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;

public class BinaryOperatorDemo {
    BinaryOperator<Integer> add = (a, b) -> a + b;
    Function<Integer, Integer> square = a -> a * a;

    BiFunction<Integer, Integer, Integer> addAndSquare = add.andThen(square);

    void show() {
        System.out.println(add.andThen(square).apply(1,2));
        System.out.println(addAndSquare.apply(1,2));
    }
}
