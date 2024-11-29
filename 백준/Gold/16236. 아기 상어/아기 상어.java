import java.util.*;
import java.io.*;

class Main {
    static int n, answer, sy, sx, size, remain;
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        sx = -1;
        sy = -1;
        size = 2; // 초기 상어 크기
        remain = 2; // 크기 증가를 위한 물고기 개수
        for(int i = 0; i < n; i++){
            String[] sa = br.readLine().split(" ");
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(sa[j]);
                if(map[i][j] == 9){
                    sy = i;
                    sx = j;
                    map[i][j] = 0; // 상어의 위치를 0으로 초기화
                }
            }
        }
        while(true){
            int t = bfs(); // 물고기를 먹으러 가는 시간
            if (t == -1) break; // 더 먹을 물고기가 없
            answer += t; 
            remain--; // 먹은 물고기 카운트 감소
            if(remain == 0){ // 크기 증가
                size++;
                remain = size;
            }
        }
        System.out.println(answer);
    }

    public static int bfs() {
        Queue<int[]> q = new LinkedList<>();
        List<int[]> fishes = new ArrayList<>();
        q.add(new int[] {sy, sx, 0}); // y, x, 거리
        visited = new boolean[n][n];
        visited[sy][sx] = true;
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};
        int minDist = Integer.MAX_VALUE;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int y = cur[0];
            int x = cur[1];
            int dist = cur[2];
            // 현재 위치에서 물고기를 찾음
            if(dist > minDist) continue; // 더 먼 거리면 생략 (우선순위 큐처럼 작동)
            if(map[y][x] > 0 && map[y][x] < size){
                fishes.add(new int[] {y, x, dist});
                minDist = dist; // 최소 거리 갱신
                continue; // 다른 물고기도 탐색
            }
            for(int i = 0; i < 4; i++){
                int ny = y + dy[i];
                int nx = x + dx[i];
                if(ny >= 0 && ny < n && nx >= 0 && nx < n){ 
                    if(map[ny][nx] <= size && !visited[ny][nx]){ 
                        visited[ny][nx] = true;
                        q.add(new int[]{ny, nx, dist + 1});
                    }
                }
            }
        }
        if(fishes.isEmpty()) return -1; // 먹을 수 있는 물고기가 없음
        // 먹을 물고기 중 최적 선택
        fishes.sort((o1, o2) -> {
            if (o1[0] == o2[0]) return o1[1] - o2[1]; // 같은 거리면 x 좌표 우선
            return o1[0] - o2[0]; // y 좌표가 작은 물고기 우선
        });
        int[] chosenFish = fishes.get(0); // 최적의 물고기 선택
        sy = chosenFish[0];
        sx = chosenFish[1];
        map[sy][sx] = 0; // 먹은 물고기 위치를 0으로 초기화
        return chosenFish[2]; // 물고기를 먹으러 가는 데 걸린 거리 반환
    }
}