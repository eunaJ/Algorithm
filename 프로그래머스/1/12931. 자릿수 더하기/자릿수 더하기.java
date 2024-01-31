import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        int c = n;
        while(c > 0){            
            answer = answer + c % 10;
            c /= 10;
        }
        return answer;
    }
}