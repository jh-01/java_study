import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer1 = {1, 2, 3, 4, 5};
        int[] answer2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] answer3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] count = new int[3];
        
        for(int i = 0; i < answers.length; i++){
            if(answers[i] == answer1[i % answer1.length]) count[0]++;
            if(answers[i] == answer2[i % answer2.length]) count[1]++;
            if(answers[i] == answer3[i % answer3.length]) count[2]++;
        }
        
        int maxNum = count[0];
        List<Integer> maxCount = new ArrayList<>();
        maxCount.add(1);
        for(int i = 1; i < 3; i++){
            if(count[i] > maxNum) {
                maxCount.clear();
                maxNum = count[i];
                maxCount.add(i + 1);
            }
            else if(count[i] == maxNum) {
                maxCount.add(i + 1);
            }
        }
        
        return maxCount.stream().mapToInt(i -> i).toArray();
    }
}