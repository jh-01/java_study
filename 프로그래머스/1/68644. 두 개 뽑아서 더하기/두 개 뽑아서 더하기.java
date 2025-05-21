import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[] solution(int[] numbers) {
        List<Integer> sumNum = new ArrayList<Integer>();
        for(int i = 0; i < numbers.length - 1; i++){
            for(int j = i + 1; j < numbers.length; j++){
                if(!sumNum.contains(numbers[i] + numbers[j])) 
                    sumNum.add(numbers[i] + numbers[j]);
            }
        }
        int[] answer = sumNum.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(answer);
        return answer;
    }
}