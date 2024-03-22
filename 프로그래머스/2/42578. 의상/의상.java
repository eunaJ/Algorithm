import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        LinkedList<Integer> li = new LinkedList<>();
        HashMap<String, Integer> hm = new HashMap<>();
        int c = 1;
        for(int i=0; i<clothes.length; i++){
            if(hm.containsKey(clothes[i][1])) {
                c = hm.get(clothes[i][1])+1;
                hm.replace(clothes[i][1], c);
            }
            else{
                hm.put(clothes[i][1], 1);
            }
        }
        if(hm.size() == 1) return clothes.length;
        for(String k : hm.keySet()){
            answer *= (hm.get(k)+1);
        }
        answer -= 1;
        return answer;
    }
}