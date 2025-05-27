import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class EvenNOdd {
        public static void main(String[] args) {
            LinkedList<Integer> list = new LinkedList<>(List.of(1,2,3,4,5,6));
            LinkedList<Integer> even = new LinkedList<>();
            LinkedList<Integer> odd = new LinkedList<>();
            
            for(int i : list){
                if(i%2==0) even.add(i);
                else odd.add(i);
            }
            Collections.sort(even); Collections.sort(odd);
            even.addAll(odd);
            for(int i : even) System.out.println(i);
    }
}
