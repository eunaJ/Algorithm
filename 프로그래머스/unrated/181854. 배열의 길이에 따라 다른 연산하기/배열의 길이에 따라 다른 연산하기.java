class Solution {
    public int[] solution(int[] arr, int n) {
        int[] answer = arr;
        if(arr.length % 2 != 0){
            for(int i=0; i<arr.length; i+=2){
                answer[i] = n + arr[i];
            }
        }
        else {
            for(int i=1; i<arr.length; i+=2){
                answer[i] = n + arr[i];
            }
        }
        return answer;
    }
}