// Top k - frequent element

import java.util.*;
import java.util.stream.Collectors;

public class question_2{
    public static List<Integer> topfreq(int[] arr,int k){
        // count element freq
        Map<Integer,Integer> freqMap = new HashMap<>();
        for(int i : arr) freqMap.put(i,freqMap.getOrDefault(i, 0)+1);

        // Sort the entries by frequenct (decending order) using steams
        return freqMap.entrySet().stream()
            .sorted(Map.Entry.<Integer,Integer> comparingByValue().reversed())
            .limit(k)
            .map(Map.Entry::getKey)
            .collect(Collectors.toList());
    } 

    public static void main(String args[]){
        int[] arr = {1,1,1,3,3,3,3,3,4,4,4,4,4,4};
        int k = 2;
        List<Integer> topK = topfreq(arr, k);
        System.out.println(topK);
    }
}