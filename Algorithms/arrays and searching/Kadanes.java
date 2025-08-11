// Kadane's Algo (variable size)
// Find maximum subarray sum for any size

public class Kadanes{
    public static int maxSubArray(int[] arr){
        int max = arr[0], curr = arr[0];

        for(int i = 0; i < arr.length; i++){
            curr = Math.max(arr[i], curr + arr[i]);
            max = Math.max(max, curr);
        }
        return max;
    }
    public static void main(String[] args) {
    }
}