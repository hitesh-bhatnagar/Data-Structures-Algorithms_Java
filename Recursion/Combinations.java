import java.util.*;

public class Combinations{
	public static List<List<Integer>> combine(int n, int k){
		List<List<Integer>> result = new ArrayList<>();
		backtrack(0,n,k, new ArrayList<>(), result);
		return result;
	}

	public static void backtrack(int index, int n, int k, List<Integer> path, List<List<Integer>> result){
		if(path.size() == k){
			result.add(new ArrayList<>(path));
			return;
		}

		for(int i = index; i < n;i++){
			path.add(i);
			backtrack(i+1, n, k, path, result);
			path.remove(path.size() - 1 );
		}
	}

}
