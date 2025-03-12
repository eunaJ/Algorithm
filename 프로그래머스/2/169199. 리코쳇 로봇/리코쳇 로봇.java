import java.util.*;

class Solution {    
    public int solution(String[] board) {
        int[] start = new int[2];
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length(); j++){
                if(board[i].charAt(j) == 'R') start = new int[]{i, j};
            }
        }
        return bfs(board, start);
    }
    
    public int bfs(String[] board, int[] start){
        int result = -1;
        int[][] visit = new int[board.length][board[0].length()];
        Queue<int[]> q = new LinkedList<>();
        q.add(start);
        visit[start[0]][start[1]] = 1;
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};
        while(!q.isEmpty()){
            int[] cur = q.poll();
            if(board[cur[0]].charAt(cur[1]) == 'G'){
                result = visit[cur[0]][cur[1]] - 1;
                break;
            }
            for(int i=0; i<4; i++){
                int ny = cur[0] + dy[i];
                int nx = cur[1] + dx[i];
                while(true){
                    if(ny >= 0 && ny < board.length && nx >= 0 && nx < board[0].length() && board[ny].charAt(nx) != 'D'){
                        ny += dy[i];
                        nx += dx[i];
                    } else {
                        ny -= dy[i];
                        nx -= dx[i];
                        break;
                    }
                }
                if(visit[ny][nx] == 0){
                    q.add(new int[]{ny, nx});
                    visit[ny][nx] = visit[cur[0]][cur[1]] + 1;
                }
            }
        }
        return result;
    }
}