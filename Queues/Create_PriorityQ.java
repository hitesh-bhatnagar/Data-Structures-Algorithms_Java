import java.util.*;

public class Create_PriorityQ{
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(List.of(3,2,1,5,3));
        System.out.println(pq);
        System.out.println("Highest priority element " +pq.peek());  // highest priority element
        System.out.println("Poll (remove top) "+pq.poll());
        System.out.println("After poll "+pq);
        System.out.println("Contains 45 ? " + pq.contains(15));

        pq.remove(2);
        System.out.println("After removing 2 "+pq);
        pq.clear();
        System.out.println("After clearing "+pq);
    }

}