class Solution {
    public int solution(String my_string) {
        int answer = 0;
        
        for(int i = 0; i < my_string.length(); i++){
            char temp = my_string.charAt(i);
            if(temp >= '0' && temp <= '9'){
                answer += temp - '0';
            }
        }
        return answer;
    }
}