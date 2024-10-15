import java.util.*;
class Solution {
    public int solution(int N, int number) {
        // 사칙연산 중 중복 제거 위해 set 사용
        Set<Integer>[] num = new HashSet[9];
        int n = N;
        for(int i=1; i<9; i++){
            num[i] = new HashSet<>();
            num[i].add(n);
            n = n * 10 + N; // ex) 5, 55, 555.. 위해
        }
        int answer = calMin(N, number, num);
        return answer;
    }
    
    // dp
    public int calMin(int N, int number, Set<Integer>[] num){
        for(int i=1; i<9; i++){
            for(int j=1; j<i; j++){
                for(Integer x : num[j]){
                    for(Integer y : num[i-j]){
                        num[i].add(x+y);
                        num[i].add(x-y);
                        num[i].add(x*y);
                        if(x != 0) num[i].add(y/x);
                        if(y != 0) num[i].add(x/y);
                    }
                }
            }
        }
        for(int i=1; i<9; i++) { // 최솟값
            if(num[i].contains(number)) return i;
        }
        return -1;
    }
}