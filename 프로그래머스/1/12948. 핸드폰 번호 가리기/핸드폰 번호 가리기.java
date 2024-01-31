import java.lang.StringBuilder;
class Solution {
    public String solution(String phone_number) {
        StringBuilder answer = new StringBuilder(phone_number);
        int l = phone_number.length() - 4;
        for(int i=0; i<l; i++){
            answer = answer.replace(i, i+1, "*");
        }
        return String.valueOf(answer);
    }
}

//
// for(int i = 0; i < ch.length - 4; i ++){
//      ch[i] = '*';
//  }
//  return String.valueOf(ch);
