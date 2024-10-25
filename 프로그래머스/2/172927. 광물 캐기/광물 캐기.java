import java.util.*;
class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int dia = picks[0];
        int iron = picks[1];
        int stone = picks[2];
        int totalPick = dia + iron + stone; // 곡갱이 총 개수
        int[][] mg = new int[totalPick][6]; // 그룹별 피로도 계산
        // 피로도 계산 및 그룹화
        for(int i=0; i<Math.min(totalPick*5, minerals.length); i+=5) {
            int sum = 0;
            int damage = 0;
            for(int j=i; j<Math.min(i+5, minerals.length); j++) {
                switch (minerals[j]) {
                    case "diamond":
                        damage = 25;
                        break;
                    case "iron":
                        damage = 5;
                        break;
                    case "stone":
                        damage = 1;
                        break;
                }
                sum += damage;
                mg[i/5][j%5+1] = damage;
            }
            mg[i/5][0] = sum;
        }
        // 피로도 합 기준 내림차순
        Arrays.sort(mg, (o1, o2)->o2[0]-o1[0]);
        // 곡갱이 소모하며 피로도 계산
        for(int[] group : mg) {
            if(dia > 0) {
                answer += calFatigue(group, 25);
                dia--;
            } else if(iron > 0) {
                answer += calFatigue(group, 5);
                iron--;
            } else if(stone > 0) {
                answer += calFatigue(group, 1);
                stone--;
            }
        }
        return answer;
    }
    
    private int calFatigue(int[] group, int f){
        int fatigue = 0;
        for(int i=1; i<=5; i++){
            fatigue += (int)Math.ceil(group[i]/(double)f);
        }
        return fatigue;
    }
}