import java.util.*;

public class Tortoise_Hare{
    public static boolean hasCycle(List<Integer> list){
        Set<Integer> visited = new HashSet<>();
        for(Integer i : list){
            if(!visited.add(i)) return true;
        }
        return false;   // No cycle
    }

    public static void main(String[] args) {
        List<Integer> list = List.of(1,2,3,4,5,4);
        System.out.println(hasCycle(list)? "cycle detected" : "No cycle");
    }
}