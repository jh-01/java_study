import java.util.*;

class Solution {
    public int solution(int[] array, int n) {
        int answer = Integer.MAX_VALUE;
        int diff = Integer.MAX_VALUE;
        
        Arrays.sort(array);
        for(int i = array.length - 1; i >= 0; i--){
            int temp = Math.abs(n - array[i]);
            if(diff >= temp){
                diff = temp;
                answer = array[i];
            }
        }
        return answer;
    }
}