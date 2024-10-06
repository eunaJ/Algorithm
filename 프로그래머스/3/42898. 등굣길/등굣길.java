class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int mod = 1000000007;
        int[][] path = new int[n+1][m+1];
        // 미리 물 지역 저장
        for (int[] puddle : puddles) {
            path[puddle[1]][puddle[0]] = -1; 
        }
        // 시작
        path[1][1] = 1;
        for(int i=1; i<n+1; i++){
            for(int j=1; j<m+1; j++){
                if(path[i][j] == -1) {
                    path[i][j] = 0;
                    continue;
                }
                // 위
                if (i > 1) {
                    path[i][j] += path[i-1][j];
                }
                // 왼쪽
                if (j > 1) {
                    path[i][j] += path[i][j-1];
                }                
                // 나머지 연산
                path[i][j] %= mod;
            }
        }
        return path[n][m];
    }
}