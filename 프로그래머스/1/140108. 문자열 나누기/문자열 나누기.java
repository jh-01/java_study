class Solution {
    public int solution(String s) {
        if(s.length() == 1) return 1;
        int answer = 0;
        char x = s.charAt(0);
        int xCount = 1;
        char y;
        int yCount = 0;

        int index = 1;
        while(index < s.length()){
            if(index == s.length() - 1 || index == s.length()){
                answer++;
                break;
            }
            y = s.charAt(index++);
            if(x != y) yCount++;
            else xCount++;
            
            if(xCount != 0 && xCount == yCount){
                xCount = 1;
                yCount = 0;
                answer++;
                if(index == s.length() - 1){
                    answer++;
                    break;
                }
                x = s.charAt(index++);
            }
        }
        return answer;
    }
}