import java.util.*;
public class Question_1{
    public static void countChar(String str){
        Map<Character,Integer> map = new HashMap<>();

        for(char c: str.toCharArray()) map.put(c,map.getOrDefault(c, 0)+1);

        map.forEach((character, frequency) -> 
    System.out.println("Character: " + character + ", Frequency: " + frequency));
    }

    public static void main(String[] args) {
        String str = "hello  world";
        countChar(str);
    }
}