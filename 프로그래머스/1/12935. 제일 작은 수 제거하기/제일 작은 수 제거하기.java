import java.util.stream.*;

class Solution {
    public int[] solution(int[] arr) {
        int[] answer = null;
        if(arr.length == 1) answer = new int[] {-1};
        else {
            int minNum = Integer.MAX_VALUE;
            int index = -1;
            for(int i = 0; i < arr.length; i++){
                if(arr[i] < minNum) {
                    minNum = arr[i];
                    index = i;
                }
            }
            final int min = minNum;
            answer = IntStream.of(arr).filter(num -> num != min).toArray();
        }
        return answer;
    }
}