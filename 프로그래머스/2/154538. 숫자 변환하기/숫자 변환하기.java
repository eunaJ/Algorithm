import java.util.*;
class Solution {
    public int solution(int x, int y, int n) {
        int answer = 0;
        HashSet<Integer> xx = new HashSet<>();
        xx.add(x);
        while(!xx.isEmpty()){
            HashSet<Integer> t = new HashSet<>();
            for(Integer i : xx){
                if(i > y) continue;
                if(i == y) return answer;
                t.add(i+n);
                t.add(i*2);
                t.add(i*3);
            }
            answer++;
            xx = t;
        }
        return -1;
    }
}

// 1차 ArrayList -> 메모리 초과