import java.lang.*;
class Solution {
    public int solution(String name) {
        int answer = 0;
        int move = name.length() - 1; // 기본 최소 이동, 좌우 커서
        for(int i=0; i<name.length(); i++){
            // 상하
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);
            int index = i + 1;
            // 연속 A 개수
            while(index < name.length() && name.charAt(index) == 'A'){
                index += 1;
            }
            // 앞으로 이동 후 되돌아가기
            // i까지 이동한 후 다시 돌아 + 문자열 끝까지 남은 부분 이동
            move = Math.min(move, i * 2 + name.length() - index);
            // 끝까지 이동 후 되돌아가기
            // 문자열 끝까지 이동 후 다시 돌아 + i까지 이동
            move = Math.min(move, (name.length() - index) * 2 + i);
        }
        answer += move;
        return answer;
    }
}