import java.util.*;
import java.io.*;

class Main {
    static int answer, n;
    static int[][] map;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n+1][n+1];
        for(int i=1; i<=n; i++){
            String[] sa = br.readLine().split(" ");
            for(int j=1; j<=n; j++){
                map[i][j] = Integer.parseInt(sa[j-1]);
            }
        }
        dfs(1, 2, 0);
        System.out.println(answer);
    }

    public static void dfs(int r, int c, int d){ // d 가로 세로 대각선
        if(r > n || c > n || map[r][c] == 1) return;
        if(d == 2){
            if(map[r-1][c] == 1 || map[r][c-1] == 1) return;
        }
        if(r == n && c == n){
            answer++;
            return;
        }
        if(d == 0){
            dfs(r, c+1, 0);
            dfs(r+1, c+1, 2);
        } else if(d == 1){
            dfs(r+1, c, 1);
            dfs(r+1, c+1, 2);
        } else {
            dfs(r+1, c+1, 2);
            dfs(r, c+1, 0);
            dfs(r+1, c, 1);
        }
    }
}