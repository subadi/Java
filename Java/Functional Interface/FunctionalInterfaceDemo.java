import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionalInterfaceDemo {

    public static void main(String[] args) {
        // Consumer: accepts a single input argument and returns no result (Single Input,No Return type)
        Consumer<String> consumer = (name) -> System.out.println("Consumer: " + name);
        consumer.accept("Hello, World!");

        // Supplier: supplies a result of a given type (No Input,Return type)
        Supplier<String> supplier = () -> "Supplier: Generated Value Hello, World!";
        System.out.println(supplier.get());

        // Function: accepts one argument and produces a result (Single Input,Return type)
        Function<Integer, String> function = (num) -> "Function Multiply is: " + (num * 2);
        System.out.println(function.apply(5));

        // Predicate: accepts one argument and returns a boolean (Single Input,Return type - boolean)
        Predicate<Integer> predicate = (num) -> num > 10;
        System.out.println("Predicate: " + predicate.test(15));
        System.out.println("Predicate: " + predicate.test(5));
    }
}
