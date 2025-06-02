class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int numsLength = nums.length;
        boolean[] isPrime = new boolean[3001];
        
        for(int i = 2; i <= 3000; i++){
            isPrime[i] = true;
        }
        
        for (int i = 2; i <= 3000; i++) {
            if(isPrime[i]) {
                for (int j = i * 2; j <= 3000; j += i) {
                    isPrime[j] = false;
                }	
            }
        }
        
        for(int i = 0; i < numsLength - 2; i++){
            for(int j = i + 1; j < numsLength - 1; j++){
                for(int k = j + 1; k < numsLength; k++){
                    if(isPrime[nums[i] + nums[j] + nums[k]]){
                        answer++;
                    }
                }
            }
        }
        return answer;
    }
}