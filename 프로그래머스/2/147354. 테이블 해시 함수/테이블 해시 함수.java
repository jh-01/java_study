import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int[] results = new int[data.length];
        
        Arrays.sort(data, (a, b) -> {
            if(a[col - 1] != b[col - 1]){
                return a[col - 1] - b[col - 1];
            } else {
                return b[0] - a[0];
            }
        });
        
        for(int i = 1; i <= data.length; i++){
            for(int j = 0; j < data[i - 1].length; j++){
                results[i - 1] += data[i - 1][j] % i;
            }
        }
        
        int result = 0;
        for(int i = row_begin - 1; i < row_end; i++){
            result = result ^ results[i];
        }
        
        return result;
    }
}