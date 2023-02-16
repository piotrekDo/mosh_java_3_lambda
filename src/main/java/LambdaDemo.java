public class LambdaDemo {

    void show() {
        // wywołanie implementacji interfejsu
        greet(new ConsolePrinter());

        // klasa anonimowa
        greet(new Print() {
            @Override
            public void print(String message) {
                System.out.println(message);
            }
        });

        //lambda
        greet((String message) -> {
            System.out.println(message);
        });

        //lambda krótki zapis
        greet(message -> System.out.println(message));
    }

    void greet(Print print) {
        print.print("Hello world");
    }
}
