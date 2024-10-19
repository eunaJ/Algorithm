import java.util.*;
class Solution {
    public int[] solution(String[] maps) {
        ArrayList<Integer> d = new ArrayList<>();
         boolean[][] visited = new boolean[maps.length][maps[0].length()];
        // bfs for문
        for(int y=0; y<maps.length; y++){
            for(int x=0; x<maps[0].length(); x++){
                // 방문하지 않은 지점에서 BFS 실행
                if(!visited[y][x] && maps[y].charAt(x) != 'X') {
                    int sum = bfs(maps, x, y, visited);
                    d.add(sum); // sum을 리스트에 추가
                }
            }
        }
        if(d.isEmpty()) return new int[] {-1};
        // 정렬
        int[] answer = new int[d.size()];
        for(int i=0; i<d.size(); i++){
            answer[i] = d.get(i);
        }
        Arrays.sort(answer);
        return answer;
    }
    public int bfs(String[] maps, int sx, int sy, boolean[][] visited){
        int[] dx = {0, 0, -1, 1}; // 상하좌우
        int[] dy = {1, -1, 0, 0};
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sx, sy});
        visited[sy][sx] = true;
        int sum = 0; // 합산 위해
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            // 현재 위치가 숫자면 합산
            char c = maps[y].charAt(x);
            if (c != 'X') sum += c - '0';
            // 상하좌우 탐색
            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx >= 0 && nx < maps[0].length() && ny >= 0 && ny < maps.length && !visited[ny][nx] && maps[ny].charAt(nx) != 'X'){
                    visited[ny][nx] = true;
                    q.add(new int[] {nx, ny});
                }
            }
        }
        return sum;
    }
}