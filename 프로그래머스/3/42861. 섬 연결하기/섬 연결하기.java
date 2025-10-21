import java.util.Arrays;

class Solution {
    
    static int[] head = new int[101];
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        int count = 0;
        
        // HEAD 배열 초기화
        for(int i = 0; i < n; i++){
            head[i] = i;
        }
        
         // 마지막 숫자 기준으로 오름차순 정렬
        Arrays.sort(costs, (a, b) -> Integer.compare(a[2], b[2]));

        int i = 0;
        while(count < n - 1 && i < costs.length){
            int a = costs[i][0];
            int b = costs[i][1];
            
            if(find(a) != find(b)){
                union(a, b);
                answer += costs[i][2];
                count++;
            }
            i++;
        }
        return answer;
    }
    
    private int find(int x){
        if(head[x] == x) return x;
        return head[x] = find(head[x]);
    }
    
    private void union(int a, int b){
        int aHead = find(a);
        int bHead = find(b);
        
        if(aHead != bHead) {
            head[bHead] = aHead;
        }
    }
}