import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<t; i++){
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[2][n+1];
            int[][] dp = new int[2][n+1];
            for(int j=0; j<2; j++){
                String[] sa = br.readLine().split(" ");
                for(int k=1; k<=n; k++){
                    arr[j][k] = Integer.parseInt(sa[k-1]);
                }
            }
            dp[0][1] = arr[0][1];
            dp[1][1] = arr[1][1];
            for(int j=2; j<=n; j++){
                dp[0][j] = Math.max(dp[1][j-1], dp[1][j-2]) + arr[0][j];
                dp[1][j] = Math.max(dp[0][j-1], dp[0][j-2]) + arr[1][j];
            }
            sb.append(Math.max(dp[0][n], dp[1][n]) + "\n");
        }
        System.out.println(sb);
    }
}