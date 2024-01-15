class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        int j = 0;
        while(j < arr.length){
            j = 0;
            for(int i=0; i<arr.length; i++){
                if(arr[i]>=50 && arr[i]%2==0){
                    arr[i] /= 2;
                }
                else if(arr[i]<50 && arr[i]%2!=0){
                    arr[i] = arr[i] * 2 + 1;
                }
                else {
                    j++;
                }
            }
            answer++;
        }
        return answer-1;
    }
}