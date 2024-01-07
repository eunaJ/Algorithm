import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
class Solution {
    public int[] solution(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[i]; j++){
                list.add(arr[i]);
            }
        }
        int[] answer = new int[list.size()];
        for(int k = 0; k < list.size(); k++){
            answer[k] = list.get(k);
        }
        return answer;
    }
}