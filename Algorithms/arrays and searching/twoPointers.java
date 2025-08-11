// Two Pointers (Pair sum)
// Find if a sorted array has two nums that sum to target

public class twoPointers{
    public static boolean pairSum(int[] nums, int target){
        int left = 0, right = nums.length - 1;
        while(left < right){
            int sum = nums[left] + nums[right];
            if(sum == target) return true;
            else if(sum < target) left++;
            else right--;
        }
        return false;
    }
    public static void main(String[] args){
    }
}