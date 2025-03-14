import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        HashMap<String, Integer> hm = new HashMap<>();
        for(int i=0; i<want.length; i++){
            hm.put(want[i], number[i]);
        }
        // 처음 10일 비교
        for(int i=0; i<10; i++){
            if(hm.containsKey(discount[i])){
                hm.put(discount[i], hm.get(discount[i])-1);
            }
        }
        // hm의 값이 모두 0이면 want 모두 구매
        if(isMatch(hm)) answer++;
        
        // 슬라이딩
        for(int i=10; i<discount.length; i++){
            if(hm.containsKey(discount[i-10])){
                hm.put(discount[i-10], hm.get(discount[i-10])+1);
            }
            if(hm.containsKey(discount[i])){
                hm.put(discount[i], hm.get(discount[i])-1);
            }
            if(isMatch(hm)) answer++;
        }
        return answer;
    }
    
    public boolean isMatch(HashMap<String, Integer> hm){
        for(String key : hm.keySet()){
            if(hm.get(key) != 0) return false;
        }
        return true;
    }
}