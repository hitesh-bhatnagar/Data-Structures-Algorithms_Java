import java.util.List;
import java.util.PriorityQueue;

public class MergePQ {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(List.of(1,4,7));
        PriorityQueue<Integer> pq2 = new PriorityQueue<>(List.of(2,5,8));

        pq.addAll(pq2);
        
        System.out.println(pq);
    }
}
