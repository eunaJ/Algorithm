import java.util.*;
class Solution {
    public int solution(int distance, int[] rocks, int n) {
        // 최소 거리 최대화 -> 이진 탐색?
        int answer = 0;
        // 도착지점 바위 추가
        int[] tmpRocks = new int[rocks.length+1];
        System.arraycopy(rocks, 0, tmpRocks, 0, rocks.length);
        tmpRocks[tmpRocks.length-1] = distance;
        Arrays.sort(tmpRocks);
        int s = 1;
        int e = distance;
        while(s <= e){
            int c = 0; // 제거할 바위 수
            int cnt = 0; // 이전 바위 위치
            int mid = (s+e) / 2; // 현재 시도 최소 거리
            for(int rock : tmpRocks){
                // 현재 - 이전 거리가 mid 이상
                if(rock - cnt >= mid){
                    cnt = rock;
                } else { // 현재 바위 제거
                    c++;
                }
            }
            if(c <= n){
                s = mid + 1;
                answer = mid;
            } else {
                e = mid - 1;
            }
        }
        return answer;
    }
}