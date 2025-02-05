import java.util.*;
import java.io.*;

class Main {
    public static ArrayList<int[]> house, chicken, select;
    public static int n, m, answer;
    public static int[][] map;
    public static boolean[] visit;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = br.readLine().split(" ");
        n = Integer.parseInt(sa[0]);
        m = Integer.parseInt(sa[1]);
        map = new int[n][n];
        house = new ArrayList<>();
        chicken = new ArrayList<>();
        select = new ArrayList<>();
        answer = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            sa = br.readLine().split(" ");
            for(int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(sa[j]);
                if(map[i][j] == 1) house.add(new int[]{i, j});
                else if(map[i][j] == 2) chicken.add(new int[]{i, j});
            }
        }
        visit = new boolean[chicken.size()];
        back(0, 0);
        System.out.println(answer);
    }

    public static void back(int depth, int start){
        // 뽑은 치킨집이 m개일 때
        if(depth == m){
            int sum = 0;
            // 각각의 집에서 가장 가까운 치킨집을 구함
            for(int[] h : house){
                int min = Integer.MAX_VALUE;
                for(int[] s : select){
                    int d = Math.abs(h[0] - s[0]) + Math.abs(h[1] - s[1]);
                    min = Math.min(min, d);
                }
                // 모두 더해서 치킨 거리 계산
                sum += min;
            }
            answer = Math.min(answer, sum);
            return;
        }
        for(int i=start; i<chicken.size(); i++){
            if(!visit[i]){
                visit[i] = true;
                select.add(chicken.get(i));
                back(depth+1, i+1);
                select.remove(chicken.get(i));
                visit[i] = false;
            }
        }
    }
}