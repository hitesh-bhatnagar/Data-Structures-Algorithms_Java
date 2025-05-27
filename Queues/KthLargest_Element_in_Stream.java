
import java.util.PriorityQueue;



public class KthLargest_Element_in_Stream {

    PriorityQueue<Integer> pq;
    int k;
    public KthLargest_Element_in_Stream(int k , int[] nums){   // constructor
        this.k = k;
        pq = new PriorityQueue<>();
        for(int i : nums) add(i);
    }

    public int add(int num){
        pq.add(num);
        if(pq.size() >k) pq.poll();
        return pq.peek();  // return the largest element
    }

    public static void main (String args[]){
        int[] nums ={4,5,8,2};
        KthLargest_Element_in_Stream test = new KthLargest_Element_in_Stream(3, nums);

        System.out.println(test.add(3));   // returns 4
        System.out.println(test.add(5));   // returns 5
        System.out.println(test.add(10));  // returns 5
        System.out.println(test.add(9));   // returns 8
    }
}