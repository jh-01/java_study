import java.util.*;

class Solution {
    private int min = 100;
    private boolean[] visited;
    private List<int[]> list = new LinkedList<>();
    
    private int dfs(int start, int a, int b){
        visited[start] = true;
        int cnt = 1;
        
        // 연결된 간선들 개수 세기
        for(int i = 0; i < list.size(); i++){
            int[] temp = list.get(i);
            int next;
            
            if(temp[0] == start) next = temp[1];
            else if(temp[1] == start) next = temp[0];
            else continue;
            
            if((start == a && next == b) || (start == b && next == a)){
                continue;
            }
            
            if(!visited[next]) {
                cnt += dfs(next, a, b);
            }
        }
        return cnt;
    }
    
    public int solution(int n, int[][] wires) {
        for(int i = 0; i < wires.length; i++){
            list.add(new int[]{wires[i][0], wires[i][1]});
        }
        
        for(int i = 0; i < wires.length; i++){
            visited = new boolean[n + 1];
            int count = dfs(1, wires[i][0], wires[i][1]);
            int diff = Math.abs(n - 2 * count);
            min = Math.min(min, diff);
        }
        return min;
    }
}