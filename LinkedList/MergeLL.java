
import java.util.*;


public class MergeLL {
    public static void main(String[] args) {
        LinkedList<Integer> list1 = new LinkedList<>(List.of(1,2,3,4));
        LinkedList<Integer> list2 = new LinkedList<>(List.of(4,8,1,33,7));

        list1.addAll(list2);
        System.out.println("merged list before sorting: " + list1);
        Collections.sort(list1);
        System.out.println("merged list after sorting: " + list1);

        // to remove duplicates
        Set<Integer> uniqueElements = new LinkedHashSet<>(list1);
        System.out.println(uniqueElements);
    }
}
