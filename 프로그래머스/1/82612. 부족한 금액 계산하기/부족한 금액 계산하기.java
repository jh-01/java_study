class Solution {
    public long solution(int price, int money, int count) {
        long totalPrice = 0;
        long answer = -1;
        
        for(int i = 1; i <= count; i++){
            totalPrice += (price * i);
        }
        answer = money - totalPrice;
        if(answer < 0) return answer * -1;
        else return 0;
    }
}