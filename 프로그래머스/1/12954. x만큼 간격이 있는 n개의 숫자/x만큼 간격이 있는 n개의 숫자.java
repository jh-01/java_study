class Solution {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        int i = 0;
        long temp = (long)x;
        while(i < n){
            answer[i++] = temp;
            temp += x;
        }
        return answer;
    }
}