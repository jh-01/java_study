import java.util.*;

class Solution {
    public int solution(int[] money) {
        int n = money.length;
        
        if(n == 1){
            return money[0];
        } else if(n == 2){
            return Math.max(money[0], money[1]);
        }

        // 첫번째집 포함
        int[] withFirst = new int[n - 1];
        // 첫번째집 포함 x
        int[] withoutFirst = new int[n - 1];
        
        // 초기화
        withFirst[0] = money[0];
        withFirst[1] = Math.max(money[0], money[1]);
        withoutFirst[0] = money[1];
        withoutFirst[1] = Math.max(money[1], money[2]);

        for(int i = 2; i < n - 1; i++){
            withFirst[i] = Math.max(withFirst[i - 1], money[i] + withFirst[i - 2]);
            withoutFirst[i] = Math.max(withoutFirst[i - 1], money[i + 1] + withoutFirst[i - 2]);
        }
        
        return Math.max(withFirst[n - 2], withoutFirst[n-2]);
    }
}