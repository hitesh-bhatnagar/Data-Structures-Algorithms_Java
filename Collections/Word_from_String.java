import java.util.*;
public class Word_from_String {
    public void method_1(String txt, String target){
        String[] words = txt.toLowerCase().split("[\\s.,]+");
        Map<String,Integer> map = new HashMap<>();

        for(String i : words) map.put(i,map.getOrDefault(i,0)+1);

        // print word freq
        for(Map.Entry<String,Integer> entry : map.entrySet()){
            System.out.println(entry.getKey()+" : "+entry.getValue());
        }
    }

    public static void method_2(String txt, String target){
        String[] words = txt.split("[\\s.,]+");

        // Count all words
        System.out.println("total words "+ words.length);

        // print all words
        for(String i : words) System.out.println(i+" ");
        System.out.println();

        // count occurencies of a specific word
        int count = 0;
        for(String i : words) if(i.equalsIgnoreCase(target)) count++;
        System.out.println("target count is : "+ count);
    }
    public static void main(String args[]){
        String txt = "thiis is a sample text. This text is an example sample.";
        String target = "text";
        Word_from_String obj = new Word_from_String();
        obj.method_1(txt, target);
        method_2(txt, target);
    }
}