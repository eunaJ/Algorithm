import java.lang.Math;
class Solution {
    boolean[] visited = {};
    int answer;
    public int solution(int k, int[][] dungeons) {
        answer = 0;
        visited = new boolean[dungeons.length];
        dfs(0, k, dungeons);
        return answer;
    }
    
    public void dfs(int n, int kk, int[][] dg){
        for(int i=0; i<dg.length; i++){
            if(visited[i] || dg[i][0] > kk) continue;
            visited[i] = true;
            dfs(n + 1, kk - dg[i][1], dg);
            visited[i] = false;
        }
        answer = Math.max(answer, n); 
    }
}