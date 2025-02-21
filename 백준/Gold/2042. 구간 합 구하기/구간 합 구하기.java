import java.util.*;
import java.io.*;

class Main {
    public static long[] arr, tree;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = br.readLine().split(" ");
        int n = Integer.parseInt(sa[0]);
        int m = Integer.parseInt(sa[1]);
        int k = Integer.parseInt(sa[2]);
        StringBuilder sb = new StringBuilder();
        arr = new long[n];
        tree = new long[4*n];
        for(int i=0; i<n; i++){
            arr[i] = Long.parseLong(br.readLine());
        }
        init(0, arr.length-1, 1);
        for(int i=0; i<m+k; i++){
            sa = br.readLine().split(" ");
            int a = Integer.parseInt(sa[0]);
            int b = Integer.parseInt(sa[1]);
            long c = Long.parseLong(sa[2]);
            if(a == 1){
                long diff = c - arr[b-1];
                update(0, arr.length-1, 1, b-1, diff);
            }
            else if(a == 2) sb.append(sum(0, arr.length-1, 1, b-1, c-1) + "\n");
        }
        System.out.println(sb);
    }

    public static long init(int s, int e, int node){
        if(s == e) return tree[node] = arr[s];
        else {
            int mid = (s+e)/2;
            return tree[node] = init(s, mid, 2*node) + init(mid+1, e, 2*node+1);
        }
    }

    public static long sum(int s, int e, int node, int l, long r){
        if(l > e || r < s) return 0; // 범위 밖
        if(l <= s && e <= r) return tree[node];
        int mid = (s+e)/2;
        return sum(s, mid, 2*node, l, r) + sum(mid+1, e, 2*node+1, l, r);
    }

    public static void update(int s, int e, int node, int idx, long diff){
        if(idx < s || idx > e) return;
        tree[node] += diff;
        if(s == e){
            arr[idx] = tree[node];
            return;
        }
        int mid = (s+e)/2;
        update(s, mid, 2*node, idx, diff);
        update(mid+1, e, 2*node+1, idx, diff);
    }
}

// 세그먼트 트리