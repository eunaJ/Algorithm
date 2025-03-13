import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        Arrays.sort(weights);
        Map<Double, Integer> m = new HashMap<>();
        for(int w : weights){
            // 무게 같, 2/3, 2/4, 3/4인 경우
            double a = w * 1.0;
            double b = (w * 2.0) / 3.0;
            double c = (w * 1.0) / 2.0;
            double d = (w * 3.0) / 4.0;
            
            if(m.containsKey(a)) answer += m.get(a);
            if(m.containsKey(b)) answer += m.get(b);
            if(m.containsKey(c)) answer += m.get(c);
            if(m.containsKey(d)) answer += m.get(d);
            
            m.put(w * 1.0, m.getOrDefault((w * 1.0), 0) + 1);
        }
        return answer;
    }
}