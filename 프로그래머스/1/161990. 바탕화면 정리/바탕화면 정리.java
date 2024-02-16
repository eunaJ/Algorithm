class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        answer[0] = -1;
        answer[1] = 51;
        for(int i=0; i<wallpaper.length; i++){
            int t1 = wallpaper[i].indexOf("#");
            int t2 = wallpaper[i].lastIndexOf("#");
            if(t1 != -1){
                if(answer[0] == -1) answer[0] = i;
                answer[1] = Math.min(answer[1], t1);
                answer[2] = Math.max(answer[2], i+1);
                answer[3] = Math.max(answer[3], t2+1);
            }           
        }
        return answer;
    }
}