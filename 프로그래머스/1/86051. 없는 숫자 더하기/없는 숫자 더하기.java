import java.util.Arrays;
class Solution {
    public int solution(int[] numbers) {
        int answer = 0; 
        for(int i=0; i<=9; i++){
            answer += i;
            for(int j=0; j<numbers.length; j++) {  
                if(numbers[j] == i){
                    answer -= i;
                    break;
                }
            }
        }
        return answer;
    }
}