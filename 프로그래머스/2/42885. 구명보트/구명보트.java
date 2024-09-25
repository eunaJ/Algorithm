import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int i = 0;
        int j = people.length - 1;
        while(i <= j){
            if(people[i] + people[j] <= limit){
                i++;
                j--;
            } else {
                j--;
            }
            answer++;
            if(j < 0 || i >= people.length-1) break;
        }
        return answer;
    }
}