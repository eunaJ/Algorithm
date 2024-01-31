import java.util.*;
class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        List<Integer> li = new ArrayList<>();
        for(int i=0; i<ingredient.length; i++) {
			li.add(ingredient[i]);
			while(li.size() >= 4) {
				int n = li.size();
				if(!(li.get(n-1) == 1 && li.get(n-2)==3 && li.get(n-3) ==2 && li.get(n-4)==1)) break;
				for(int j=0; j<4; j++) {
					li.remove(li.size() -1);
				}
				answer++;
			}
		}
        return answer;
    }
}

//
// int[] stack = new int[ingredient.length];
// int sp = 0;
// int answer = 0;
// for (int i : ingredient) {
//     stack[sp++] = i;
//     if (sp >= 4 && stack[sp - 1] == 1
// 	&& stack[sp - 2] == 3
// 	&& stack[sp - 3] == 2
// 	&& stack[sp - 4] == 1) {
// 	sp -= 4;
// 	answer++;
//     }
// }
