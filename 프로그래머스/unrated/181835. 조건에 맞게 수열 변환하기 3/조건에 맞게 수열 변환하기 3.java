class Solution {
    public int[] solution(int[] arr, int k) {
        int[] answer = arr;
        for(int i=0; i<arr.length; i++){
            if(k % 2 != 0){
                answer[i] = arr[i] * k;
            }
            else{
                answer[i] += k;
            }
        }
        return answer;
    }
}