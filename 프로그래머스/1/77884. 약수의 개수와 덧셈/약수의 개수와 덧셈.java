class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        for(int i = left; i <= right; i++){
            if(isEven(i)) answer += i;
            else answer -= i;
        }
        return answer;
    }

    private boolean isEven(int x){
        if(x == 1) return false;
        if(x == 2) return true;
        int count = 2;
        for(int i = 2; i < x; i++){
            if(x % i == 0) count++;
        }
        if(count % 2 == 0) return true;
        else return false;
    }
}