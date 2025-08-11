import java.util.*;
public class binarySearch{
    public static int search(int[] arr, int target){
        int left = 0, right = arr.length - 1;
        while( left <= right){
            int mid = (right - left)/2 + left;
            if(arr[mid] == target) return mid;
            else if(arr[mid] < target) left = mid +1;
            else right = mid - 1;

        }
        return -1;
    }

    public static void main(String args[]){
        int[] arr = {}; int target = 5;
        Arrays.sort(arr);
    }
}