import java.util.Arrays;
class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        int[] arr = Arrays.copyOf(d, d.length);
        int b = budget;
        Arrays.sort(arr);
        for(int i=0; i<d.length; i++){
            if(b-arr[i] < 0) break;
            else {
                answer++;
                b -= arr[i];
            }
        }
        return answer;
    }
}