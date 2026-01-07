import java.util.*;

class Solution {
    private int N;
    private int[] dx = {1, -1, 0, 0};
    private int[] dy = {0, 0, 1, -1};
    private int[][] map;
    
    private int bfs(int x, int y, int[][] rectangle, int itemX, int itemY){
        Queue<int[]> q = new LinkedList<>();
        boolean[][] isVisited = new boolean[102][102];
        
        q.offer(new int[]{x, y, 0});
        isVisited[x][y] = true;
        
        while(!q.isEmpty()){
            int[] temp = q.poll();
            int tX = temp[0];
            int tY = temp[1];
            int dist = temp[2];

            if (tX == itemX && tY == itemY) {
                return dist / 2;
            }
            
            for(int i = 0; i < 4; i++){
                int nX = tX + dx[i];
                int nY = tY + dy[i];
                
                if(nX < 0 || nX > 101 || nY < 0 || nY > 101){
                    continue;
                } 
                
                if(!isVisited[nX][nY] && map[nX][nY] == 1){
                    isVisited[nX][nY] = true;
                    q.offer(new int[]{nX, nY, temp[2] + 1});
                }
            }
        }
        return -1;
    }
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        N = rectangle.length;
        for(int i = 0; i < rectangle.length; i++){
            for(int j = 0; j < rectangle[i].length; j++){
                rectangle[i][j] = rectangle[i][j] * 2;
            }
        }
        
        map = makeMap(rectangle);
        
        return bfs(characterX * 2, characterY * 2, rectangle, itemX * 2, itemY * 2);
    }
    
    private int[][] makeMap(int[][] rectangle){
        int[][] map = new int[102][102];

        for (int i = 0; i < rectangle.length; i++) {
            int x1 = rectangle[i][0];
            int y1 = rectangle[i][1];
            int x2 = rectangle[i][2];
            int y2 = rectangle[i][3];

            // 사각형 전체 채우기
            for (int x = x1; x <= x2; x++) {
                for (int y = y1; y <= y2; y++) {
                    map[x][y] = 1;
                }
            }
        }
        
        for (int i = 0; i < rectangle.length; i++) {
            int x1 = rectangle[i][0];
            int y1 = rectangle[i][1];
            int x2 = rectangle[i][2];
            int y2 = rectangle[i][3];
            
            // 내부 삭제
            for (int x = x1 + 1; x < x2; x++) {
                for (int y = y1 + 1; y < y2; y++) {
                    map[x][y] = 0;
                }
            }
        }
        return map;
    }
}