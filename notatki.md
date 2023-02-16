# Interfejsy funkcyjne

Interejs funkcyjny posiada tylko jedną metodę abstrakcyjną. Może posiadać metody domyślne oraz statyczne. Nazywane rónież
SAM Interfaces.

## Anonimmowe klasy wewnętrzne
Czasem, zamiast tworzenia klasy będącej implementacją interfejsu można stworzyć klasę lokalną będącą jednoraową implementacją.
Klasę nazywamy anonimową ponieważ nie posiada nawet nazwy, jest jedynie lokalną implementacją. Klasy takie mogą być
tworzone wewnątrz metod przyjmujących implementację interejsu jako parametr. Przykładowo możemy zdefioniować *interfejs 
funkcyjny*:
```
public interface Print {
    void print(String message);
}
```
Zamiast pisać jego implementację w postaci klasy:
```
public class ConsolePrinter  implements Print{
    @Override
    public void print(String message) {
        System.out.println(message);
    }
}
```
Można wykorzystać klasę anonimową:
```
public class LambdaDemo {
    void show() {
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
```
Wywołując metodę ``greet`` przyjmującą interfejs ``Print`` utworzyliśmy jego implementację. 