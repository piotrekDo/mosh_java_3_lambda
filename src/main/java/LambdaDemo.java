public class LambdaDemo {

    private String lol = "lol";

    void show() {

        // wywołanie implementacji interfejsu
        greet(new ConsolePrinter());

        // klasa anonimowa
        greet(new Print() {
            @Override
            public void print(String message) {
                System.out.println(lol + message);
            }
        });

        //lambda
        greet((String message) -> {
            System.out.println( lol+ message);
        });

        //lambda krótki zapis
        greet(message -> System.out.println(message));
    }

    void greet(Print print) {
        print.print("Hello world");
    }
}
