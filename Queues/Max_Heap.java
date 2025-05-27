
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Max_Heap {
    public static void main(String[] args) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.addAll(List.of(3, 2, 1, 5, 3));
        System.out.println(maxHeap.peek()); 
        
    }
}
