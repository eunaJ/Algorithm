import java.util.*;
class Solution {   
    public int solution(int[] numbers, int target) {
        List<Integer> sums = new ArrayList<>();
        sums.add(0);
        for(int i=0; i<numbers.length; i++){
            List<Integer> li = new ArrayList<>();
            for(Integer sum : sums){
                li.add(sum + numbers[i]);
                li.add(sum - numbers[i]);
            }
            sums = li;
        }
        return Collections.frequency(sums, target);
    }
}