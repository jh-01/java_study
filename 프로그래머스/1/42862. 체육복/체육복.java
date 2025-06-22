import java.util.Arrays;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {    
        int answer = n;
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        for(int i = 0; i < reserve.length; i++){
            for(int j = 0; j < lost.length; j++){
                if (reserve[i] == -1 || lost[j] == -1) continue;
                if(reserve[i] == lost[j]) {
                    reserve[i] = -1;
                    lost[j] = -1;
                    break;
                }
            }
        }
        
        for (int l : lost) {
            if (l != -1) answer--;
        }


        for(int i = 0; i < lost.length; i++){
            for(int j = 0; j < reserve.length; j++){
                if(reserve[j] == -1 || lost[i] == -1) continue;
                if(reserve[j] - 1 == lost[i] || reserve[j] + 1 == lost[i]){
                    lost[i] = -1;
                    reserve[j] = -1;
                    answer++;
                    break;
                }
            }
        }
        return answer;
    }
}