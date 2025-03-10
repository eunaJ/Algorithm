import java.util.*;

class Solution {
    static Queue<int[]>[] path;
    static int x, answer;
    
    public int solution(int[][] points, int[][] routes) {
        answer = 0;
        x = routes.length;
        path = new LinkedList[x];
        for(int i=0; i<x; i++){
            path[i] = new LinkedList<>();
        }
        routing(points, routes);
        countingDangers();
        return answer;
    }
    
    public void routing(int[][] points, int[][] routes){
        for(int i=0; i<x; i++){
            int[] route = routes[i];
            int y = points[route[0]-1][0];
            int x = points[route[0]-1][1];
            path[i].add(new int[]{y, x});
            for(int j=1; j<route.length; j++){
                int ny = points[route[j]-1][0];
                int nx = points[route[j]-1][1];
                while(ny != y){
                    if(ny > y) y++;
                    else y--;
                    path[i].add(new int[]{y, x});
                }
                while(nx != x){
                    if(nx > x) x++;
                    else x--;
                    path[i].add(new int[]{y, x});
                }
            }
        }
    }
    
    public void countingDangers(){
        int cnt = 0;
        while(cnt < x){
            int[][] map = new int[101][101];
            cnt = 0;
            for(int i=0; i<x; i++){
                if(path[i].isEmpty()){
                    cnt++;
                    continue;
                }
                int[] tmp = path[i].poll();
                map[tmp[0]][tmp[1]]++;
            }
            for(int i=0; i<101; i++){
                for(int j=0; j<101; j++){
                    if(map[i][j] > 1) answer++;
                }
            }
        }
    }
}