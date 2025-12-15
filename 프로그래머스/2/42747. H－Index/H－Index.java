import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        int result = 0;
        Integer[] arr = Arrays.stream(citations)
            .boxed().toArray(Integer[]::new);
        Arrays.sort(arr);
        
        for(int i = 0; i < arr.length; i++){
            int temp = arr[i];
            int remain = arr.length - i;
            if(temp >= remain) result = Math.max(result, remain);
        }
        return result;
    }
}