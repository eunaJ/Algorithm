import java.util.*;
import java.io.*;

class Main {
    static int v, e;
    static PriorityQueue<int[]> edges;
    static int[] parent, rank;

    static int find(int x){
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int x, int y){
        x = find(x);
        y = find(y);
        if(x == y) return;
        if(rank[x] < rank[y]) parent[x] = y;
        else {
            parent[y] = x;
            if(rank[x] == rank[y]) rank[x]++;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = br.readLine().split(" ");
        v = Integer.parseInt(sa[0]);
        e = Integer.parseInt(sa[1]);
        edges = new PriorityQueue<>((a, b)->Integer.compare(a[2], b[2]));
        parent = new int[v+1];
        rank = new int[v+1];
        for(int i=1; i<=v; i++){
            parent[i] = i;
        }
        for(int i=0; i<e; i++){
            sa = br.readLine().split(" ");
            int a = Integer.parseInt(sa[0]);
            int b = Integer.parseInt(sa[1]);
            int c = Integer.parseInt(sa[2]);
            edges.offer(new int[]{a, b, c});
        }
        int answer = 0;
        while(!edges.isEmpty()){
            int[] arr = edges.poll(); // from, to, weight
            if(find(arr[0]) != find(arr[1])){
                union(arr[0], arr[1]);
                answer += arr[2];
            }
        }
        System.out.println(answer);
    }
}

// 최소 스패닝 트리 -> 크루스칼, 프림