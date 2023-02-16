import java.util.List;
import java.util.function.Consumer;

public class ConsumerDemo {
    private final Consumer<String> print = System.out::print;
    private final Consumer<String> printUppercase = item -> System.out.print(item.toUpperCase());
    private final Consumer<String> printLowercase = item -> System.out.print(item.toLowerCase());

    void show() {
        List<String> list = List.of("a", "b", "c");
        list.forEach(print.andThen(printUppercase).andThen(printLowercase));
    }
}
