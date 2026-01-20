class Solution {
    private long getTime(int[] diffs, int[] times, int level){
        long timeCur = 0;
        long timePrev = 0;
        long totalTime = 0;
        
        for(int i = 0; i < diffs.length; i++){
            timeCur = times[i];
            
            if (diffs[i] <= level) {
                totalTime += timeCur;
            } else {
                long retry = diffs[i] - level;
                totalTime += (times[i - 1] + timeCur) * retry + timeCur;
            }
            
            // 이전 퍼즐의 소요 시간 구하기
            timePrev += timeCur;
        }
        return totalTime;
    }
    
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = Integer.MAX_VALUE;
        
        // 퍼즐 난이도 최댓값 구하기
        int left = 1;
        int right = 0;
        for (int d : diffs) {
            right = Math.max(right, d);
        }
        
        while(left <= right){
            int mid = (left + right) / 2;
            
            long totalTime = getTime(diffs, times, mid);
            if (totalTime <= limit) {
                answer = mid;
                right = mid - 1; // 더 낮은 level 가능
            } else {
                left = mid + 1; // level 더 높여야됨
            }
        }
        
        return answer;
    }
}