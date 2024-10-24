import java.util.*;
class Solution {
    public int solution(String[] maps) {
        // 시작, 레버 위치 찾기
        int[] s = {0, 0};
        int[] l = {0, 0};
        for(int i=0; i<maps.length; i++){           
            if(maps[i].contains("S")){
                s[0] = i;
                s[1] = maps[i].indexOf("S");
            }
            if(maps[i].contains("L")){
                l[0] = i;
                l[1] = maps[i].indexOf("L");
            }
        }
        // 탈출 불가 return
        int answer1 = bfs(maps, s, 'L');
        if(answer1 == -1) return -1;
        int answer2 = bfs(maps, l, 'E');
        if(answer2 == -1) return -1;
        return answer1 + answer2;
    }
    
    public int bfs(String[] maps, int[] st, char p){
        boolean[][] visited = new boolean[maps.length][maps[0].length()];
        visited[st[0]][st[1]] = true;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {st[0], st[1], 0}); // y, x, 거리
        int[] dx = {0, 0, -1, 1}; // 상하좌우
        int[] dy = {1, -1, 0, 0};
        while(!q.isEmpty()){
            int[] c = q.poll();
            int x = c[1];
            int y = c[0];
            if(maps[y].charAt(x) == p) return c[2];
            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                // 조건 충족 + 벽이 아니면
                if(nx >= 0 && nx < maps[0].length() && ny >= 0 && ny < maps.length && !visited[ny][nx] && maps[ny].charAt(nx) != 'X'){    
                    visited[ny][nx] = true;
                    q.add(new int[] {ny, nx, c[2]+1});    
                }                
            }    
        }       
        return -1;
    }
}