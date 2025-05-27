
import java.util.*;

public class LinkedList_creation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList<Integer> list = new LinkedList<>();
        System.out.println("Enter size ");
        int n = sc.nextInt();
        for(int i = 0;i<n;i++){
            list.add(sc.nextInt());

        }
        for(int i : list) System.out.print(i +" ");

        // Traversing using Iterator
        System.out.println();
        System.out.println("LinkedList ");
        Iterator<Integer> iter = list.iterator();
        while(iter.hasNext()){
            System.out.print(iter.next() + " ");

        }

        // Traversing  using forEach loop \
        System.out.println();
        System.out.println("Using forEach loop");
        list.forEach(e -> System.out.print(e + " "));
        sc.close();

    }
}