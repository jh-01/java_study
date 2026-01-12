import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long minT = 1;
        long maxT = (long) Arrays.stream(times).max().getAsInt() * n;
        long answer = 0;
        
        while(minT <= maxT){
            long midT = (minT + maxT) / 2;
            long sum = 0;
            for(int t : times){
                sum += midT / t;
                if(sum >= n) break;
            }
            
            if(sum >= n) {
                answer = midT;
                maxT = midT - 1;
            } else{
                minT = midT + 1;
            }
            
        }
        
        return answer;
    }
}