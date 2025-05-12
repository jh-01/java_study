class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        
        if(m % n == 0) {
            answer[0] = n; 
            answer[1] = m;
        }
        else {
            answer[0] = getGcd(n, m);
            answer[1] = n * m / answer[0];
        }
        return answer;
    }
    
    private int getGcd(int x, int y){
        if(x % y == 0) return y;
        return getGcd(y, x % y);
    }
}