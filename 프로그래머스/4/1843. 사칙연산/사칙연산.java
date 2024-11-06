import java.util.*;
class Solution {
    int[][] min, max;
    public int solution(String arr[]) {
        int size = arr.length / 2 + 1;
        min = new int[size][size];
        max = new int[size][size];
        int[] list = new int[size];
        // 연산자에 따른 초기 작업
        for(int i=0; i<arr.length; i+=2){
            int num = Integer.parseInt(arr[i]);
            if(i == 0){
                list[i/2] = num;
            } else {
                list[i/2] = arr[i-1].equals("+") ? num : -num;
            }
        }
        // 구간 내 최대 최소
        for(int i=size-1; i>=0; i--){ // 더 작은 구간이 먼저 채워지도록
            for(int j=i; j<size; j++){
                if(i == j){
                    min[i][j] = list[i];
                    max[i][j] = list[i];
                } else {
                    min[i][j] = Integer.MAX_VALUE;
                    max[i][j] = Integer.MIN_VALUE;
                    // k는 분할 가능 지점
                    for(int k=i; k<j; k++){ 
                        boolean value = k == i ? true : false; 
                        // (i, k), (k+1, j) 부분 중 선택
                        cal(min[i][k], min[k+1][j], i, j, value);
                        cal(min[i][k], max[k+1][j], i, j, value);
                        cal(max[i][k], min[k+1][j], i, j, value);
                        cal(max[i][k], max[k+1][j], i, j, value);
                    }
                }
            }
        }
        return max[0][size-1];
    }
    
    // 연산
    public void cal(int a, int b, int x, int y, boolean value) {
        if (value && a < 0) {
            min[x][y] = Math.min(min[x][y], Math.min(a-b,a+b));
            max[x][y] = Math.max(max[x][y], Math.max(a-b,a+b));
        } else {
            min[x][y] = Math.min(min[x][y], a+b);
            max[x][y] = Math.max(max[x][y], a+b);
        }           
    }
}