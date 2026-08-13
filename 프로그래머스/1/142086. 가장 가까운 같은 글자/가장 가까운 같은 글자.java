class Solution {
    public int[] solution(String s) {
        int n = s.length();
        int[] answer = new int[n];
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < n; i++){
            String temp = s.substring(i, i + 1);
            int j = sb.lastIndexOf(temp);
            
            if(j == -1){
                answer[i] = j;
            } else {
                answer[i] = i - sb.lastIndexOf(temp);
            }
            sb.append(temp);
        }
        
        return answer;
    }
}