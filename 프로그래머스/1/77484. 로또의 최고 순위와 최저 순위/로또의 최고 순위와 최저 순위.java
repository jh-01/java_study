class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int zeroCount = 0;
        int sameCount = 0;
        
        for(int i = 0; i < lottos.length; i++){
            if(lottos[i] == 0) zeroCount++;
            else {
                for(int j = 0; j < win_nums.length; j++){
                    if(lottos[i] == win_nums[j]){
                        sameCount++;
                        break;
                    }
                }
            }
        }
        int[] answer = {
            7 - (sameCount + zeroCount) > 6 ? 6 : 7 - (sameCount + zeroCount), 
            7 - (sameCount) > 6 ? 6 : 7 - (sameCount)
            };
        return answer;
    }
}