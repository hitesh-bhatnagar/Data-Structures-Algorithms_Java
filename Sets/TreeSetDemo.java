import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class TreeSetDemo {
    public static void main(String[] args) {
        Set<Integer> treeset = new TreeSet<>();
        treeset.add(42);
        treeset.add(15);
        treeset.add(8);
        treeset.add(99);
        System.out.println(treeset);

        // Using navigable set methods
        TreeSet<Integer> ts = (TreeSet<Integer>) treeset;
        System.out.println("First element " + ts.first());
        System.out.println("Last element " + ts.last());
        System.out.println("Element less than 20 " + ts.lower(20));
        System.out.println("Element greater than 20 " + ts.higher(20));
        System.out.println("Element less than or equal to 20 " + ts.floor(20));
        System.out.println("Element greater than or equal to 20 " + ts.ceiling(20));
        System.out.println("HeadSet (<42) " + ts.headSet(42));
        System.out.println("TailSet (>42) " + ts.tailSet(42));

        // Subset between 15 (inclusive) and 99 (exclusive)
        SortedSet<Integer> subSet = ts.subSet(15, 99);
        System.out.println("Subset between 15 and 99 " + subSet);
    }
}