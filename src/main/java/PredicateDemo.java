import java.util.function.Predicate;

public class PredicateDemo {

    void show(){
        Predicate<String> hasLeftBrace = str -> str.startsWith("{");
        Predicate<String> hasRightBrace = str -> str.endsWith("}");
        System.out.println(hasLeftBrace.and(hasRightBrace).test("{LOL}"));;
    }
}
