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
        printArr = new int[m];
        visit = new boolean[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(sa[i]);
        }
        Arrays.sort(arr);
        sb = new StringBuilder();
        dfs(0);
        System.out.println(sb);
    }

    public static void dfs(int d){
        if(d == m){
            for(int v : printArr){
                sb.append(v + " ");
            }
            sb.append("\n");
            return;
        }
        int before = 0;
        for(int i=0; i<n; i++){
            if(!visit[i]){
                if(before == arr[i]) continue;
                visit[i] = true;
                before = arr[i];
                printArr[d] = arr[i];
                dfs(d+1);
                visit[i] = false;
            }
        }
    }
}

// 중복되는 수열은 안 됨 (before로 확인)