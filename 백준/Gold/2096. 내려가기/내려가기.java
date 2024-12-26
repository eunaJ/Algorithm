import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][3];
        int[] sum = new int[3];
        int[] preMaxArr = new int[3];
        int[] preMinArr = new int[3];
        int[] curMaxArr = new int[3];
        int[] curMinArr = new int[3];
        int[] input = new int[3];
        for(int i=0; i<n; i++){
            String[] sa = br.readLine().split(" ");
            input[0] = Integer.parseInt(sa[0]);
            input[1] = Integer.parseInt(sa[1]);
            input[2] = Integer.parseInt(sa[2]);
            if(i == 0){
                preMaxArr = input.clone();
                preMinArr = input.clone();
                curMaxArr = input.clone();
                curMinArr = input.clone();
            } else {
                curMaxArr[0] = Math.max(preMaxArr[0], preMaxArr[1]) + input[0];
                curMaxArr[2] = Math.max(preMaxArr[1], preMaxArr[2]) + input[2];
                int curMax = Math.max(preMaxArr[0], Math.max(preMaxArr[1], preMaxArr[2]));
                curMaxArr[1] = curMax + input[1];
                preMaxArr = curMaxArr.clone();

                curMinArr[0] = Math.min(preMinArr[0], preMinArr[1]) + input[0];
                curMinArr[2] = Math.min(preMinArr[1], preMinArr[2]) + input[2];
                int curMin = Math.min(preMinArr[0], Math.min(preMinArr[1], preMinArr[2]));
                curMinArr[1] = curMin + input[1];
                preMinArr = curMinArr.clone();
            }
        }
        int max = Math.max(preMaxArr[0], Math.max(preMaxArr[1], preMaxArr[2]));
        int min = Math.min(preMinArr[0], Math.min(preMinArr[1], preMinArr[2]));
        System.out.println(max + " " + min);
    }
}