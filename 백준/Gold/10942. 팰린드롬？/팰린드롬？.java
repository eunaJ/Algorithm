import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] sa = br.readLine().split(" ");
        int[] arr = new int[n+1];
        for(int i=1; i<=n; i++){
            arr[i] = Integer.parseInt(sa[i-1]);
        }
        int[][] dp = new int[n+1][n+1];
        for(int i=1; i<=n; i++){
            dp[i][i] = 1;
            if(i != n && arr[i] == arr[i+1]) dp[i][i+1] = 1;
        }
        for(int i=2; i<n; i++){
            for(int j=1; j<=n-i; j++){
                if(arr[j]==arr[j+i] && dp[j+1][j+i-1] == 1) dp[j][j+i] = 1;
            }
        }
        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<m; i++){
            sa = br.readLine().split(" ");
            int s = Integer.parseInt(sa[0]);
            int e = Integer.parseInt(sa[1]);
            sb.append(dp[s][e]).append('\n');
        }
        System.out.println(sb);
    }
}

// dp