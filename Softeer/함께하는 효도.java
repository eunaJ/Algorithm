import java.io.*;
import java.util.*;

public class Main {
    static int answer, n, m;
    static int[][] fruit, friend;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = br.readLine().split(" ");
        n = Integer.parseInt(sa[0]);
        m = Integer.parseInt(sa[1]);
        fruit = new int[n+2][n+2];
        friend = new int[m][2];
        for(int i=1; i<=n; i++){
            sa = br.readLine().split(" ");
            for(int j=1; j<=n; j++){
                fruit[i][j] = Integer.parseInt(sa[j-1]);
            }
        }
        visited = new boolean[n+2][n+2];
        answer = 0;
        for(int i=1; i<=m; i++){
            sa = br.readLine().split(" ");
            int x = Integer.parseInt(sa[0]);
            int y = Integer.parseInt(sa[1]);
            friend[i-1] = new int[]{x, y};
            visited[x][y] = true;
            answer += fruit[x][y];
        }
        dfs(friend[0][0], friend[0][1], 0, 0, answer);
        System.out.println(answer);
    }

    public static void dfs(int x, int y, int fCnt, int t, int sum){
        answer = Math.max(answer, sum);
        if(t == 3){
            if(fCnt+1 < m){
                dfs(friend[fCnt+1][0], friend[fCnt+1][1], fCnt+1, 0, sum);
            }
        } else {
            int[] dy = {1, -1, 0, 0};
            int[] dx = {0, 0, -1, 1};
            int max = 0;
            for(int i=0; i<4; i++){
                int ny = y + dy[i];
                int nx = x + dx[i];
                if(nx > 0 && nx <= n && ny > 0 && ny <= n && !visited[nx][ny]) {
                    visited[nx][ny] = true; 
                    dfs(nx, ny, fCnt, t+1, sum+fruit[nx][ny]);
                    visited[nx][ny] = false;
                }
            }
        }
    }
}


// dfs 여러 번
