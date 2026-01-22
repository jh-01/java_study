import java.util.*;

class Solution {
    public int solution(int[][] points, int[][] routes) {
        int X = routes.length;
        int answer = 0;
        
        Map<Integer, Map<String, Integer>> maps = new HashMap<>();
        
        for(int i = 0; i < X; i++){ // i는 로봇
            int time = 0;
            int r = points[routes[i][0] - 1][0];
            int c = points[routes[i][0] - 1][1];
            
            String key = r + "," + c;
            maps.putIfAbsent(time, new HashMap<>());
            Map<String, Integer> map = maps.get(time);
            
            int count = map.getOrDefault(key, 0) + 1;
            map.put(key, count);
            maps.put(time, map);
            if(count == 2) answer++;
            
            for(int dir = 0; dir < routes[i].length - 1; dir++){
                int endR = points[routes[i][dir + 1] - 1][0];
                int endC = points[routes[i][dir + 1] - 1][1];
               
                while(r != endR || c != endC){
                    if(r != endR) r += Integer.compare(endR, r);
                    else if(c != endC) c += Integer.compare(endC, c);
                    time++;
                    
                    key = r + "," + c;
                    Map<String, Integer> newMap = maps.getOrDefault(time, new HashMap<>());
                    count = newMap.getOrDefault(key, 0) + 1;
                    newMap.put(key, count);
                    maps.put(time, newMap);
                    if(count == 2) answer++;
                }
            }
            
        }
        
        return answer;
    }
}