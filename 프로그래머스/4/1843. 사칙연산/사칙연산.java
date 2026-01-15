import java.util.*;

class Solution {
    public int solution(String arr[]) {
        int n = arr.length;
        int[][] maxDp = new int[n][n];
        int[][] minDp = new int[n][n];
        
        // 초기값 설정
        for(int i = 0; i < n; i++){
            Arrays.fill(maxDp[i], Integer.MIN_VALUE);
            Arrays.fill(minDp[i], Integer.MAX_VALUE);
        }
        
        // 하나짜리 구간
        for (int i = 0; i < n; i += 2) {
            int num = Integer.parseInt(arr[i]);
            maxDp[i][i] = num;
            minDp[i][i] = num;
        }
        
        // dp 연산
        for(int len = 3; len <= n; len+=2){
            for(int i = 0; i + len - 1 < n; i+=2){
                int j = len + i - 1;
                
                for(int k = i + 1; k < j; k+=2){
                    
                    int leftMax = maxDp[i][k - 1];
                    int leftMin = minDp[i][k - 1];
                    int rightMax = maxDp[k + 1][j];
                    int rightMin = minDp[k + 1][j];
                     
                    if(arr[k].equals("+")){
                        maxDp[i][j] = Math.max(maxDp[i][j], leftMax + rightMax);
                        minDp[i][j] = Math.min(minDp[i][j], leftMin + rightMin);
                    } else if(arr[k].equals("-")){
                        maxDp[i][j] = Math.max(maxDp[i][j], leftMax - rightMin);
                        minDp[i][j] = Math.min(minDp[i][j], leftMin - rightMax);
                    }
                }
            }
        }
        return maxDp[0][n - 1];
    }
}