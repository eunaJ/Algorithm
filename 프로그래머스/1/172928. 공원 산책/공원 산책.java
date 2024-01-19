class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        int h = park.length;
        int w = park[0].length();
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                if(park[i].substring(j, j+1).equals("S")){
                    answer[0] = i;
                    answer[1] = j;
                }
            }    
        }
        for(int i=0; i<routes.length; i++){
            String d = routes[i].substring(0,1);
            int n = Integer.parseInt(routes[i].substring(2));
            int r = answer[0];
            int c = answer[1];
            boolean b = true;
            if(d.equals("N")){
                for(int j=1; j<=n; j++){
                    r--;
                    if(r < 0){ 
                        b = false;
                        break;
                    }
                    if(park[r].charAt(c) == 'X'){
                        b = false;
                        break;
                    }
                }
                if(b) answer[0] = r;
            }
            else if(d.equals("S")){
                for(int j=1; j<=n; j++){
                    r++;
                    if(r >= h){ 
                        b = false;
                        break;
                    }
                    if(park[r].charAt(c) == 'X'){
                        b = false;
                        break;
                    }
                }
                if(b) answer[0] = r;
            }
            else if(d.equals("E")){ 
                for(int j=1; j<=n; j++){
                    c++;
                    if(c >= w){	
                        b = false;
                        break;
                    }
                    else if(park[r].charAt(c) =='X'){
                        b = false;
                        break;
                    }          
                }
                if (b) {
                    answer[1] = c;
                }
            }
            else if(d.equals("W")){
                for(int j=1; j<=n; j++){
                    c--;
                    if(c < 0){
                        b = false;
                        break;
                    }
                    else if(park[r].charAt(c) =='X'){
                        b = false;
                        break;
                    }    
                }
                if (b) {
                        answer[1] = c;
                }
            }
        }
        return answer;
    }
}