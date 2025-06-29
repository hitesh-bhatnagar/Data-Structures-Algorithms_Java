// you are climbing a staircase. It takes n steps to reach the top.
// Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
// Input: 2
// Output: 2
// Explanation: There are two ways to climb to the top.
// 1. 1 step + 1 step
// 2. 2 steps

import java.util.Map;

public class Climb_Stairs{

    //       Method - 1       Adding memorization
    public int climbstaris_Memo(int n , Map<Integer, Integer> memo){
        if(n == 0 || n== 1) return 1;
    
        if(memo.containsKey(n)) return memo.get(n);
        int result = climbstaris_Memo(n-1, memo) + climbstaris_Memo(n - 2, memo);
        memo.put(n,result);
        return result;
    }
    
    //      Method - 2      Botoom-Up DP (no recursion)
    
    public int climbstaris_DP(int n){
        if(n==0 || n== 1) return 1;
        int[] dp = new int[n+1];
        dp[0] = dp[1] = 1;

        for(int i = 2; i <= n; i++) dp[i] = dp[i-1] + dp[i-2];

        return dp[n];
    }

    //      BONUS           Optimize space and time both 
    public int optimize(int n){
        if(n == 0 || n ==1) return 1;

        int prev = 1, curr = 1;
        for(int i = 2; i <= n; i++){
            int temp = curr;
            curr += prev;
            prev = temp;
        }

        return curr;
    }

    public static void main(String args[]){
        
    }
}

