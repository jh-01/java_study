class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        boolean[][] isWon = new boolean[n + 1][n + 1];
        int[] dp = new int[n + 1];
        
        // 이긴 여부 세기
        for(int[] result : results){
            isWon[result[0]][result[1]] = true;
        }

        for(int k = 1; k <= n; k++){
            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= n; j++){
                    if(isWon[i][k] && isWon[k][j]){
                        isWon[i][j] = true;   
                    }
                }
            }
        }
        
        for(int i = 1; i <= n; i++){
            int cnt = 0;
            for(int j = 1; j <= n; j++){
                if(isWon[i][j] || isWon[j][i]){
                    cnt++;
                }
            }
            if(cnt == n - 1){
                answer++;
            }
        }
        
        return answer;
    }
}