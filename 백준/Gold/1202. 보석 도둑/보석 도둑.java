import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = br.readLine().split(" ");
        int n = Integer.parseInt(sa[0]);
        int k = Integer.parseInt(sa[1]);
        int[][] mv = new int[n][2];
        int[] bags = new int[k];
        long answer = 0;
        for(int i=0; i<n; i++){
            sa = br.readLine().split(" ");
            mv[i][0] = Integer.parseInt(sa[0]);
            mv[i][1] = Integer.parseInt(sa[1]);
        }
        Arrays.sort(mv, (o1, o2)->{
            if(o1[0] == o2[0]) return o2[1]-o1[1];
            else return o1[0]-o2[0];
        });
        for(int i=0; i<k; i++){
            bags[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(bags);
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int idx = 0;
        for(int bag : bags){
            while(idx < n && bag >= mv[idx][0]){
                pq.add(mv[idx][1]);
                idx++;
            }
            if(!pq.isEmpty()) answer += pq.poll();
        }
        System.out.println(answer);
    }
}