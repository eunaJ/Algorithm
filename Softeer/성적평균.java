import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = br.readLine().split(" ");
        int N = Integer.parseInt(sa[0]);
        int K = Integer.parseInt(sa[1]);
        String[] score = br.readLine().split(" ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] sum = new int[N+1];
        for(int i=1; i<=N; i++){
            sum[i] = sum[i-1] + Integer.parseInt(score[i-1]);
        }
        for(int i=0; i<K; i++){
            sa = br.readLine().split(" ");
            int l = Integer.parseInt(sa[0]);
            int r = Integer.parseInt(sa[1]);
            double rSum = sum[r] - sum[l-1];
            double answer = rSum / (r - l + 1);
            System.out.println(String.format("%.2f", Math.round(answer*100)/100.0));
        } 
    }
}

// O(N^2) 시간초과
