import java.util.*;
import java.io.*;

class Main {
    static int n, m;
    static boolean[] visited;
    static int[] arr;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = br.readLine().split(" ");
        n = Integer.parseInt(sa[0]);
        m = Integer.parseInt(sa[1]);
        visited = new boolean[n+1];
        arr = new int[n+1];
        dfs(1, 0);
    }

    public static void dfs(int start, int depth){
        if(depth == m){
            for(int i=0; i<m; i++){
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
        for(int i=start; i<=n; i++){
            if(!visited[i]){
                visited[i] = true;
                arr[depth] = i;
                dfs(i+1, depth+1);
                visited[i] = false;
            }
        }
    }
}