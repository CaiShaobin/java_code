import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class AbinTest2 {

    @Test
    public void forEach(){
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        numbers.stream().forEach(System.out::println);
    }

    @Test
    public void forEachOrdered(){
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        numbers.stream().forEachOrdered(System.out::println);
    }

    @Test
    public void toArray(){
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        Integer[] numbersArray = numbers.stream().toArray(Integer[]::new);
        System.out.println(Arrays.toString(numbersArray));
    }

    @Test
    public void reduce(){
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> sum = numbers.stream().reduce((x, y) -> x + y);
        System.out.println(sum.get());
    }

    @Test
    public void min(){
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> min = numbers.stream().min(Integer::compareTo);
        System.out.println(min.get());
    }

    @Test
    public void max(){
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> max = numbers.stream().max(Integer::compareTo);
        System.out.println(max.get());
    }

    @Test
    public void count(){
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        long count = numbers.stream().count();
        System.out.println(count);
    }

    @Test
    public void anyMatch(){
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        boolean anyEven = numbers.stream().anyMatch(n -> n % 2 == 0);
        System.out.println(anyEven);
    }

    @Test
    public void allMatch(){
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        boolean allEven = numbers.stream().allMatch(n -> n % 2 == 0);
        System.out.println(allEven);
    }

    @Test
    public void noneMatch(){
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        boolean noneEven = numbers.stream().noneMatch(n -> n % 2 == 0);
        System.out.println(noneEven);
    }

    @Test
    public void findFirst(){
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> firstEven = numbers.stream().filter(n -> n % 2 == 0).findFirst();
        System.out.println(firstEven.get());
    }

    @Test
    public void findAny(){
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> anyEven = numbers.stream().filter(n -> n % 2 == 0).findAny();
        System.out.println(anyEven.get());
    }
}
