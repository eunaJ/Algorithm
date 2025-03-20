class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        String tmp = "";
        // 전체 값 저장
        for(int i=0; tmp.length()<t*m; i++){
            tmp += Integer.toString(i, n);
        }
        // 원하는 순번만 따로 저장
        for(int i=p-1; answer.length()<t; i+=m){
            answer += tmp.charAt(i);
        }
        return answer.toUpperCase();
    }
}