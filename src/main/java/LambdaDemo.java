public class LambdaDemo {

    void show(){
        greet(new ConsolePrinter());
    }

    void greet(Print print){
        print.print("Hello world");
    }

}
