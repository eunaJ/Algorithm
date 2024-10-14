import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        int answer = 1; // routes의 첫 진출 지점 때문
        // 진출 지점을 기준으로 정렬
        Arrays.sort(routes, (o1, o2)->{
            if(o1[1] == o2[1]) return o1[0]-o2[0];
            else return o1[1]-o2[1];
        });
        int e = routes[0][1];
        for(int i=1; i<routes.length; i++){
            // 진입 지점이 카메라에 벗어났을 경우
            if(routes[i][0] > e){
                answer++;
                e = routes[i][1];
            }
        }
        return answer;
    }
}