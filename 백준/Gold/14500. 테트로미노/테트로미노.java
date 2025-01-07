import java.util.*;
import java.io.*;

class Main {
    public static int n, m, answer;
    public static int[][] arr;
    public static int[] dy = {1, -1, 0, 0};
    public static int[] dx = {0, 0, -1, 1};
    public static boolean[][] visit;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = br.readLine().split(" ");
        n = Integer.parseInt(sa[0]);
        m = Integer.parseInt(sa[1]);
        arr = new int[n][m];
        visit = new boolean[n][m];
        for(int i=0; i<n; i++){
            sa = br.readLine().split(" ");
            for(int j=0; j<m; j++){
                arr[i][j] = Integer.parseInt(sa[j]);
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                visit[i][j] = true;
                backTracking(i, j, 1, arr[i][j]);
                visit[i][j] = false;
            }
        }
        System.out.println(answer);
    }

    public static void backTracking(int r, int c, int d, int sum){
        if(d == 4){
            if(answer < sum) answer = sum;
            return;
        }
        for(int i=0; i<4; i++){
            int ny = r + dy[i];
            int nx = c + dx[i];
            if(ny >= 0 && ny < n && nx >= 0 && nx < m && !visit[ny][nx]){
                if(d == 2){ // ㅗ 만들 때
                    visit[ny][nx] = true;
                    backTracking(r, c, d+1, sum+arr[ny][nx]);
                    visit[ny][nx] = false;
                }
                visit[ny][nx] = true;
                backTracking(ny, nx, d+1, sum+arr[ny][nx]);
                visit[ny][nx] = false;
            }
        }
    }
}

// 모양 크게 중요X