class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for(int i=0; i<skill_trees.length; i++){
            // skill 제외 문자는 치환
            String tree = skill_trees[i].replaceAll("[^" + skill + "]", "");
            for(int j=0; j<skill.length()+1; j++){
                String s = skill.substring(0, j);
                if(tree.equals(s)){
                    answer++;
                    break;
                }
            }
        }
        return answer;
    }
}