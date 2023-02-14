import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class MejorasApiStreamsTest {

    @Test
    public void methodTest() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        // Creación de un flujo paralelo
        numbers.parallelStream()
                .forEach(System.out::println);
    }

    @Test
    public void creacionFlujoInfinito() {
        // Creación de un flujo infinito
        Stream<Integer> infiniteStream = Stream.iterate(0, i -> i + 1);
        // Uso de la nueva función takeWhile para limitar el flujo infinito
        infiniteStream.takeWhile(i -> i < 10)
                .forEach(System.out::println);
    }

    @Test
    public void dropWhileAndTakeWhile() {
        /** Métodos dropWhile y takeWhile: Estos métodos permiten limitar un flujo basándose en una condición.
         * dropWhile permite descartar los elementos al principio del flujo hasta que se cumple una condición,
         * mientras que takeWhile permite tomar elementos hasta que se cumple una condición. **/
        // Arrange
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        // Uso de dropWhile
        numbers.stream()
                .dropWhile(i -> i < 5)
                .forEach(System.out::println);
        System.out.println("************************************************");
        // Uso de takeWhile
        numbers.stream()
                .takeWhile(i -> i < 5)
                .forEach(System.out::println);
    }

    @Test
    public void ofNullableTest() {
        /** Método ofNullable: Este método permite crear un flujo a partir de un objeto opcional.
         * Si el objeto opcional es nulo, se crea un flujo vacío, de lo contrario,
         * se crea un flujo con un solo elemento. **/
        String name = null;
        Stream<String> stream = Stream.ofNullable(name);
        stream.forEach(System.out::println);
    }

    @Test
    public void parallelStreamTest() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        // Uso de parallelStream con un número específico de hilos
        numbers.parallelStream()
                .parallel()
                .forEach(System.out::println);
    }

    @Test
    public void streamIterateLimit() {
        // Uso de iterate
        Stream<Integer> infiniteStream = Stream.iterate(0, i -> i + 1);
        infiniteStream.limit(10)
                .forEach(System.out::println);
    }

    @Test
    public void streamLimit() {
        // Uso de generate
        Stream<String> randomStringStream = Stream.generate(() -> RandomStringUtils.randomAlphabetic(10));
        randomStringStream.limit(10)
                .forEach(System.out::println);
    }

    @Test
    public void streamConcat() {
        Stream<Integer> stream1 = Stream.of(1, 2, 3);
        Stream<Integer> stream2 = Stream.of(4, 5, 6);
        Stream<Integer> result = Stream.concat(stream1, stream2);
        result.forEach(System.out::println);
    }

    @Test
    public void groupingBy() {
        List<String> words = Arrays.asList("hello", "world", "java", "stream");
        Map<Integer, List<String>> result = words.stream().collect(Collectors.groupingBy(String::length));
        System.out.println(result);
    }

}
