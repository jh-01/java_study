import java.util.*;

class Solution {
    private List<int[]> ways;
    private Set<Long> visitedPoint;
    private Set<String> visitedEdge;

    public int solution(int[] arrows) {
        int answer = 0;
        int x = 0;
        int y = 0;
        visitedPoint = new HashSet<>();
        visitedEdge = new HashSet<>();
        
        // arrows 이동 거리 저장
        ways = new ArrayList<>();
        init();
        
        long point = ((long)x << 32) | (y & 0xffffffffL);
        visitedPoint.add(point);
        
        // 모든 선 그리기
        for(int i = 0; i < arrows.length; i++){
            for(int j = 0; j < 2; j++){
                int[] way = ways.get(arrows[i]);
                int nx = x + way[0];
                int ny = y + way[1];

                long newPoint = ((long)nx << 32) | (ny & 0xffffffffL);
                String fromTo = point + ", " + newPoint;
                String toFrom = newPoint + ", " + point;

                // 방문했는데 다른 간선으로 도달했을 때
                if(visitedPoint.contains(newPoint) 
                   && (!visitedEdge.contains(fromTo) && !visitedEdge.contains(toFrom))
                  ){
                    answer++;
                }
                visitedPoint.add(newPoint);
                visitedEdge.add(fromTo);
                visitedEdge.add(toFrom);
                x = nx;
                y = ny;
                point = ((long)x << 32) | (y & 0xffffffffL);
            }
        }

        return answer;
    }
    
    private void init(){
        ways.add(new int[]{0, 1});
        ways.add(new int[]{1, 1});
        ways.add(new int[]{1, 0});
        ways.add(new int[]{1, -1});
        ways.add(new int[]{0, -1});
        ways.add(new int[]{-1, -1});
        ways.add(new int[]{-1, 0});
        ways.add(new int[]{-1, 1});
    }
}