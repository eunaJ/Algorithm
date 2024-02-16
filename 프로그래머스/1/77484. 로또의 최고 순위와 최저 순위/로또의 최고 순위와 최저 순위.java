import java.util.*;
class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        List<Integer> li = new ArrayList<>();
        int z = 0;
        answer[1] = 7;
        for(int i : win_nums){
            li.add(i);
        }
        for(int j=0; j<lottos.length; j++){
            if(lottos[j] == 0) z++;
            else if(li.contains(lottos[j])) answer[1]--;
        }
        if(answer[1] == 7) answer[1]--;
        answer[0] = answer[1] - z;
        if(answer[0] == 0) answer[0]++;
        return answer;
    }
}