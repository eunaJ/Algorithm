import java.util.*;
// 스케줄링
class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);        
        // 들어오는 순서대로 정렬
        Arrays.sort(jobs, (o1, o2) -> { return o1[0] - o2[0]; });
        int e = 0; // 끝나는 시점
        int i = 0; 
        int cnt = 0; // jobs
        while(cnt < jobs.length){
            while(i < jobs.length && jobs[i][0] <= e){
                pq.add(jobs[i]);
                i++;
            }
            if(pq.isEmpty()) {
                e = jobs[i][0];
            } else {
                int[] c = pq.poll();
                answer += c[1] + e - c[0];
                e += c[1];
                cnt++;
            }
        }
        return answer / jobs.length;
    }
}