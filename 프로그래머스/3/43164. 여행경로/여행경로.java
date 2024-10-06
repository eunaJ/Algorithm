import java.util.*;
class Solution {
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        List<String> li = new ArrayList<>();
        dfs("ICN", tickets, new boolean[tickets.length], li, "ICN", 0);
        Collections.sort(li);
        answer = li.get(0).split(" ");
        return answer;
    }
    
    public void dfs(String now, String[][] tickets, boolean[] visited, List<String> li, String route, int c){
        if(c == tickets.length) {
            li.add(route);
            return;
        }
        for(int i=0; i<tickets.length; i++){
            if(now.equals(tickets[i][0]) && !visited[i]){
                visited[i] = true;
                dfs(tickets[i][1], tickets, visited, li, route + " " + tickets[i][1], c+1);
                visited[i] = false;
            }
        }
    }
}