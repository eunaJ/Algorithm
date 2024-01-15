import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        List<Integer> s = new ArrayList<>();
        int i = 0;
        while(i < arr.length){
            if(s.isEmpty()){
                s.add(arr[i]);
                i++;
            }
            else if(s.get(s.size()-1) < arr[i]){
                s.add(arr[i]);
                i++;
            }
            else{
                s.remove(s.size()-1);
            }
        }
        int[] stk = new int[s.size()];
        for(int j=0; j<s.size(); j++){
            stk[j] = s.get(j);
        }
        return stk;
    }
}