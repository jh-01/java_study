import java.util.stream.*;

class Solution {
    public String solution(int[] food) {
        String firstPlayer = "";
        for(int i = 1; i < food.length; i++){
            String newFood = Integer.toString(i);
            firstPlayer += newFood.repeat(food[i]/2);
        }
        StringBuffer sb = new StringBuffer(firstPlayer);
        String secondPlayer = sb.reverse().toString();
        String answer = firstPlayer + "0" + secondPlayer;
        return answer;
    }
}