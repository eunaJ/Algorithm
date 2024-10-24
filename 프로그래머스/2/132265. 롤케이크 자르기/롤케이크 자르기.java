import java.util.*;
class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        // 왼쪽
        HashSet<Integer> hl = new HashSet<>();
        // 오른쪽
        Map<Integer, Integer> mr = new HashMap<>();
        // 오른쪽 미리 저장
        for(int t : topping){
            mr.put(t, mr.getOrDefault(t, 0)+1);
        }       
        for(int i=0; i<topping.length-1; i++){
            // 왼쪽에 추가
            hl.add(topping[i]);
            // 오른쪽에서 삭제
            mr.put(topping[i], mr.getOrDefault(topping[i], 0)-1);
            if(mr.get(topping[i]) == 0) mr.remove(topping[i]); // 개수 세기 위해 제거
            if(hl.size() == mr.size()) answer++;
        }
        return answer;
    }
}