import java.util.*;
import java.io.*;

class Main {
    static int n, answer1, answer2;
    static char[][] map;
    static boolean[][] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new char[n][n];
        visited = new boolean[n][n];
        for(int i=0; i<n; i++){
            String s = br.readLine();
            for(int j=0; j<n; j++){
                map[i][j] = s.charAt(j);
            }
        }
        answer1 = 0;
        answer2 = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(!visited[i][j]){
                    dfs(i, j);
                    answer1++;
                }
            }
        }
        visited = new boolean[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(map[i][j] == 'R'){
                    map[i][j] = 'G';
                }
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(!visited[i][j]){
                    dfs(i, j);
                    answer2++;
                }
            }
        }
        System.out.println(answer1 + " " + answer2);
    }

    public static void dfs(int y, int x){
        visited[y][x] = true;
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[ny][nx] && map[y][x] == map[ny][nx]){
                dfs(ny, nx);
            }
        }
    }
}