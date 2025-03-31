import java.util.*;

class Solution {
    private class Record {
        String file;
        String head;
        int num;
        
        public Record(String file, String head, int num){
            this.file = file;
            this.head = head;
            this.num = num;
        }
    }
    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        Record[] record = new Record[files.length];
        
        for(int i=0; i<files.length; i++){
            String[] hn = findHead(files[i]);
            Record r = new Record(files[i], hn[0], Integer.parseInt(hn[1]));
            record[i] = r;
        }
        
        Arrays.sort(record, new Comparator<Record>(){
            @Override
            public int compare(Record a, Record b){
                if(a.head.equals(b.head)){
                    return a.num - b.num;
                } else {
                    return a.head.compareTo(b.head);
                }
            }
        });
                                  
        for(int i=0; i<files.length; i++){
            answer[i] = record[i].file;
        }
        return answer;
    }
    
    private String[] findHead(String str){
        int[] hn = new int[2];
        int i = 0;
        while(i<str.length() && (str.charAt(i)<'0' || str.charAt(i)>'9')){
            i++;
        }
        hn[0] = i;
        
        int j = i;
        int cnt = 0;
        while(j<str.length() && (str.charAt(j)>='0' && str.charAt(j)<='9')){
            // number는 최대 다섯 글자 연속된 숫자라서
            if(cnt == 5) break;
            j++;
            cnt++;
        }
        hn[1] = j;
        
        String head = str.substring(0, hn[0]);
		head = head.toLowerCase();
        String num = str.substring(hn[0], hn[1]);
        
        String[] shn = {head, num};
        return shn;
    }
}

// Arrays.sort, compare 오버라이딩