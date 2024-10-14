import java.util.*;
class Solution {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        // parent 노드 초기화
        int[] parent = new int[n];
        for(int i=0; i<n; i++){
            parent[i] = i;
        }
        // 가중치 기준 오름차순
        Arrays.sort(costs, (o1, o2)-> o1[2] - o2[2]);
        // 최소 신장 트리 - 크루스칼
        for(int i=0; i<costs.length; i++){
            if(find(parent, costs[i][0]) != find(parent, costs[i][1])){
                union(parent, costs[i][0], costs[i][1]);
                answer += costs[i][2];
            }
        }
        return answer;
    }
    // 크루스칼 - find
    public int find(int[] parent, int x){
        if(parent[x] == x) return x;
        else return find(parent, parent[x]);
    }
    // 크루스칼 - union
    public void union(int[] parent, int x, int y){
        x = find(parent, x);
        y = find(parent, y);
        if(x < y) parent[y] = x;
        else parent[x] = y;
    }
}