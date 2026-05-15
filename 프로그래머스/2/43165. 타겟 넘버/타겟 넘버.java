class Solution {
    private int answer = 0;
    
    public int solution(int[] numbers, int target) {
        dfs(0, 0, numbers, target);
        return answer;
    }
    
    private void dfs(int x, int sum, int[] numbers, int target){
        if(x == numbers.length){
            if(sum == target){
                answer++;
            }
            
            return;
        }
        
        dfs(x + 1, sum + numbers[x], numbers, target);
        dfs(x + 1, sum - numbers[x], numbers, target);
        
    }
}