class Solution {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        int n = 0;
        for(int i=0; i<number.length()-k; i++) {
            char m = '0';
            for(int j=n; j<=k+i; j++){ 
                if(number.charAt(j) > m){
                    m = number.charAt(j);
                    n = j + 1;
                }
            }
            answer.append(m);
        }
        return answer.toString();
    }
}

// String -> StringBuilder로 변경만 했는데도 시간초과 해결
