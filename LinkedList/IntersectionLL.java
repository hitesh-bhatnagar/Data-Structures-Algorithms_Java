
import java.util.*;


public class IntersectionLL {
    public static void intersectionLL(LinkedList<Integer> list1,LinkedList<Integer> list2){
        Set<Integer> common = new HashSet<>(list1);
        for(int i : list2) if(common.contains(i)) System.out.print(i +" ");
        System.out.println();
    }

    public static void Otherway(LinkedList<Integer> list1,LinkedList<Integer> list2){
        LinkedList<Integer> intersection_list = new LinkedList<>(list1);
        intersection_list.retainAll(list2); // keep only elements present in list2 ;
        for(int i : intersection_list) System.out.print(i+" ");
        
    }

    public static void main(String[] args) {
        LinkedList<Integer> list1 = new LinkedList<>(List.of(1,5,8,3,6,2));
        LinkedList<Integer> list2 = new LinkedList<>(List.of(7,3,5,1,8));
        intersectionLL(list1,list2);
        Otherway(list1,list2);
    }
}
