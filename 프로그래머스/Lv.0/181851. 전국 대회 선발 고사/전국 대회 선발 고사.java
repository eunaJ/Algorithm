import java.util.*;
class Solution {
    public int solution(int[] rank, boolean[] attendance) {
        Map<Integer, Integer> m = new HashMap<>();
        for(int i=0; i<rank.length; i++){
            if(attendance[i]){
                m.put(rank[i], i);
            }
        }
        
        List<Integer> list = new ArrayList<>(m.keySet());
        Collections.sort(list);
        return 10000*m.get(list.get(0)) + 100*m.get(list.get(1)) + m.get(list.get(2));
    }
}