class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        String str = s;
        int len = s.length();
        while(true){
            if(len < 1){
                break;
            }
            for(int i=0; i<str.length(); i++){
                if(str.charAt(i) == '0'){
                    answer[1]++;
                }
            }
            str = str.replaceAll("0", "");
            len = str.length();
            str = Integer.toString(len, 2);
            answer[0]++;
            if(len == 1) break;
        }
        return answer;
    }
}