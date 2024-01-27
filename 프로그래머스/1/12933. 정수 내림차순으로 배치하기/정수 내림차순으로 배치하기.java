import java.util.Arrays;
class Solution {
    public long solution(long n) {
        long answer = 0;
        int[] arr = new int[(int)(Math.log10(n)+1)];
        for(int i=0; i<arr.length; i++){
            arr[i] = (int)(n % 10);
            n /= 10;
        }
        Arrays.sort(arr);
        for(int i=0; i<arr.length; i++){
            answer = answer + arr[i] * (long)Math.pow(10, i);
        }
        return answer;
    }
}