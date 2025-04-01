import java.util.*;

class reverse_K_grp{
    public  int test(LinkedList<Integer> list,int k){
            int n = list.size();
            if(k>n || k<0) return 0;
            for(int i =0;i+k <= n; i+=k){
                Collections.reverse(list.subList(i,i+k));
            }
            for(int i : list) System.out.print(i+" ");
            return 0;
        }
    }
    
    public class ReverseLL {
    
    
        public static void main(String[] args) {
            reverse_K_grp rev = new reverse_K_grp();
            LinkedList<Integer> list = new LinkedList<>(List.of(7,1,9,3,8,4));
            Collections.sort(list,Collections.reverseOrder());
            System.out.println(list);
            System.out.println("List with reverse K group");
            rev.test(list,3);

    }
}
