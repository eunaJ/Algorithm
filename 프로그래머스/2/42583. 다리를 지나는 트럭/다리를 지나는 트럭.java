import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int w = 0; // 현재 무게
        int twl = truck_weights.length;
        // int[] bridge = new int[bridge_length];
        Queue<Integer> bridge = new LinkedList<>();
        int i = 0; // truck_weights 인덱스
        for(int j=0; j<bridge_length; j++){
            bridge.add(0);
        }
        while(twl > 0){
            answer++;
            w = w - bridge.remove();
            if(w+truck_weights[i] <= weight){
                w += truck_weights[i];
                bridge.add(truck_weights[i]);
                twl--;
                i++;
            } else {
                bridge.add(0);
            }
        }
        return answer + bridge_length;
    }
}