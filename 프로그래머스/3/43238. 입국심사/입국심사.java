import java.util.*;
class Solution {
    private long answer;
    public long solution(int n, int[] times) {
        long answer = Long.MAX_VALUE;
        long s = times[0];  
        long e = (long)times[times.length-1] * (long)n;     
        while(s <= e) {
            long m =  (s+e) / 2;
            long sum = 0;
            for(int time : times){
                sum += m/time;
            }
            if(sum >= n) {
                answer = m;
                e = m - 1;
            } else {
                s = m + 1;
            }
        }
        return answer;
    }
}