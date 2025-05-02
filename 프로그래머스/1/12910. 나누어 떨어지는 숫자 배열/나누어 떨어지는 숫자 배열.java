import java.util.stream.*;
import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        int[] answer = Arrays.stream(arr)
            .filter(a -> a % divisor == 0)
            .sorted()
            .toArray();
        if(answer.length == 0) {
            int[] noElement = {-1};
            return noElement;
        }
        return answer;
    }
}