import java.util.*;
class Solution {
    public String[] solution(String myStr) {
        String[] s = myStr.split("a|b|c");
        List<String> list = new ArrayList<>(Arrays.asList(s));
        list.removeAll(Arrays.asList(""));
        if (list.isEmpty()) return new String[]{"EMPTY"};
        else return list.toArray(new String[list.size()]);
    }
}