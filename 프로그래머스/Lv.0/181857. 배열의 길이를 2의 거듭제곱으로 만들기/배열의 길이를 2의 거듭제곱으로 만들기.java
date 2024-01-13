import java.lang.Math;
class Solution {
    public int[] solution(int[] arr) {
        int i = 0;
        while(Math.pow(2, i) < arr.length){
            i++;
        }
        int[] answer = new int[(int)Math.pow(2, i)];
        for(int j=0; j<Math.pow(2, i); j++){
            if(j >= arr.length)
                answer[j] = 0;
            else answer[j] = arr[j];
        }                
        return answer;
    }
}


//
// int length = 1;
// while (length < arr.length) {
//     length *= 2;
// }
// return Arrays.copyOf(arr, length);