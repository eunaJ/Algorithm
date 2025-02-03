import java.util.*;
import java.io.*;

class Main {
    public static int[][] map;
    public static ArrayList<int[]> li;
    public static boolean b = false;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new int[9][9];
        li = new ArrayList<>(); // 채워야 하는 부분(0) 저장
        for(int i=0; i<9; i++){
            String s = br.readLine();
            for(int j=0; j<9; j++){
                map[i][j] = s.charAt(j) - '0';
                if(map[i][j] == 0) li.add(new int[]{i, j});
            }
        }
        sudoku(0);
    }

    private static void sudoku(int l){
        if(b) return;
        
        if(li.size() == l){
            for(int i=0; i<9; i++){
                for(int j=0; j<9; j++){
                    System.out.print(map[i][j]);
                }
                System.out.println();
            }
            b = true;
            return;
        }

        int y = li.get(l)[0];
        int x = li.get(l)[1];
        boolean[] check = new boolean[10]; // 이미 쓰인 숫자 체크
        // 가로, 세로
        for(int i=0; i<9; i++){
            if(map[y][i] != 0) check[map[y][i]] = true;
            // if(map[i][x] != 0) check[map[i][x]] = true;
        }
        for(int i=0; i<9; i++){
            if(map[i][x] != 0) check[map[i][x]] = true;
        }
        // 네모
        int sy = (y/3)*3; // 좌상단
        int sx = (x/3)*3;
        for(int i=sy; i<sy+3; i++){
            for(int j=sx; j<sx+3; j++){
                if(map[i][j] != 0) check[map[i][j]] = true;
            }
        }

        for(int i=1; i<=9; i++){
            if(!check[i]){
                map[y][x] = i;
                sudoku(l+1);
                map[y][x] = 0;
            }
        }
    }
}