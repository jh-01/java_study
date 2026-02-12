import java.util.*;

class Solution {
    public int[] solution(int[][] edges) {
        int[] answer = new int[4];
        
        Map<Integer, Integer> in = new HashMap<>();
        Map<Integer, Integer> out = new HashMap<>();
        Set<Integer> nodes = new HashSet<>();
        
        for (int[] e : edges) {
            out.put(e[0], out.getOrDefault(e[0], 0) + 1);
            in.put(e[1], in.getOrDefault(e[1], 0) + 1);
            nodes.add(e[0]);
            nodes.add(e[1]);
        }
        
        // 생성 정점 찾기
        for (int node : nodes) {
            int inDeg = in.getOrDefault(node, 0);
            int outDeg = out.getOrDefault(node, 0);
            
            if (inDeg == 0 && outDeg >= 2) {
                answer[0] = node;
                break;
            }
        }
        
        // 막대, 8자
        for (int node : nodes) {
            if (node == answer[0]) continue;
            
            int inDeg = in.getOrDefault(node, 0);
            int outDeg = out.getOrDefault(node, 0);
            
            if (outDeg == 0) {
                answer[2]++;  // 막대
            }
            
            if (outDeg >= 2) {
                answer[3]++;  // 8자
            }
        }
        
        // 도넛
        answer[1] = out.get(answer[0]) - answer[2] - answer[3];
        
        return answer;
    }
}

