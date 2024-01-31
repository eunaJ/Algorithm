import java.util.*;
class Solution {
    public int[] solution(int[] arr, int divisor) {
        
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<arr.length; i++){
            if(arr[i] % divisor == 0)
                list.add(arr[i]);
        }
        int[] answer = new int[list.size()];
        if(list.isEmpty()){
            return new int[]{-1};
        }
        for(int i=0; i<list.size(); i++){
           answer[i] = list.get(i); 
        }
        Arrays.sort(answer);
        return answer;
    }
}