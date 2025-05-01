class Solution {
    public String solution(String[] seoul) {
        int location = -1;
        for(int i = 0; i < seoul.length; i++){
            if(seoul[i].equals("Kim")) location = i;
        }
        String answer = "김서방은 " + location + "에 있다";
        return answer;
    }
}