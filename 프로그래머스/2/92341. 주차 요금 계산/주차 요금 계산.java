import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> parking = new HashMap<>();
        Map<String, Integer> feeMap = new HashMap<>();
        int baseTime = fees[0];
        int baseFee = fees[1];
        int partTime = fees[2];
        int partFee = fees[3];
        for(int i=0; i<records.length; i++){
            String[] sa = records[i].split(" ");
            int time = calTime(sa[0]);
            String car = sa[1];
            //입차
            if(sa[2].equals("IN")){
                parking.put(car, time);
            } else { // 출차
                int t1 = parking.get(car);
                parking.remove(car);
                if(feeMap.containsKey(car)){
                    int t2 = feeMap.get(car);
                    feeMap.replace(car, t2 + time  - t1);
                } else {
                    feeMap.put(car, time - t1);
                }
            }
        }
        int lastTime = 1439;
        for(String car : parking.keySet()){
            int t1 = parking.get(car);
            if(feeMap.containsKey(car)){
                int t2 = feeMap.get(car);
                feeMap.replace(car, t2 + lastTime - t1);
            } else {
                feeMap.put(car, lastTime - t1);
            }
        }
        
        Object[] sortKey = feeMap.keySet().toArray();
		Arrays.sort(sortKey);
        int[] answer = new int[sortKey.length];

        for(int i=0; i<answer.length; i++){
            int result = baseFee;
            String car = String.valueOf(sortKey[i]);
            int val = feeMap.get(car);
            if(val > baseTime){
                result = (int)(baseFee + Math.ceil((double)(val-baseTime)/partTime) * partFee);
            }
            answer[i] = result;
        }
        return answer;
    }
    
    public int calTime(String t){
        String[] tmp = t.split(":");
        int hour = Integer.parseInt(tmp[0]) * 60;
        int minute = Integer.parseInt(tmp[1]);
        return hour + minute;
    }
}