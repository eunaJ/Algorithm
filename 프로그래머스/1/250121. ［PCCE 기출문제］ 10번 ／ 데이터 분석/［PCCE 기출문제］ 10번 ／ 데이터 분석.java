import java.util.*;
class Solution {
    LinkedList<int[]> result;
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        result = new LinkedList<>();
        int o = 0;
        if(ext.equals("date")) o = 1;
        else if(ext.equals("maximum")) o = 2;
        else if(ext.equals("remain")) o = 3;
        orderBy(data, val_ext, o);
        int[][] answer = result.toArray(new int[0][]);
        int n = 0;
        if(sort_by.equals("date")) n = 1;
        else if(sort_by.equals("maximum")) n = 2;
        else if(sort_by.equals("remain")) n = 3;
        final int index = n; // 람다식 컴파일 위해
        Arrays.sort(answer, (o1, o2) -> Integer.compare(o1[index], o2[index]));
        return answer;
    }
    
    public void orderBy(int[][] data, int val_ext, int o){
        for(int i=0; i<data.length; i++){
            if(data[i][o] < val_ext){
                result.add(data[i]);
            }
        }
    }
}