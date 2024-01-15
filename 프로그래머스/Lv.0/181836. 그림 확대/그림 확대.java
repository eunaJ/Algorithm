class Solution {
    public String[] solution(String[] picture, int k) {
        String[] answer = new String[k*picture.length];
        for(int i=0; i<picture.length; i++){
            String[] s = picture[i].split("");
            String p = "";
            for(int j=0; j<s.length; j++){
                p += s[j].repeat(k);
            } 
            for(int j=0; j<k; j++){
                answer[i*k+j] = p;
            }
        }        
        return answer;
    }
}