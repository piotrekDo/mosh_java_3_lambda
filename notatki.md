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

## Wyrażenia lambda
Wyrażenia lambda pozwalają na uproszczony zapis klasy anonimowej. WYkorzystują tzw. *funkcję strzałkową* i reprezentują
paradygmat programowania funkcyjnego. Najprostrzy zapis wyglądałby następująco:
```
greet((String message) -> {
    System.out.println(message);
});
}

void greet(Print print) {
    print.print("Hello world");
}
```
Ponownie wywołujemy metodę ``greet``. Składnia wyrażenia lambda wymaga przekazania argumentów w nawiasach okrągłych.
W przypadku metody void będzie to pusty nawias. Nasępnie wykorzystujemy *funkcję strzałkową* -> i w nawiasach klamrowych
zapisujemy ciało nadpisywanej metody. 

### Lambda- zapis uproszczony
Powyższy przykład nie różni się specjalnie od zapisu kalsy anonimowej. W dalszym ciągu mamy kilka liniej kodu a celem
wyrażeń lambda jest uproszczenie zapisu, często do jednej linjki.  
- **Możemy pominąć typ argumentu** kompilator jest w stanie wywnioskować, że metoda przyjmuje *String* więc zapis ten jest
niepotrzebny i typ parametru wynika z sygnatury metody w interfejsie.  
- **W przypadku jenego argumentu nie musimy stosować nawiasów** nawiasy są konieczne w przypadku metod *void* lub gdy musimy
przekazać kilka argumentów.  
- **Nie potrzebujemy nawiasów klamrowych w przypadku jednej linijki kodu** nawiasy są konieczne jedynie przy kilkulinijkowej
implementacji.  
- **Nie musimy zapisywać *return* w przypadku jednej linijki** jak powyżej- w przypadku implementacji jednolinijkowych i metod
posiadających typ zwracany, *return* jest wymagany tylko w sytuacji gdy zapisujemy kilka lini kodu w nawiaach klamrowych.  
  
W rezultacie otrzymamy czytelny zapis w postaci jednej linijki:  
``greet(message -> System.out.println(message));``  
  

### this, różnice mięcy wyrażeniami lambda i klasami anonimowymi
W wyrażeniach lambda słowo kluczowe ``this`` odnosi się do klasy w której wyrażenie jest zapisywane. W przypadku klas anonimowych
``this`` osniesie się do samej siebie, konkretnej implementacji, nie interfejsu który klasa nadpisuje. Klasy anonimowe
mogą posiadać pola, wyrażenia lambda nie. Jeden i drugi zapis pozwala odnosić się do pól klasy w której się poruszamy.

## Referencje do metod
Z referencji do metod możemy skorzystać gdy w ramach implementacji interfejsu wzystko co robimy to przekazanie obiektu
do metody, jak w przykładnie z interfejsem ``Print``. Schemat takiego zapisu wygląda następująco: **klasa/obiekt::metoda** 
np. ``greet(System.out::println);`` gdzie ``System.out`` jest obiektem zawierającym metodę ``println`` oddzieloną dwoma dwukropkami.

## Referencje do konstruktorów
Dzialanie jest identyczne w przypadku konstruktorów wywoływanych jako ``obiekt::new``