import java.io.*;
import java.util.*;

public class Main {
    // LIS 알고리즘
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] sa = br.readLine().split(" ");
        int[] dp = new int[n];
        int answer = 1;
        for(int i=0; i<n; i++){
            dp[i] = 1;
            for(int j=0; j<i; j++){
                if(Integer.parseInt(sa[j]) < Integer.parseInt(sa[i])){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
                if(answer < dp[i]) answer = dp[i];
            }
        }
        System.out.print(answer);
    }
}
