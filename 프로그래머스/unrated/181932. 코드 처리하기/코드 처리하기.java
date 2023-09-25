class Solution {
    public String solution(String code) {
        String ret = "";
        String t = "";
        int mode = 0;
        for(int idx=0; idx<code.length(); idx++){
            t = code.substring(idx, idx+1);
            if(mode == 0){
                if(!t.equals("1")){
                    if(idx%2 == 0){
                        ret += t;
                    }
                }
                else {
                    mode = 1;
                }
                
            }
            else{
                if(!t.equals("1")){
                    if(idx%2 == 1){
                        ret += t;
                    }
                }
                else {
                    mode = 0;
                }
            }
        }        
        
        if(ret.equals("")){
            ret = "EMPTY";
        }
        return ret;
    }
}