import java.util.*;
public class Solution {
    public int[] solution(int []arr) {
        List<Integer> list = new ArrayList<>();
        int v = -1;
        for(int i=0; i<arr.length; i++){
            if(v != arr[i]){
                list.add(arr[i]);
                v = arr[i];
            }
        }
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }        
        return answer;
    }
}