import java.lang.Math;
import java.util.Arrays;

class Solution {
    public int solution(int a, int b, int c, int d) {
        int[] arr = new int[] {a,b,c,d};
        Arrays.sort(arr);
        // 모두 같을 때
        if(arr[0]==arr[3]) return 1111*a;
        // 모두 다를 때
        else if(arr[0]!=arr[1] && arr[1]!=arr[2] && arr[2]!=arr[3]) {
            return Math.min(Math.min(a,b), Math.min(c, d));
        }
        // 세 수 같을 때
        else if(arr[0]!=arr[1] && arr[1]==arr[3]){
            return (int)Math.pow(10*arr[3]+arr[0], 2);
        }
        else if(arr[0]==arr[2] && arr[2]!=arr[3]){
            return (int)Math.pow(10*arr[0]+arr[3], 2);
        }
        // 두 수씩 같을 때
        else if(arr[0]==arr[1] && arr[2]==arr[3] && arr[1]!=arr[2]){
            return (arr[0]+arr[3])*(arr[3]-arr[0]);
        }
        // 두 수 같고, 각각 다를 때
        else if(arr[0]==arr[1]){
            return arr[2]*arr[3];
        }
        else if(arr[1]==arr[2]){
            return arr[0]*arr[3];
        }
        else{
            return arr[0]*arr[1];
        }
    }
}