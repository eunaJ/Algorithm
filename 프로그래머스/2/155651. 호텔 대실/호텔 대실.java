import java.util.*;
class Solution {
    public int solution(String[][] book_time) {
        int answer = 1;
        PriorityQueue<String> pq = new PriorityQueue<>();
        // 퇴실 시간에 10분 더함
        for(String[] t : book_time){
            t[1] = plus10m(t);
        }
        // 시작 기준 정렬
        Arrays.sort(book_time, (o1, o2) -> o1[0].compareTo(o2[0]));
        for(String[] b : book_time){
            while(!pq.isEmpty() && pq.peek().compareTo(b[0])<=0){
                pq.poll();
            }
            pq.add(b[1]);
            answer = Math.max(answer, pq.size());
        }
        return answer;
    }
    
    // 10분 더하는 함수
    public String plus10m(String[] t){
        String[] time = t[1].split(":");
        int h = Integer.parseInt(time[0]);
        int m = Integer.parseInt(time[1]);
        m += 10;
        if(m >= 60){
            h += 1;
            m -= 60;
        }
        return String.format("%02d:%02d", h, m);
    }
}