class Solution {
    public String solution(int a, int b) {
        String[] week = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
        int[] monthday = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int sum = 0;

        for(int i = 0; i < a; i++){
            if(i < a - 1){
                sum += monthday[i];
            }
            else {
                sum += b - 1;
            }
        }
        return week[sum %= 7];
    }
}