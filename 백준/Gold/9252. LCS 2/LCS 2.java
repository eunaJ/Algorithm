import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s1 = br.readLine().split("");
        String[] s2 = br.readLine().split("");
        int[][] dp = new int[s1.length+1][s2.length+1];
        for(int i=1; i<=s1.length; i++){
            for(int j=1; j<=s2.length; j++){
                if(s1[i-1].equals(s2[j-1])) dp[i][j] = dp[i-1][j-1]+1;
                else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        int n = dp[s1.length][s2.length];
        System.out.println(n);
        if(n == 0) return;
        StringBuilder sb = new StringBuilder();
        int idx1 = s1.length, idx2 = s2.length;
        while(idx1 > 0 && idx2 > 0){
            if(s1[idx1-1].equals(s2[idx2-1])){
                sb.append(s1[idx1-1]);
                idx1--;
                idx2--;
            }
            else if(dp[idx1-1][idx2] >= dp[idx1][idx2-1]) idx1--;
            else idx2--;
        }
        System.out.println(sb.reverse());
    }
}