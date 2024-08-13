import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] arr = new String[numbers.length];
        for(int i=0; i<numbers.length; i++){
            arr[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(arr, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        if(arr[0].equals("0")) return "0";
        for(String s : arr){
            answer += s;
        }
        return answer;
    }
}


// 막연히 문자열 정렬 X. 3, 30 있으면 330 이 되어야 함
// 문자열 연결하여 비교
// 0, 0