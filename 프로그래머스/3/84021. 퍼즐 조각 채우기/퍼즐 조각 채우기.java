import java.util.*;

class Solution {
    private int N;
    private List<List<int[]>> boardShapes = new ArrayList<>();
    private List<List<int[]>> tableShapes = new ArrayList<>();
    private boolean[][] visited;
    
    private int[] dx = {1, -1, 0, 0};
    private int[] dy = {0, 0, 1, -1};
    
    public int solution(int[][] game_board, int[][] table) {
        N = game_board.length;
        int answer = 0;
        visited = new boolean[N][N];
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(!visited[i][j] && game_board[i][j] == 0){
                    List<int[]> shape = new ArrayList<>();
                    findShape(0, i, j, game_board, shape);
                    boardShapes.add(normalize(shape));
                }
            }
        }
        
        visited = new boolean[N][N];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(!visited[i][j] && table[i][j] == 1){
                    List<int[]> shape = new ArrayList<>();
                    findShape(1, i, j, table, shape);
                    tableShapes.add(normalize(shape));
                }
            }
        }
        
        for(List<int[]> tableShape : tableShapes) {
            boolean matched = false;
            for (int i = 0; i < boardShapes.size(); i++) {
                List<int[]> boardShape = boardShapes.get(i);
                
                if (boardShape.size() != tableShape.size()) continue;
                
                List<int[]> rotated = tableShape;
                
                for (int r = 0; r < 4; r++) {
                    rotated = rotate(rotated);
                    if (isSame(boardShape, rotated)) {
                        answer += rotated.size();
                        boardShapes.remove(i);
                        matched = true;
                        break;
                    }
                }
                if (matched) break;
            }
        }
        
        return answer;
    }
    
    private void findShape(int target, int x, int y, int[][] board, List<int[]> shape){
        visited[x][y] = true;
        shape.add(new int[]{x, y}); 
        
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
            
            if(!visited[nx][ny] && board[nx][ny] == target){
                findShape(target, nx, ny, board, shape);
            }
        }
    }
    
    private List<int[]> normalize(List<int[]> shape){
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        
        for(int[] v : shape){
            minX = Math.min(v[0], minX);
            minY = Math.min(v[1], minY); 
        }
        
        List<int[]> normalized = new ArrayList<>();
        for (int[] p : shape) {
            normalized.add(new int[]{p[0] - minX, p[1] - minY});
        }

        normalized.sort((a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];
        });
        
        return normalized;
    }
    
    private List<int[]> rotate(List<int[]> shapes){
        List<int[]> rotated = new ArrayList<>();
        
        int maxX = 0;
        for(int[] p : shapes){
            maxX = Math.max(maxX, p[0]); // 도형의 최대 x값 찾기
        }
        
        for (int[] p : shapes) {
            int x = p[0];
            int y = p[1];
            rotated.add(new int[]{y, maxX - x});
        }
        
        return normalize(rotated);
    }
    
    private boolean isSame(List<int[]> boardShape, List<int[]> tableShape){
        if(boardShape.size() != tableShape.size()) return false;
        for(int i = 0; i < boardShape.size(); i++){
            int[] aInt = boardShape.get(i);
            int[] bInt = tableShape.get(i);
            if(aInt[0] != bInt[0] || aInt[1] != bInt[1]) return false;
        }
        return true;
    }
}