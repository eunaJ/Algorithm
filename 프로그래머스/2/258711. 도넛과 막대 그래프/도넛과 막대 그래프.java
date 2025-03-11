import java.util.*;

class Solution {
    public int[] solution(int[][] edges) {
        Map<Integer, Integer> in = new HashMap<>();
        Map<Integer, Integer> out = new HashMap<>();
        int newNode = -1;
        int donut = 0;
        int bar = 0;
        int eight = 0;
        for(int[] e : edges){
            in.put(e[1], in.getOrDefault(e[1], 0) + 1);
            out.put(e[0], out.getOrDefault(e[0], 0) + 1);
        }
        for(int node : out.keySet()){
            if(out.get(node) > 1){
                // 나가 2개 이상, 들어 없 : 추가 생성
                if(!in.containsKey(node)) newNode = node;
                // 나가 2개 이상, 들어 1개 이상 : 8자모양 가운데 정점
                else eight++;
            }
        }
        // 나가 없 : 막대 그래프 마지막 정점
        for(int node : in.keySet()){
            if(!out.containsKey(node)) bar++;
        }
        donut = out.get(newNode) - bar - eight;
        int[] answer = {newNode, donut, bar, eight};
        return answer;
    }
}