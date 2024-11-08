import java.util.*;
import java.io.*;

class Main {
    static int[][] arr;
    static boolean[] visited;
    static int answer;
    static int c;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        c = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        arr = new int[c+1][c+1];
        visited = new boolean[c+1];
        for(int i=0; i<n; i++){
            String[] sa = br.readLine().split(" ");
            int x = Integer.parseInt(sa[0]);
            int y = Integer.parseInt(sa[1]);
            arr[x][y] = 1;
            arr[y][x] = 1;
        }
        answer = 0;
        dfs(1);
        System.out.println(answer);
    }

    static void dfs(int s){
        if(!visited[s]){
            visited[s] = true;
            for(int i=1; i<=c; i++){
                if(arr[s][i] == 1 && !visited[i]){
                    dfs(i);
                    answer++;
                }
            }
        }
    }
}