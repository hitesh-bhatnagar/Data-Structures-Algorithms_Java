import java.util.*;
import java.util.stream.*;

public class comb_sum_2{
	public static List<List<Integer>> comb_sum2(int[] nums, int target){
		Arrays.sort(nums);

		List<List<Integer>> result = new ArrayList<>();
		backtrack(0, nums,target, new ArrayList<>(), result);
		return result;
			
	}

	public static void backtrack(int idx, int[] nums, int target, List<Integer> path, List<List<Integer>> result){
		if(target == 0){
			result.add(new ArrayList<>(path));
			return;
		}

		for(int i = idx;i<nums.length;i++){

			if(nums[i] > target) break;
			if(i > idx && nums[i] == nums[i-1]) continue;

			path.add(nums[i]);
			backtrack(i+1, nums, target - nums[i], path, result );
			path.remove(path.size() - 1);
		}
	}
}
