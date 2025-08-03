import java.util.Map;
import java.util.HashMap;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = players;
        Map<String, Integer> playersIndex = new HashMap<>();

        for (int i = 0; i < players.length; i++) {
            playersIndex.put(players[i], i);
        }

        for(int i = 0; i < callings.length; i++){
            int index = playersIndex.get(callings[i]);
            if(index > 0){
                String temp = answer[index];
                answer[index] = answer[index - 1];
                answer[index - 1] = temp;  
                playersIndex.put(answer[index - 1], index - 1);
                playersIndex.put(answer[index], index);
            }
        }
        return answer;
    }
}