class Solution {
    public long solution(int w, int h) {
        long answer = (long)w * h;
        long g = w + h - gcd(w, h);
        return answer - g;
    }
    
    private long gcd(int x, int y){
        int minN = Math.min(x, y);
        for(int i = minN; i > 0; i--){
            if(x % i == 0 && y % i == 0){
                return i;
            }
        }
        
        return -1;
    }
}