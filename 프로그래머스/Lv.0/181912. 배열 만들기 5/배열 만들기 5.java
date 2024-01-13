import java.util.*;
class Solution {
    public int[] solution(String[] intStrs, int k, int s, int l) {
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<intStrs.length; i++){
            String str = intStrs[i].substring(s, s+l);
            if(Integer.parseInt(str) > k)
                list.add(Integer.parseInt(str));
        }
        int[] answer = new int[list.size()];
        for(int j=0; j<list.size(); j++){
            answer[j] = list.get(j);
        }
        return answer;
    }
}