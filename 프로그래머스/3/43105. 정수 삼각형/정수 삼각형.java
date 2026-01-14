class Solution {
    public int solution(int[][] triangle) {
        int N = triangle.length;
        int M = triangle[N-1].length;
        int[][] tree = new int[N][M];
        
        tree[0][0] = triangle[0][0];
        for(int i = 1; i < N; i++){
            for(int j = 0; j < triangle[i].length; j++){
                // 가장 왼쪽
                if(j == 0) tree[i][j] = tree[i-1][0] + triangle[i][0];
                // 가장 오른쪽
                else if(j == triangle[i].length - 1){
                    tree[i][j] = tree[i-1][j-1] + triangle[i][j];
                } else {
                    tree[i][j] = Math.max(tree[i-1][j-1] + triangle[i][j], tree[i-1][j] + triangle[i][j]);
                }
            }
        }
        
        int maxNum = 0;
        for(int i = 0; i < M; i++){
            if(tree[N - 1][i] > maxNum) maxNum = tree[N - 1][i];
        }
        
        return maxNum;
    }
}