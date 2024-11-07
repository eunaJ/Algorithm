import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = br.readLine().split(" ");
        int n = Integer.parseInt(sa[0]);
        int m = Integer.parseInt(sa[1]);
        int[] sum = new int[n];
        sa = br.readLine().split(" ");
        sum[0] = Integer.parseInt(sa[0]);
        for(int a=1; a<n; a++){
            sum[a] = sum[a-1] + Integer.parseInt(sa[a]);
        }
        for(int k=0; k<m; k++){
            sa = br.readLine().split(" ");
            int i = Integer.parseInt(sa[0]) - 2;
            int j = Integer.parseInt(sa[1]) - 1;
            int answer = i < 0 ? sum[j] : sum[j] - sum[i];
            System.out.println(answer);
        }
    }
}