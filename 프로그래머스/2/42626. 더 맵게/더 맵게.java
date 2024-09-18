import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> mh = new PriorityQueue<>();
        for (int s : scoville) {
            mh.add(s);
        }
         while (mh.size() > 1 && mh.peek() < K) {
            int s1 = mh.poll();
            int s2 = mh.poll();
            int ns = s1 + (s2 * 2);
            mh.add(ns);
            answer++;
        }     
        return mh.peek() >= K ? answer : -1;
    }
}