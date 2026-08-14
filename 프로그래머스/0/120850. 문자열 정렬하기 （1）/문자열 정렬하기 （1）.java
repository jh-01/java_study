class Solution {
    public int[] solution(String my_string) {
        int[] num = new int[10];
        int n = my_string.length();
        int count = 0;
        
        for(int i = 0; i < n; i++){
            char c = my_string.charAt(i);
            if(c >= '0' && c <= '9'){
                num[c - '0']++;
                count++;
            }
        }
        
        int[] answer = new int[count];
        int j = 0;
        for(int i = 0; i <= 9; i++){
            while(num[i]-- > 0){
                answer[j++] = i;
            }
        }
        
        return answer;
    }
}