import java.util.*;
import java.lang.Math;
class Solution {
    public String[] solution(String[][] plans) {
        // 시작시간을 기준으로 오름차순
        Arrays.sort(plans, (o1, o2)->toMinutes(o1[1]) - toMinutes(o2[1]));
        Stack<String[]> stopPlans = new Stack<>();
        List<String> answer = new LinkedList<>();
        int curTime = 0; // 현재 시간
        for(int i=0; i<plans.length; i++){
            String pName = plans[i][0];
            int pStartTime = toMinutes(plans[i][1]);
            int pDurTime = Integer.parseInt(plans[i][2]);
            // 현재 시간 
            curTime = Math.max(curTime, pStartTime);
            // 다음 과제 전까지 현재 과제 끝나는지
            if(i+1 < plans.length){
                int npStartTime = toMinutes(plans[i+1][1]);
                // 끝날 수 있으면
                if(curTime+pDurTime <= npStartTime){
                    curTime += pDurTime;
                    answer.add(pName);
                } else {
                    // 못 끝나면 중단 과제
                    int remainTime = pDurTime - (npStartTime - curTime);
                    curTime = npStartTime;
                    stopPlans.push(new String[] {pName, String.valueOf(remainTime)});
                }
                // 다음 과제까지
                while (!stopPlans.isEmpty() && curTime < npStartTime) {
                    String[] pausedPlan = stopPlans.pop();
                    int pausedPlanReTime = Integer.parseInt(pausedPlan[1]);
                    // 중단된 과제를 완료할 수 있는지 확인
                    if (curTime + pausedPlanReTime <= npStartTime) {
                        curTime += pausedPlanReTime;
                        answer.add(pausedPlan[0]); // 중단된 과제 완료
                    } else {
                        // 다 끝내지 못하면 다시 스택에 남은 시간 저장
                        stopPlans.push(new String[] {pausedPlan[0], String.valueOf(pausedPlanReTime - (npStartTime - curTime))});
                        curTime = npStartTime; // 다음 과제로 넘어가기
                    }
                }
            } else {
                // 다음 과제 없으면 현재 과제 완료
                curTime += pDurTime;
                answer.add(pName);
                // 멈춘 과제 완료
                while(!stopPlans.isEmpty()){
                    String[] pushed = stopPlans.pop();
                    answer.add(pushed[0]);
                }
            }
        }
        return answer.toArray(new String[0]);
    }
    
    public int toMinutes(String t){
        String[] s = t.split(":");
        int hour = Integer.parseInt(s[0]);
        int minute = Integer.parseInt(s[1]);
        return hour * 60 + minute;
    }
}