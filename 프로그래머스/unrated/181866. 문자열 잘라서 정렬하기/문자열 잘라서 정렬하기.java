import java.util.*;
class Solution {
    public String[] solution(String myString) {
        String[] answer = myString.split("x");
        Arrays.sort(answer);
        List<String> list = new ArrayList<String>(Arrays.asList(answer));
        list.removeAll(Arrays.asList(""));
        return list.toArray(new String[list.size()]);
    }
}