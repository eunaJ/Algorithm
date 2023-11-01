class Solution {
    public int solution(int n, String control) {
        for(int i=0; i<control.length(); i++){
            String s = control.substring(i, i+1);
            if(s.equals("w")) n++;
            else if(s.equals("s")) n--;
            else if(s.equals("d")) n+=10;
            else if(s.equals("a")) n-=10;
        }
        return n;
    }
}