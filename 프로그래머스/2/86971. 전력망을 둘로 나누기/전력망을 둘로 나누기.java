import java.util.*;
class Solution {
    public int solution(int n, int[][] wires) {
        int answer = n;
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<n+1; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] wire : wires){
            graph.get(wire[0]).add(wire[1]);
            graph.get(wire[1]).add(wire[0]);
        }
        for(int wire[] : wires){
            int sub = dfs(wire[0], wire[1], graph, new boolean[n+1]);
            answer = Math.min(answer, Math.abs(n - 2 * sub));
        }
        return answer;
    }
    public int dfs(int v1, int v2, List<List<Integer>> graph, boolean[] visited){
        visited[v1] = true;
        int c = 1;
        for(int neighbor : graph.get(v1)){
            if(neighbor != v2 && !visited[neighbor]){
                c += dfs(neighbor, v2, graph, visited);
            }
        }
        return c;
    }
}