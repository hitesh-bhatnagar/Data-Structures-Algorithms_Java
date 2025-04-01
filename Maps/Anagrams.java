// Group Anagrams

// given array of strings, group the anagrams together

import java.util.*;

public class Anagrams{
    public static List<List<String>> groupAnagrams(String[] str){
        if(str == null || str.length == 0) return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for(String s : str){
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String key = String.valueOf(c);
            if(!map.containsKey(key)) map.put(key, new ArrayList<>());
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String args[]){
        String[] str = {"eat", "tea", "tan", "ate", "nat", "bat"};
        //List<List<String>> result = Anagrams(str);
        System.out.println(groupAnagrams(str));
    }
}


// Method 2 by using Array List

