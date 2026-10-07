class Solution {
    public long solution(int w, int h) {
        long count = w + h - gcd(w, h);
        return (long) w * h - count;
    }
    
    private long gcd(int x, int y){
        if(y == 0) return x;
        else return gcd(y, x % y);
    }
}