import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AbinTest1 {

    @Test
    public void filter(){
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<Integer> evenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println(evenNumbers);
    }

    @Test
    public void map(){
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");

        List<String> upperCaseNames = names.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println(upperCaseNames);
    }

    @Test
    public void flatMap(){
        List<List<String>> lists = Arrays.asList(
                Arrays.asList("a", "b"),
                Arrays.asList("c", "d"),
                Arrays.asList("e", "f")
        );

        List<String> flatList = lists.stream()
                .flatMap(list -> list.stream())
                .collect(Collectors.toList());
        System.out.println(flatList);

    }

    @Test
    public void distinct(){
        List<Integer> numbers = Arrays.asList(1, 2, 3, 3, 4, 4, 5, 5);

        List<Integer> distinctNumbers = numbers.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println(distinctNumbers);

    }

    @Test
    public void sorted(){
        List<Integer> numbers = Arrays.asList(5, 3, 8, 1, 4, 2);

        List<Integer> sortedNumbers = numbers.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println(sortedNumbers);
    }

    @Test
    public void limit(){
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> firstThreeNumbers = numbers.stream()
                .limit(3)
                .collect(Collectors.toList());
        System.out.println(firstThreeNumbers);
    }

    @Test
    public void skip(){
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> numbersAfterTheFirstThree = numbers.stream()
                .skip(3)
                .collect(Collectors.toList());
        System.out.println(numbersAfterTheFirstThree);
    }

    @Test
    public void peek(){
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> numbersWithPeek = numbers.stream()
                .peek(n -> System.out.println("original: " + n))
                .map(n -> n * 2)
                .peek(n -> System.out.println("doubled: " + n))
                .collect(Collectors.toList());
        System.out.println(numbersWithPeek);

    }

    @Test
    public void concat(){
        Stream<Integer> s1 = Stream.of(1, 2, 3);
        Stream<Integer> s2 = Stream.of(4, 5, 6);
        List<Integer> s3 = Stream.concat(s1, s2).collect(Collectors.toList());
        System.out.println(s3);

    }
}
