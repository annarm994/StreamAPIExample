import java.util.*;
import java.util.stream.*;

public class StreamExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        
        System.out.println("Even numbers:");
        numbers.stream()
               .filter(n -> n % 2 == 0)
               .forEach(System.out::println);
        
        System.out.println("\nSquared numbers:");
        numbers.stream()
               .map(n -> n * n)
               .forEach(System.out::println);
        
        System.out.println("\nCubed odd numbers:");
        numbers.stream()
               .filter(n -> n % 2 != 0)
               .map(n -> n * n * n)
               .forEach(System.out::println);
        
        int sum = numbers.stream()
                          .reduce(0, Integer::sum);
        System.out.println("\nSum of all numbers: " + sum);
        
        List<Integer> evenNumbers = numbers.stream()
                                           .filter(n -> n % 2 == 0)
                                           .collect(Collectors.toList());
        System.out.println("\nEven numbers collected: " + evenNumbers);
        
        List<List<Integer>> listOfLists = Arrays.asList(
            Arrays.asList(1, 2, 3),
            Arrays.asList(4, 5, 6),
            Arrays.asList(7, 8, 9)
        );
        List<Integer> flattenedList = listOfLists.stream()
                                                 .flatMap(List::stream)
                                                 .collect(Collectors.toList());
        System.out.println("\nFlattened list: " + flattenedList);
        
        Map<Boolean, List<Integer>> groupedNumbers = numbers.stream()
                                                            .collect(Collectors.groupingBy(n -> n % 2 == 0));
        System.out.println("\nGrouped numbers by even/odd: " + groupedNumbers);
        
        List<Person> people = Arrays.asList(
            new Person("Alice", 30),
            new Person("Bob", 20),
            new Person("Charlie", 40),
            new Person("David", 25)
        );
        
        System.out.println("\nPeople older than 25:");
        people.stream()
              .filter(p -> p.getAge() > 25)
              .map(Person::getName)
              .forEach(System.out::println);
        
        Person oldestPerson = people.stream()
                                     .max(Comparator.comparingInt(Person::getAge))
                                     .orElseThrow(() -> new NoSuchElementException("No person found"));
        System.out.println("\nOldest person: " + oldestPerson.getName() + ", Age: " + oldestPerson.getAge());
    }
}
