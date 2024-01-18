import java.util.Arrays;
class Solution {
    public int[] solution(int[] arr) {
        if(arr.length == 1){
            return new int[]{-1};
        }
        int[] a = Arrays.copyOf(arr, arr.length);
        Arrays.sort(a);
        int[] answer = new int[arr.length-1];
        int c = 0;
        for(int j=0; j<answer.length; j++){
            if(arr[j] == a[0]){c++;}
            answer[j] = arr[c++];
        }
        return answer;
    }
}