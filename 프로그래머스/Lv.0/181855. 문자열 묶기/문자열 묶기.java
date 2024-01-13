class Solution {
    public int solution(String[] strArr) {
        int answer = 0;
        int[] arr = new int[30];
        for(int i=0; i<strArr.length; i++){
            int s = strArr[i].length()-1;
            arr[s]++;
            if(arr[s] > answer)
                answer = arr[s];
        }        
        return answer;
    }
}