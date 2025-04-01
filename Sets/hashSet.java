import java.util.*;

public class hashSet{
    public static void main(String args[]){

        Set<String> hashSet = new HashSet<>();
        hashSet.add("Apple");
        hashSet.add("Banana");
        hashSet.add("Mango");
        hashSet.add("Apple");

        System.out.println(hashSet);

        // removing an element
        hashSet.remove("Mango");
        // check if contians
        System.out.println(hashSet.contains("Mango"));
        
        
        // Add all elements from another collection

        Set<String> UnionSet = new HashSet<>(Arrays.asList("Date","Grapes","Orange"));
        UnionSet.addAll(hashSet);
        System.out.println(UnionSet);


        // Retain only common elelmtns (Intersection)
        Set<String> IntersectionSet = new HashSet<>(Arrays.asList("Date","Grapes","Apple"));
        IntersectionSet.retainAll(hashSet);
        System.out.println(IntersectionSet);

        // convert to array

        Object[] arr = hashSet.toArray();
        System.out.println(Arrays.toString(arr));

    }
}