import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        LinkedList<Integer> li = new LinkedList<>();
        Queue<Integer> q = new LinkedList<>();
        int n = 0;
        for(int i=0; i<progresses.length; i++){
            n = (int)Math.ceil((100.0-progresses[i])/speeds[i]);
            q.offer(n);
        }
        int c = 1;
        int x = q.poll();
        while(!q.isEmpty()){
            if(x >= q.peek()) {
                c++;
                q.poll();
            }
            else{
                li.add(c);
                c = 1;
                x = q.poll();
            }
        }
        li.add(c);
        int[] answer = new int[li.size()];
        for(int i=0; i<li.size(); i++){
            answer[i] = li.get(i);
        }
        return answer;
    }
}