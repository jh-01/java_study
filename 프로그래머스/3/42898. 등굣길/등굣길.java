class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        
        // 물웅덩이
        boolean[][] isFlooded = new boolean[n][m];
        for(int i = 0; i < puddles.length; i++){
            isFlooded[puddles[i][1] - 1][puddles[i][0] - 1] = true;
        }
        
        int[][] dp = new int[n][m];
        dp[0][0] = 1;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                // 시작점
                if(i == 0 && j == 0) continue;
                // 물에 잠긴 경우
                if(isFlooded[i][j]){
                    dp[i][j] = 0;
                    continue;
                }
                
                // i가 0이면 오른쪽에서 오는 것만 
                if(i == 0) dp[i][j] = dp[i][j-1] % 1000000007;
                // j가 0이면 위에서 오는 것만
                else if(j == 0) dp[i][j] = dp[i-1][j] % 1000000007;
                // 둘 다 아니면 오른쪽에서 오는 경우 + 위에서 오는 경우
                else dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % 1000000007;
            }
        }
                
        return dp[n-1][m-1];
    }
}