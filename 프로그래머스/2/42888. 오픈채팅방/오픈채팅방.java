import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        HashMap<String, String> hm = new HashMap<>();
        ArrayList<String> result = new ArrayList<>();
        for(int i=0; i<record.length; i++){
            String[] sa = record[i].split(" ");
            if(sa[0].equals("Enter")){
                result.add(sa[1] + "님이 들어왔습니다.");
                hm.put(sa[1], sa[2]);
            } else if(sa[0].equals("Leave")){
                result.add(sa[1] + "님이 나갔습니다.");
            } else if(sa[0].equals("Change")){
                hm.put(sa[1], sa[2]);
            }
        }
        // 닉네임으로 변경
        for(int i=0; i<result.size(); i++){
            String[] sa = result.get(i).split("님이 ");
            String id = sa[0];
            String action = sa[1];
            result.set(i, hm.get(id) + "님이 "+ action);
        }
        String[] answer = new String[result.size()];
        for(int i=0; i<result.size(); i++){
            answer[i] = result.get(i);
        }
        return answer;
    }
}