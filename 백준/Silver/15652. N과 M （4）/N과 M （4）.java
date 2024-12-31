import java.util.*;
import java.io.*;

class Main {
    static int n, m;
    static boolean[] visit;
    static int[] arr;
    static StringBuilder sb;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = br.readLine().split(" ");
        n = Integer.parseInt(sa[0]);
        m = Integer.parseInt(sa[1]);
        sb = new StringBuilder();
        visit = new boolean[n+1];
        arr = new int[m];
        dfs(0, 0);
        System.out.println(sb);
    }

    public static void dfs(int d, int s){
        if(d == m){
            for(int v : arr){
                sb.append(v + " ");
            }
            sb.append("\n");
            return;
        }
        for(int i=s; i<n; i++){
            visit[i] = true;
            arr[d] = i + 1;
            dfs(d+1, i);
            visit[i] = false;
        }
    }
}