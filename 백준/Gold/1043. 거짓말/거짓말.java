import java.util.*;
import java.io.*;

class Main {
    public static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = br.readLine().split(" ");
        int n = Integer.parseInt(sa[0]);
        int m = Integer.parseInt(sa[1]);
        boolean[] knownPeoples = new boolean[n+1];
        HashSet<Integer>[] parties = new HashSet[m+1];
        for(int i=1; i<=m; i++){
            parties[i] = new HashSet<>();
        }
        sa = br.readLine().split(" ");
        int kp = Integer.parseInt(sa[0]);
        for(int i=1; i<=kp; i++){
            int num = Integer.parseInt(sa[i]);
            knownPeoples[num] = true; // 진실 알면 true
        }
        parent = new int[n+1];
        for(int i=1; i<=n; i++){
            parent[i] = i;
        }
        for(int i=1; i<=m; i++){
            sa = br.readLine().split(" ");
            int pn = Integer.parseInt(sa[0]);
            if(pn <= 1){
                parties[i].add(Integer.parseInt(sa[1]));
                continue;
            }
            for(int j=1; j<pn; j++){
                int a = Integer.parseInt(sa[j]);
                int b = Integer.parseInt(sa[j+1]);
                if(find(a) != find(b)) union(a, b);
                parties[i].add(a);
                parties[i].add(b);
            }
        }
        // 진실을 아는 사람과 union -> 진실 아는 사람(=true)으로 변경
        boolean[] visit = new boolean[n+1];
        for(int i=1; i<=n; i++){
            if(knownPeoples[i] && !visit[i]){
                int root = find(i);
                for(int j=1; j<=n; j++){
                    if(find(j) == root){
                        knownPeoples[j] = true;
                        visit[j] = true;
                    }
                }
            }
        }
        // 모든 참여자가 fasle여야 과장 가능
        int answer = 0;
        for(int i=1; i<=m; i++){
            boolean b = false;
            for(int p : parties[i]){
                if(knownPeoples[p]){
                    b = true;
                    break;
                }
            }
            if(!b) answer++;
        }
        System.out.println(answer);
    }

    public static int find(int idx){
        if(parent[idx] == idx) return idx;
        parent[idx] = find(parent[idx]);
        return parent[idx];
    }

    public static void union(int a, int b){
        int p = find(b);
        parent[p] = a; // b의 부모를 a로 변경
    }
}

// graph, union, find