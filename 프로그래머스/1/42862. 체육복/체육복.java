
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] counts = new int[n];
        
        for(int i = 0; i < n; i++) counts[i] = 1;
        for(int i = 0; i < lost.length; i++) counts[lost[i] - 1]--;
        for(int i = 0; i < reserve.length; i++) counts[reserve[i] - 1]++;
        
        for(int i = 0; i < n; i++){
            if(i == 0){
                if(counts[i] == 0 && counts[i + 1] > 1){
                    counts[i]++;
                    counts[i + 1]--;
                }
            } else if(i == n - 1){
                if(counts[i] == 0 && counts[i - 1] > 1){
                    counts[i]++;
                    counts[i - 1]--;
                }
            } else {
                if(counts[i] == 0 && counts[i - 1] > 1){
                    counts[i]++;
                    counts[i - 1]--;
                }
                if(counts[i] == 0 && counts[i + 1] > 1){
                    counts[i]++;
                    counts[i + 1]--;
                }
            }
        }
        
        int count = 0;
        for(int i = 0; i < n; i++){
            if(counts[i] >= 1) count++;
        }
        return count;
    }
}