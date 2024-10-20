import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> m = new HashMap<>();
        for(int t : tangerine){
            m.put(t, m.getOrDefault(t, 0)+1);
        }
        // Map -> List로 변경
        List<Map.Entry<Integer, Integer>> li = new ArrayList<>(m.entrySet());
        // 개수 기준 내림차순 정렬
        li.sort((o1, o2)->o2.getValue().compareTo(o1.getValue()));
        int answer = 0;
        int c = 0;
        // 많은 것부터 담기
        for(Map.Entry<Integer, Integer> e : li){
            c += e.getValue();
            answer++;
            if(c >= k) {
                break;
            }
        }
        return answer;
    }
}