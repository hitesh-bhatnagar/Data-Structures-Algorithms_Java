import java.util.*;
public class combination_sum{
	public List<List<Integer>> combinationSum(int[] nums, int target){
		List<List<Integer>> result = new ArrayList<>();
		backtrack(nums, 0, target, new ArrayList<>() , result);
		return result;
	}

	public static void backtrack(int[] nums, int index, int target, List<Integer> path, List<List<Integer>> result){
		if(target == 0){
			result.add(new ArrayList<>(path));
			return;
		}

		for(int i = index;i<nums.length;i++){
			if(nums[i] > target) continue;

			path.add(nums[i]);
			backtrack(nums, i, target - nums[i], path, result);
			path.remove(path.size() - 1);
		}
	}
}
