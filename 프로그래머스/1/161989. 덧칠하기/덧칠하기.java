class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 1;
        
        int temp = 0;
        for(int i = 1; i < section.length; i++){
            if(section[temp] + m  - 1 >= section[i]) continue;
            else {
                temp = i;
                answer++;
            }
        }
        
        return answer;
    }
}