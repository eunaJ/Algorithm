import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            if(answer >= nums.length/2){
                break;
            }
            if(!list.contains(nums[i])){
                list.add(nums[i]);
                answer++;
            }
        }
        return answer;
    }
}