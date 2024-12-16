import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n][n];
        int[][] matrix = new int[n][n];
        for(int i=0; i<n; i++){
            String[] sa = br.readLine().split(" ");
            int r = Integer.parseInt(sa[0]);
            int c = Integer.parseInt(sa[1]);
            matrix[i][0] = r;
            matrix[i][1] = c;
        }
        for(int i=1; i<n; i++){
            for(int j=0; j+i<n; j++){
                dp[j][j+i] = Integer.MAX_VALUE;
                for(int k=j; k<j+i; k++){
                    dp[j][j+i] = Math.min(dp[j][j+i], dp[j][k]+dp[k+1][j+i]+matrix[j][0]*matrix[k][1]*matrix[j+i][1]); 
                }
            }
        }
        System.out.println(dp[0][n-1]);
    }
}