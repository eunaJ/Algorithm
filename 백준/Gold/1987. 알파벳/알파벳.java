import java.util.*;
import java.io.*;

class Main {
    static char[][] map;
    static boolean[] visited;
    static int r, c, answer;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = br.readLine().split(" ");
        r = Integer.parseInt(sa[0]);
        c = Integer.parseInt(sa[1]);
        map = new char[r][c];
        visited = new boolean[26];
        for(int i=0; i<r; i++){
            String s = br.readLine();
            for(int j=0; j<c; j++){
                map[i][j] = s.charAt(j);
            }
        }
        visited[map[0][0]-'A'] = true;
        dfs(1, 0, 0);
        System.out.println(answer);
    }

    public static void dfs(int cnt, int y, int x){
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};
        if(cnt == r*c){
            answer = Math.max(answer, cnt);
            return;
        }
        for(int i=0; i<4; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(nx >= 0 && nx < c && ny >= 0 && ny < r){
                char now = map[ny][nx];
                if(!visited[now-'A']){
                    visited[now-'A'] = true;
                    dfs(cnt+1, ny, nx);
                    visited[now-'A'] = false;
                } else {
                    answer = Math.max(answer, cnt);
                }
            }
        }
    }
}

// bfs 실패