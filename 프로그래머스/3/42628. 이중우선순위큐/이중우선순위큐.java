import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        int[] answer = { 0, 0 };
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<Integer> rpq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<operations.length; i++){
            String[] s = operations[i].split(" ");
            if(s[0].equals("I")){
                int n = Integer.valueOf(s[1]);
                pq.add(n);
                rpq.add(n);
            }
            else if(s[0].equals("D")){
                if(!pq.isEmpty()){
                    if(Integer.valueOf(s[1]) == 1){
                        int max = rpq.poll();
                        pq.remove(max);
                        
                    } else if(Integer.valueOf(s[1]) == -1){
                        int min = pq.poll();
                        rpq.remove(min);
                    }      
                }                
            }
        }
        return pq.isEmpty() ? answer : new int[] {rpq.peek(), pq.peek()};
    }
}