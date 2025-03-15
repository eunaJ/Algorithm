import java.util.*;

class Solution {
    public int[] solution(String s) {
        ArrayList<Integer> result = new ArrayList<>();
        s = s.substring(2, s.length()-2).replace("},{", "-");
        String[] sa = s.split("-");
        Arrays.sort(sa, (o1, o2)->{
            return o1.length() - o2.length();
        });
        for(int i=0; i<sa.length; i++){
            String[] tmp = sa[i].split(",");
            for(int j=0; j<tmp.length; j++){
                int n = Integer.parseInt(tmp[j]);
                if(!result.contains(n)){
                    result.add(n);
                }
            }
        }
        
        int[] answer = new int[result.size()];
        for(int i=0; i<result.size(); i++){
            answer[i] = result.get(i).intValue();
        }
        return answer;
    }
}

// int[] arr = li.stream().mapToInt(i->i).toArray();