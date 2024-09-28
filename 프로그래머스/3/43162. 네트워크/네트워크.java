class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        for(int i=0; i<n; i++){
            // 방문하지 않았으면 새로운 네트워크
            if(!visited[i]) {
                dfs(i, computers, visited);
                answer++;
            }
        }
        return answer;
    }
    
    public void dfs(int node, int[][] computers, boolean[] visited){
        visited[node] = true;
        // 방문X, 자기X, 연결된 노드 찾
        for(int i=0; i<computers.length; i++){
            if(!visited[i] && i != node && computers[node][i] == 1){
                dfs(i, computers, visited);
            }
        }
    }
}