import java.util.*;


public class LinkedHashSetExample {
    public static void main(String args[]){
        Set<String> linkedHashset = new LinkedHashSet<>(Arrays.asList("Apple","Banana","Mango","Apple","Dates"));
        System.out.println(linkedHashset);

        // Removing element 
        linkedHashset.remove("Mango");
        System.out.println(linkedHashset);
        
    }    
}
