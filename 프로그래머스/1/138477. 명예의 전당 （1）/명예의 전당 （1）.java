import java.util.*;
class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        List<Integer> fame = new ArrayList<>();
        for(int i=0; i<score.length; i++){
            fame.add(score[i]);
            if(fame.size() > k){
                fame.remove(Collections.min(fame));
            }
            answer[i] = Collections.min(fame);
        }
        return answer;
    }
}