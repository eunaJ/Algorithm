class Solution {
    boolean solution(String s) {
        s = s.toLowerCase();
        int p = 0;
        int y = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == 'p') p++;
            else if(s.charAt(i) == 'y') y++;
        }
        return p == y ? true : false;
    }
}

//
// if (s.charAt(i) == 'p')
//     count++;
// else if (s.charAt(i) == 'y')
//     count--;

// if (count == 0)
//     return true;
// else
//     return false;
