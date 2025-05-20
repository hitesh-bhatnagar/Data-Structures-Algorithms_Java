import java.util.*;

public class comb_sum_3{
	public static List<List<Integer>> combSum_3(int n , int k){
		List<List<Integer>> result = new ArrayList<>();
		backtrack(0,n,k,new ArrayList<>(), result);
		return;
	}

	public static void backtrack(int idx, int n, int k, List<Integer> path, List<List<Integer>> result ){
		if(path.size() == k && target == 0){
			result.add(new ArrayList<>(path));
			return;
		}

		for(int i = idx ; i < 9; i++){
			if(i > target) break;
			path.add(i);
			backtrack( i+1,n, k,path, result);
			path.remove(path.size() - 1);
		}
	}
}
