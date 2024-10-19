import java.lang.*;
class Solution {
    public int solution(int[] arr) {
        int answer = arr[0];
        for(int i=1; i<arr.length; i++){
            answer = lcm(answer, arr[i]);
        }
        return answer;
    }
    
    // 최대공약수
    public int gcd(int a, int b){
        while(b != 0){
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }
    
    // 최소공배수
    public int lcm(int a, int b){
        return Math.abs(a*b) / gcd(a, b);
    }
}