import java.util.stream.*;

class Solution {
    public int solution(int[] numbers) {
        int sum = 0;
        int[] arr = IntStream.range(1, 10).toArray();
        for(int i = 0; i < numbers.length; i++){
            if(numbers[i] == 0) continue;
            else arr[numbers[i] - 1] = 0;
        }
        for (int num : arr) {
            sum += num;
        }
        return sum;
    }
}