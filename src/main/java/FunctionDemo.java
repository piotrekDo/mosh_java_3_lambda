import java.util.function.Function;

public class FunctionDemo {
    private final Function<String, Integer> mapStrToInt = String::length;

    private final Function<String, String> replaceColon = str -> str.replace(":", "=");
    private final Function<String, String> addBraces = str -> "{" + str + "}";


    void show(){
        mapStrToInt.apply("Sky");


        System.out.println(replaceColon.andThen(addBraces).apply("key:value"));
        System.out.println(addBraces.compose(replaceColon).apply("key:value"));
    }
}
