import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = br.readLine().split(" ");
        int n = Integer.parseInt(sa[0]);
        int m = Integer.parseInt(sa[1]);
        int[][] dp = new int[n+1][n+1];
        for(int i=1; i<=n; i++){
            sa = br.readLine().split(" ");
            for(int j=1; j<=n; j++){
                dp[i][j] = dp[i][j-1] + dp[i-1][j] - dp[i-1][j-1] + Integer.parseInt(sa[j-1]);
            }
        }
        for(int i=0; i<m; i++){
            sa = br.readLine().split(" ");
            int x1 = Integer.parseInt(sa[0]);
            int y1 = Integer.parseInt(sa[1]);
            int x2 = Integer.parseInt(sa[2]);
            int y2 = Integer.parseInt(sa[3]);
            int answer = dp[x2][y2] - dp[x1-1][y2] - dp[x2][y1-1] + dp[x1-1][y1-1];
            System.out.println(answer);
        }
    }
}