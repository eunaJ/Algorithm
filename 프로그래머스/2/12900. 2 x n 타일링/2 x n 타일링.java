class Solution {
    static int[] dp;
    
    public int solution(int n) {
        dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        return tile(n);
    }
    
    public static int tile(int n){
        if(dp[n] == 0){
            dp[n] = (tile(n-1) + tile(n-2)) % 1000000007;
        }
        return dp[n];
    }
}

// dp