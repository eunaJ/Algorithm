import java.util.*;
import java.io.*;

class Main {
    public static long[] tree;
    public static int mod = 1000000007;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = br.readLine().split(" ");
        int n = Integer.parseInt(sa[0]);
        int m = Integer.parseInt(sa[1]);
        int k = Integer.parseInt(sa[2]);
        int kk = 0;
        while(Math.pow(2, kk) < n){
            kk++;
        }
        int sIdx = (int) Math.pow(2, kk);
        tree = new long[2*sIdx];
        Arrays.fill(tree, 1);
        for(int i=sIdx; i<sIdx+n; i++){
            tree[i] = Long.parseLong(br.readLine());
        }
        for(int i=sIdx-1; i>0; i--){
            tree[i] = (tree[2*i]*tree[2*i+1]) % mod;
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<m+k; i++){
            sa = br.readLine().split(" ");
            int a = Integer.parseInt(sa[0]);
            int b = Integer.parseInt(sa[1]) + sIdx - 1;
            int c = Integer.parseInt(sa[2]);
            if(a == 1){
                changeValue(b, c);
            } else if(a == 2){
                c += sIdx-1;
                sb.append(multiply(b, c) + "\n");
            }
        }
        System.out.println(sb);
    }

    public static void changeValue(int idx, int v){
        tree[idx] = v;
        idx /= 2;
        while(idx > 0){
            tree[idx] = (tree[2*idx]*tree[2*idx+1]) % mod;
            idx /= 2;
        }
    }

    public static long multiply(int s, int e){
        long v = 1;
        while(s <= e){
            if(s % 2 == 1) v = (v*tree[s]) % mod;
            if(e % 2 == 0) v = (v*tree[e]) % mod;
            s = (s+1) / 2;
            e = (e-1) / 2;
        }
        return v;
    }
}

// 세그먼트 트리