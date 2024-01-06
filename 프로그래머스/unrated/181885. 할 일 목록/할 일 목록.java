import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
class Solution {
    public String[] solution(String[] todo_list, boolean[] finished){
        List<String> list = new ArrayList<>(Arrays.asList(todo_list));
        for(int i=0; i<todo_list.length; i++){
            if(finished[i]){
                list.remove(todo_list[i]);
            }
        }      
        return list.toArray(new String[list.size()]);
    }
}