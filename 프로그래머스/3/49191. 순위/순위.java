class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        // 플로이드 와샬 알고리즘
        int[][] result = new int[n+1][n+1];
        for(int[] r : results){
            result[r[0]][r[1]] = 1; // 승리
            result[r[1]][r[0]] = -1; // 패배
        }
        // 승패 관계 계산
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                for(int k=1; k<=n; k++){
                    if(result[j][i]==1 && result[i][k]==1){ // i가 j에게 지고, k에게 이김
                        result[j][k] = 1;
                        result[k][j] = -1; // k가 j에게 패배
                    }
                }
            }
        }
        // 승패 결정 확인
        for(int i=1; i<=n; i++){
            int c = 0;
            for(int j=1; j<=n; j++){
                if(result[i][j] != 0) c++;
            }
            // 모든 선수와 승패 결정
            if(c == n-1) answer++;
        }
        return answer;
    }
}