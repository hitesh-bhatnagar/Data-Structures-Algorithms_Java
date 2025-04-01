import java.util.*;
import java.util.stream.Collectors;


public class Sorting_and_Limiting {
    public static void main(String args[]){
        List<String> names = Arrays.asList("Alice","Charlie","David","Hitesh","Mohit");

        List<String> sortedNames = names.stream()
            .sorted()   // sort alphabatically
            .limit(3)   // take the first 3
            .collect(Collectors.toList());
        System.out.println(sortedNames);
    }
}