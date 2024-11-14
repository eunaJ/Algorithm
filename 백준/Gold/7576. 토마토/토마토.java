import java.util.*;
import java.io.*;

class Main {
    static int m, n, answer;
    static int[][] g;
    static Queue<int[]> q;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = br.readLine().split(" ");
        m = Integer.parseInt(sa[0]);
        n = Integer.parseInt(sa[1]);
        g = new int[n][m];
        q = new LinkedList<>();
        answer = 0;
        for(int i=0; i<n; i++){
            sa = br.readLine().split(" ");
            for(int j=0; j<m; j++){
                g[i][j] = Integer.parseInt(sa[j]);
                if(g[i][j] == 1) q.add(new int[]{i, j});
            }
        }
        System.out.println(bfs());
    }

    public static int bfs(){
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};
        while(!q.isEmpty()){
            int[] cur = q.poll();
            for(int i=0; i<4; i++){
                int nx = cur[1] + dx[i];
                int ny = cur[0] + dy[i];
                if(nx >= 0 && nx < m && ny >= 0 && ny < n && g[ny][nx] == 0) {
                    q.add(new int[] {ny, nx});
                    g[ny][nx] = g[cur[0]][cur[1]] + 1;
                    answer = Math.max(answer, g[ny][nx]);
                }
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(g[i][j] == 0) {
                    return -1;
                }
            }
        }
        return answer == 0 ? 0 : answer - 1;
    }
}