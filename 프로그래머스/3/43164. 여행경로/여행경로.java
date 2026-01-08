import java.util.*;

class Solution {
    private int N;
    private String[] answer;
    private boolean[] visited;
    private boolean finished = false;
    
    private void dfs(String cur, String[][] tickets, Map<String, List<Integer>> map, List<String> path, int num){
        if(num == N) {
            answer = path.toArray(new String[0]);
            finished = true;
            return;
        }
        
        if (!map.containsKey(cur)) return;

        // 인접한 노드 방문
        List<Integer> lists = map.get(cur);
        
        for (int idx : map.get(cur)) {
            if (!visited[idx]) {
                visited[idx] = true;
                path.add(tickets[idx][1]);

                dfs(tickets[idx][1], tickets, map, path, num + 1);

                if (finished) return;

                visited[idx] = false;
                path.remove(path.size() - 1);
            }
        }
    }
    
    public String[] solution(String[][] tickets) {
        N = tickets.length;
        answer = new String[N + 1];
        visited = new boolean[N];
        Map<String, List<Integer>> map = new HashMap<>();
        
        // 알파벳 순 정렬
        Arrays.sort(tickets, (a, b) -> {
            if (a[0].equals(b[0])) return a[1].compareTo(b[1]);
            return a[0].compareTo(b[0]);
        });

        for(int i = 0; i < N; i++){
            map.putIfAbsent(tickets[i][0], new ArrayList<>());
            map.get(tickets[i][0]).add(i);
        }
        
        List<String> path = new ArrayList<>();
        path.add("ICN");
        
        dfs("ICN", tickets, map, path, 0);
        
        return answer;
    }
}