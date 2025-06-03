import java.util.*;
/* 
Given a string s (all unique characters), return all permutations of the string.

Example:
Input: "abc"
Output: ["abc", "acb", "bac", "bca", "cab", "cba"]
*/
public class String_permutation{
    public static List<String> permute(String s){
        List<String> result = new ArrayList<>();
        boolean[] used = new boolean[s.length()];
        backtrack(s, new StringBuilder(), used, result);
        return result;
    }

    private static void backtrack(String s, StringBuilder path, boolean[] used, List<String> result){
        if(path.length() == s.length()){
            result.add(path.toString());
            return;
        }

        for(int i = 0; i< s.length();i++){
            if(used[i] ) continue;

            used[i] = true;
            path.append(s.charAt(i));
            backtrack(s, path,used,result);
            path.deleteCharAt(path.length() - 1);
            used[i] = false;

        }
    }
}