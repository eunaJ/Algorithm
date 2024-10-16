import java.util.*;
class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
        }
        // 그래프 초기화
        for(int[] e : edge){
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        boolean[] visited = new boolean[n+1];
        answer = bfs(graph, n, visited);
        return answer;
    }
    
    public int bfs(ArrayList<ArrayList<Integer>> graph, int n, boolean[] visited){
        int max = 1;
        int[] depth = new int[n+1];
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visited[1] = true;
        while(!q.isEmpty()){
            int x = q.poll();
            for(int next : graph.get(x)){
                if(!visited[next]){
                    visited[next] = true;
                    depth[next] = depth[x] + 1;
                    q.add(next);
                    // 가장 긴 경로 update
                    if(depth[next] > max) max = depth[next];
                }
            }
        }
        int c = 0;
        // 가장 멀리 떨어진 노드 개수 계산
        for(int i=1; i<=n; i++){
            if(depth[i] == max) c++;
        }
        return c;
    }
}