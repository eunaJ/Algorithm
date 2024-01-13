import java.util.Arrays;
class Solution {
    public int[][] solution(int[][] arr) {
        int[][] answer = {};
        if(arr.length == arr[0].length){
            return arr;
        }
        else if(arr.length > arr[0].length){
            int c = arr.length - arr[0].length;
            answer = new int[arr.length][arr.length];
            for(int i=0; i<arr.length; i++){
                answer[i] = Arrays.copyOfRange(arr[i], 0, arr.length);
            }
        }
        else{
            int c = arr[0].length - arr.length;
            answer = new int[arr[0].length][arr[0].length];
            for(int i=0; i<arr.length; i++){
                answer[i] = Arrays.copyOfRange(arr[i], 0, arr[0].length);
            }
        }
        return answer;
    }
}