class Solution {
    public int solution(int[][] triangle) {
        int answer = triangle[0][0];
        int[][] dp = new int[triangle.length][triangle.length];
        dp[0][0] = triangle[0][0];
        // 맨 왼쪽 저장
        for(int i=1; i<triangle.length; i++){
            dp[i][0] = dp[i-1][0] + triangle[i][0];
        }
        for(int i=1; i<triangle.length; i++){
            for(int j=1; j<triangle[i].length; j++){
                // 왼쪽 위, 오른쪽 위 중 최대 저장
                dp[i][j] = Math.max(dp[i-1][j-1] + triangle[i][j], dp[i-1][j] + triangle[i][j]);
            }
        }
        // 맨 아래 중 가장 큰 값
        for(int i=0; i<triangle.length; i++)
            answer = Math.max(dp[triangle.length-1][i], answer);
        return answer;
    }
}