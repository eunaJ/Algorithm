import java.util.*;
class Solution {    
    public int[] solution(String[] genres, int[] plays) {
        Music[] m = new Music[genres.length];
        HashMap<String, Integer> hm = new HashMap<>();
        // 장르별 재생 수 계산
        for(int i=0; i<genres.length; i++){
            if(hm.containsKey(genres[i])){
                int t = hm.get(genres[i]);
                hm.put(genres[i], t+plays[i]);
            } else {
                hm.put(genres[i], plays[i]);
            }         
        }
        
        // 배열에 저장
        for(int j=0; j<genres.length; j++){
            Music music = new Music(hm.get(genres[j]), genres[j], plays[j], j);
            m[j] = music;
        }
        
        // 총재생수, 재생수, 인덱스 순 정렬
        Arrays.sort(m, (o1, o2) -> 
                    o2.sum != o1.sum ? o2.sum - o1.sum :
                    !o1.genres.equals(o2.genres) ? o1.genres.compareTo(o2.genres) :
                    o2.plays != o1.plays ? o2.plays - o1.plays : 
                    o1.index - o2.index
                   );
        
        // answer에 저장
        LinkedList<Integer> li = new LinkedList<>();
        int c = 0;
        String g = "";
        for(int k=0; k<m.length; k++){
            if(g.equals(m[k].genres)){
                if(c < 2) li.add(m[k].index);
                c++;
            } else {
                g = m[k].genres;
                li.add(m[k].index);
                c = 1;
            }
        }
        int[] answer = new int[li.size()];
        for(int i=0; i<li.size(); i++){
            answer[i] = li.get(i);
        }
        return answer;
    }
}

class Music {
    int sum;
    String genres;
    int plays;
    int index;

    public Music(int sum, String genres, int plays, int index) {
        this.sum = sum;
        this.genres = genres;
        this.plays = plays;
        this.index = index;
    }
}