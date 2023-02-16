public class LambdaDemo {

    void show() {
        greet(new ConsolePrinter());

        greet(new Print() {
            @Override
            public void print(String message) {
                System.out.println(message);
            }
        });
    }

    void greet(Print print) {
        print.print("Hello world");
    }
}
