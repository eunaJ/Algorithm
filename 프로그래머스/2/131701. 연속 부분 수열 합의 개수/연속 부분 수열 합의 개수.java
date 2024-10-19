import java.util.*;
class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        Set<Integer> s = new HashSet<>();
        // 부분합의 길이
        for(int i=1; i<=elements.length; i++){
            // 각 시작점에 대한 부분합
            for(int j=0; j<elements.length; j++){
                int sum = 0;
                for(int k=0; k<i; k++){
                    // 인덱스 접근 방식 -> 원형 배열이라서
                    sum += elements[(j+k) % elements.length];
                }
                s.add(sum);
            }            
        }
        return s.size();
    }
}