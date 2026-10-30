class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        int x = Math.min(a, b);
        int y = Math.max(a, b);
        for(int i = x; i <= y; i++){
            answer += i;
        }
        return answer;
    }
}