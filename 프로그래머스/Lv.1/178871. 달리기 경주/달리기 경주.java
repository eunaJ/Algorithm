import java.util.*;
class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = Arrays.copyOf(players, players.length);
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for(int i=0;i< players.length;i++){
            map.put(players[i],i);
        }
        for(int j=0; j<callings.length; j++){
            int c = map.get(callings[j]);
            String s = answer[c-1];
            answer[c-1] = callings[j];
            answer[c] = s;
            map.put(callings[j], c-1);
            map.put(s,c);
        }
        return answer;
    }
}