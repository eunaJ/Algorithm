import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = br.readLine().split(" ");
        int n = Integer.parseInt(sa[0]);
        int k = Integer.parseInt(sa[1]);
        int[] weights = new int[n+1];
        int[] values = new int[n+1];
        for(int i=1; i<=n; i++){
            sa = br.readLine().split(" ");
            weights[i] = Integer.parseInt(sa[0]);
            values[i] = Integer.parseInt(sa[1]);
        }
        int[][] dp = new int[n+1][k+1];
        for(int i=1; i<=n; i++) {
            for(int w=0; w<=k; w++) {
                if(weights[i] <= w){
                    dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - weights[i]] + values[i]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }
        System.out.println(dp[n][k]);
    }
}