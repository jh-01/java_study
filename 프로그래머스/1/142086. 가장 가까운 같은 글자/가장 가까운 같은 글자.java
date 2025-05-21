class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        answer[0] = -1;
        
        for(int i = 1; i < s.length(); i++){
            char x = s.charAt(i);
            String prev = s.substring(0, i);
            if(prev.indexOf(x) == -1) answer[i] = -1;
            else answer[i] = i - prev.lastIndexOf(x);
        }
        return answer;
    }
}