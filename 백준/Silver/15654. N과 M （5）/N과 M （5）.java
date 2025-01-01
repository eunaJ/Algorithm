import java.util.*;
import java.io.*;

class Main {
    public static int n, m;
    public static int[] arr, printArr;
    public static boolean[] visit;
    public static StringBuilder sb;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = br.readLine().split(" ");
        n = Integer.parseInt(sa[0]);
        m = Integer.parseInt(sa[1]);
        sa = br.readLine().split(" ");
        arr = new int[n];
        printArr = new int[n];
        visit = new boolean[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(sa[i]);
        }
        Arrays.sort(arr);
        sb = new StringBuilder();
        dfs(0, 0);
        System.out.println(sb);
    }

    public static void dfs(int d, int s){
        if(d == m){
            for(int i=0; i<m; i++){
                sb.append(printArr[i] + " ");
            }
            sb.append("\n");
            return;
        }
        for(int i=0; i<n; i++){
            if(!visit[i]){
                visit[i] = true;
                printArr[d] = arr[i];
                dfs(d+1, i+1);
                visit[i] = false;
            }
        }
    }
}