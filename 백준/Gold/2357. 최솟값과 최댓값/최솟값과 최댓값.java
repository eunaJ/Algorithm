import java.util.*;
import java.io.*;

class Main {
    public static int[] minTree, maxTree, arr;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = br.readLine().split(" ");
        int n = Integer.parseInt(sa[0]);
        int m = Integer.parseInt(sa[1]);
        arr = new int[n];
        minTree = new int[4*n];
        maxTree = new int[4*n];
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        initTree(0, n-1, 1, true);
        initTree(0, n-1, 1, false);
        for(int i=0; i<m; i++){
            sa = br.readLine().split(" ");
            int a = Integer.parseInt(sa[0]);
            int b = Integer.parseInt(sa[1]);
            sb.append(findMin(0, n-1, 1, a-1, b-1) + " ").append(findMax(0, n-1, 1, a-1, b-1) + "\n");
        }
        System.out.println(sb);
    }

    public static int initTree(int s, int e, int idx, boolean isMin){
        if(s == e){
            if(isMin) minTree[idx] = arr[s];
            else maxTree[idx] = arr[s];
            return arr[s];
        }
        int mid = (s+e)/2;
        if(isMin) minTree[idx] = Math.min(initTree(s, mid, 2*idx, isMin), initTree(mid+1, e, 2*idx+1, isMin));
        else maxTree[idx] = Math.max(initTree(s, mid, 2*idx, isMin), initTree(mid+1, e, 2*idx+1, isMin));
        return isMin ? minTree[idx] : maxTree[idx];
    }
    
    public static int findMin(int s, int e, int idx, int l, int r){
        if(l > e || r < s) return 1000000001;
        if(l <= s && r >= e) return minTree[idx];
        int mid = (s+e)/2;
        return Math.min(findMin(s, mid, 2*idx, l, r), findMin(mid+1, e, 2*idx+1, l, r));
    }

    public static int findMax(int s, int e, int idx, int l, int r){
        if(l > e || r < s) return 0;
        if(l <= s && r >= e) return maxTree[idx];
        int mid = (s+e)/2;
        return Math.max(findMax(s, mid, 2*idx, l, r), findMax(mid+1, e, 2*idx+1, l, r));
    }
}

// 세그먼트 트리