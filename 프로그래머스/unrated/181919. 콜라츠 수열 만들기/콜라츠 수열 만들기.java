import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
class Solution {
    public int[] solution(int n) {
        List<Integer> list = new ArrayList<>();
        int i = n;
        list.add(i);
        while(i > 1){
            if(i % 2 == 0) {
                list.add(i / 2);
                i = i / 2;
            }
            else {
                list.add(3 * i + 1);
                i = 3 * i + 1;
            }
        }
        int[] answer = new int[list.size()];
        for(int j=0; j<list.size(); j++)
            answer[j] = list.get(j);
        return answer;
    }
}