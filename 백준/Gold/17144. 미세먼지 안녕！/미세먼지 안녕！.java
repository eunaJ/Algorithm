import java.util.*;
import java.io.*;

class Main {
    static int r, t, c;
    static int[][] map, temp;
    static int clean; // 위쪽 공기청정기의 위치
    static Queue<Air> dusts = new LinkedList<>();

    public static class Air {
        int y; 
        int x;
        int size;

        Air(int y, int x, int size){
            this.y = y;
            this.x = x;
            this.size = size;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = br.readLine().split(" ");
        r = Integer.parseInt(sa[0]);
        c = Integer.parseInt(sa[1]);
        t = Integer.parseInt(sa[2]);
        
        map = new int[r+1][c+1];
        clean = -1; // 청정기 위치 초기화
        
        for(int i=1; i<=r; i++){
            sa = br.readLine().split(" ");
            for(int j=1; j<=c; j++){
                map[i][j] = Integer.parseInt(sa[j-1]);
                if(map[i][j] == -1 && clean == -1) clean = i;
            }
        }

        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};

        while(t > 0){
            // 먼지 확산 
            temp = new int[r+1][c+1];
            for(int i=1; i<=r; i++){
                for(int j=1; j<=c; j++){
                    if(map[i][j] > 0){
                        int spreadAmount = map[i][j] / 5;
                        int spreadCount = 0;
                        for(int d=0; d<4; d++){
                            int nx = j + dx[d];
                            int ny = i + dy[d];
                            if(ny > 0 && ny <= r && nx > 0 && nx <= c && map[ny][nx] != -1){
                                temp[ny][nx] += spreadAmount;
                                spreadCount++;
                            }
                        }
                        map[i][j] -= spreadAmount * spreadCount;
                    }
                }
            }
            // 확산된 먼지 맵을 기존 맵에 반영
            for(int i=1; i<=r; i++){
                for(int j=1; j<=c; j++){
                    map[i][j] += temp[i][j];
                }
            }
            // 공기 청정기 작동
            cleaningTop();
            cleaningBottom();
            t--; 
        }

        // 남아 있는 먼지 양 계산
        int answer = 0;
        for(int i=1; i<=r; i++){
            for(int j=1; j<=c; j++){
                if(map[i][j] > 0) answer += map[i][j];
            }
        }
        System.out.println(answer);
    }

    public static void cleaningTop(){
        for(int i=clean-1; i>1; i--){
            map[i][1] = map[i-1][1];
        }
        for(int i=1; i<c; i++){
            map[1][i] = map[1][i+1];
        }
        for(int i=1; i<clean; i++){
            map[i][c] = map[i+1][c];
        }
        for(int i=c; i>2; i--){
            map[clean][i] = map[clean][i-1];
        }
        map[clean][2] = 0;
    }

    public static void cleaningBottom(){
        int bottom = clean + 1;
        for(int i=bottom+1; i<r; i++){
            map[i][1] = map[i+1][1];
        }
        for(int i=1; i<c; i++){
            map[r][i] = map[r][i+1];
        }
        for(int i=r; i>bottom; i--){
            map[i][c] = map[i-1][c];
        }
        for(int i=c; i>2; i--){
            map[bottom][i] = map[bottom][i-1];
        }
        map[bottom][2] = 0;
    }
}