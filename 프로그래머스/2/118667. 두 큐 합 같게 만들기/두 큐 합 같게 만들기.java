import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        long sum1 = getSum(queue1);
        long sum2 = getSum(queue2);
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        for(int i=0; i<queue1.length; i++){
            q1.add(queue1[i]);
            q2.add(queue2[i]);
        }
        while(sum1 != sum2){
            int v = 0;
            if(answer > (queue1.length + queue2.length)*2) return -1;
            if(sum1 < sum2){
                v = q2.poll();
                q1.add(v);
                sum1 += (long)v;
                sum2 -= (long)v;
            } else if(sum1 > sum2){
                v = q1.poll();
                q2.add(v);
                sum1 -= (long)v;
                sum2 += (long)v;
            } else {
                return answer;
            }
            answer++;
        }
        return answer;
    }
    
    public long getSum(int[] q){
        long sum = 0;
        for(int i=0; i<q.length; i++){
            sum += (long)q[i];
        }
        return sum;
    }
}