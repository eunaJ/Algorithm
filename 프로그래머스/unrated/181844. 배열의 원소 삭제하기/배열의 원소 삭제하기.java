import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        List<Integer> list = new ArrayList<>();
        for(int i: arr){
            list.add(i);
        }
        for(int d : delete_list){
            int n = list.indexOf(d);
            if(n != -1){
                list.remove(n);
            }
        }
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) 
            answer[i] = list.get(i);
        return answer;
    }
}