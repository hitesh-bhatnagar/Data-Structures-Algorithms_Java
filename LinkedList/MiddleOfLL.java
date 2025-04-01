import java.util.*;

public class MiddleOfLL {
    public static int middle(LinkedList<Integer> list){
        return list.get(list.size()/2);
    }
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>(List.of(3,2,5,6,7));
        System.out.println(middle(list));
    }
}
