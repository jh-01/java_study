class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        int num1 = a > b ? b : a;
        int num2 = num1 == a ? b : a;
        for(int i = num1; i <= num2; i++){
            answer += i;
        }
        return answer;
    }
}