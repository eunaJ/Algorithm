import java.util.*;

class Solution {
    static int n, m;
    static int[] oil;
    
    public int solution(int[][] land) {
        int answer = 0;
        n = land.length;
        m = land[0].length;
        oil = new int[m];
        boolean[][] visit = new boolean[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(land[i][j] == 1 && !visit[i][j]){
                    bfs(land, visit, i, j);
                }
            }
        }
        for(int o : oil){
            answer = Math.max(answer, o);
            // answer = Arrays.stream(oil).max().getAsInt();
        }
        return answer;
    }
    
    public void bfs(int[][] land, boolean[][] visit, int y, int x){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{y, x});
        visit[y][x] = true;
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};
        int cnt = 1; // 석유 덩어리 개수
        Set<Integer> set = new HashSet<>(); // 석유 열 위치
        while(!q.isEmpty()){
            int[] cur = q.poll();
            set.add(cur[1]);
            for(int i=0; i<4; i++){
                int ny = cur[0] + dy[i];
                int nx = cur[1] + dx[i];
                if(ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
                if(land[ny][nx] == 1 && !visit[ny][nx]){
                    q.add(new int[]{ny, nx});
                    visit[ny][nx] = true;
                    cnt += 1;
                }
            }
        }
        for(int s : set){
            oil[s] += cnt;
        }
    }
}