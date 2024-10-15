import java.lang.Math;
class Solution {
    public int solution(int[] money) {
        int[] dp1 = new int[money.length]; // 첫 집 털기 -> 마지막 집 X
        int[] dp2 = new int[money.length]; // 첫 집 X
        dp1[0] = money[0];
        dp1[1] = money[0];
        dp2[0] = 0;
        dp2[1] = money[1];
        for(int i=2; i<money.length; i++){
            // 현재 집 털기 vs 안 털기
            dp1[i] = Math.max(dp1[i-2]+money[i], dp1[i-1]);
            dp2[i] = Math.max(dp2[i-2]+money[i], dp2[i-1]);
        }
        return Math.max(dp1[money.length-2], dp2[money.length-1]);
    }
}