import java.util.*;
class Solution {
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int[][] map = new int[102][102]; // 경계선 위해
        // 사각형 좌표 2배 확장 -> 정밀도 위해
        for(int[] r : rectangle){
            int x1 = r[0] * 2;
            int y1 = r[1] * 2;
            int x2 = r[2] * 2;
            int y2 = r[3] * 2;
            // 사각형을 map에 표시
            for(int i=x1; i<=x2; i++){
                for(int j=y1; j<=y2; j++){
                    if(i==x1 || i==x2 || j==y1 || j==y2){
                        if(map[i][j] != 2) map[i][j] = 1; // 테두리
                    } else {
                        map[i][j] = 2; // 내부
                    }
                }
            }
        }
        return bfs(map, characterX*2, characterY*2, itemX*2, itemY*2);
    }
    
    public int bfs(int[][] map, int cx, int cy, int ix, int iy){
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[102][102];
        // 방향 이동 -> 상하좌우
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        q.offer(new int[]{cx, cy, 0});
        visited[cx][cy] = true;
        while(!q.isEmpty()){
            int[] c = q.poll();
            int x = c[0];
            int y = c[1];
            int d = c[2]; // 거리
            // 아이템 도달
            if(x==ix && y==iy) return d/2; // 2배 했었으니까
            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                // 범위 내, 경계선(1) 위, 방문X
                if(nx>=0 && ny>=0 && nx<102 && ny<102 && map[nx][ny]==1 && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny, d+1}); // x, y, 이동거리
                }
            }
        }
        return -1;
    }
}