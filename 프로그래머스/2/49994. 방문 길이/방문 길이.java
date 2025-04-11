class Solution {
    public int solution(String dirs) {
        int answer = 0;
        boolean[][][] visit = new boolean[11][11][4];
        int y = 5;
        int x = 5;
        int d = 0;
        int[] dy = {1, 0, -1, 0};
        int[] dx = {0, 1, 0, -1};
        for(char c : dirs.toCharArray()){
            if(c == 'U') d = 0;
            else if(c == 'R') d = 1;
            else if(c == 'D') d = 2;
            else if(c == 'L') d = 3;
            int ny = y + dy[d];
            int nx = x + dx[d];
            if(ny < 0 || ny >= 11 || nx < 0 || nx >= 11) continue;
            if(!visit[ny][nx][d]){
                visit[ny][nx][d] = true;
                visit[y][x][(d+2)%4] = true; // 반대 방향
                answer++;
            }
            y = ny;
            x = nx;
        }
        return answer;
    }
}

// visit은 3차원