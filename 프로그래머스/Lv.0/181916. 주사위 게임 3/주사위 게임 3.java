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

// 좀 더 깔끔
// else if (dice[0] == dice[2] || dice[1] == dice[3]) {
//     ans = (int) Math.pow(dice[1] * 10 + (dice[0] + dice[3] - dice[1]), 2);
// } else if (dice[0] == dice[1] && dice[2] == dice[3]) {
//     ans = (dice[0] + dice[3]) * (dice[3] - dice[0]);
// } else if (dice[0] == dice[1]) {
//     ans = dice[2] * dice[3];
// } else if (dice[1] == dice[2]) {
//     ans = dice[0] * dice[3];
// } else if (dice[2] == dice[3]) {
//     ans = dice[0] * dice[1];
// } else {
//     ans = dice[0];
// }