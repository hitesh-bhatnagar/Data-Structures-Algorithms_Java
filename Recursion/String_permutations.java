import java.util.*;

public class String_permutations{
    public static List<List<String>> string_permute(String str){
        List<List<String>> result = new ArrayList<>();
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        boolean[] used = new boolean[arr.length];
        backtrack(new ArrayList<>(), used, arr, result);
        return result;
    }

    public static void backtrack(List<String> path, boolean[] used, char[] arr, List<List<String>> result ){
        if(path.size() == arr.length){
            result.add(new ArrayList<>(path));
            return;
        }

        for(int i = 0; i<arr.length;i++){
            if(used[i]) continue;
            if(i > 0 && arr[i] == arr[i-1] && !used[i-1]) continue;
            
            used[i] = true;
            path.add(arr[i]);
            backtrack(path, used, arr, result );
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }
}