import java.util.Arrays;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";

        Integer[] nums = Arrays.stream(numbers)
            .boxed().toArray(Integer[]::new);
            
        Arrays.sort(nums, (a, b) -> {
            String ab = a + "" + b;
            String ba = b + "" + a;
            return ba.compareTo(ab);
        });
        
         // 0만 있는 경우 처리
        if (nums[0] == 0) return "0";
        
        for(int i = 0; i < numbers.length; i++){
            answer += nums[i];
        }
        return answer;
    }

}