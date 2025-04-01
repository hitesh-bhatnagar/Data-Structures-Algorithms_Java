import java.util.*;
public class RemoveNode {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>(List.of(3,5,1,6));
        int size = list.size();
        System.out.println(size);
        int n = 3;
        list.remove(size-n);
        System.out.println(list);

    }

}
