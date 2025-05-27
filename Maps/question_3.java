// First non repeating character

// Given a string, find the first character that does not repeat

import java.util.*;

public class question_3{
	public static char test(String str){
		Map<Character,Integer> map = new LinkedHashMap<>();

		for(char c : str.toCharArray()) map.put(c,map.getOrDefault(c,0)+1);
		
		// iterate in insertion order and find the first with count = 1
		for(Map.Entry<Character,Integer> entry : map.entrySet()){
			if(entry.getValue() == 1) return entry.getKey();
		}
		return 0;
	}	

	public static void main(String args[]){
		String str = "! Hello world";
		System.out.println(test(str));
	}	
}