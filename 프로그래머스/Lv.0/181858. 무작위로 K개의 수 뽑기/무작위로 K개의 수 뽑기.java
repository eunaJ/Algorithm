import java.util.Arrays;
class Solution {
    public int[] solution(int[] arr, int k) {
        int[] answer = Arrays.stream(arr).distinct().toArray();
        if(answer.length >= k) return Arrays.copyOfRange(answer, 0, k);
        else {
            int s = answer.length;
            int[] a = new int[k];
            //int[] a = Arrays.copyOf(answer, k - s + 2);
            for(int i=0; i<k; i++){
                if(i<s) a[i] = answer[i];
                else a[i] = -1;
            }
            return a;
        }
    }
}