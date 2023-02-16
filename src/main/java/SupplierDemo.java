import java.util.function.Supplier;

public class SupplierDemo {
    private final Supplier<Double> getRandom = Math::random;
    void show(){
        System.out.println(getRandom.get());
    }
}
