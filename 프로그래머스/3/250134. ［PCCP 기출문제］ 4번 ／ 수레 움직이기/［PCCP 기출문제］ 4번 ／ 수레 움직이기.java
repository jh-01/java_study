class Solution {
    private int N;
    private int M;
    private int rex;
    private int rey;
    private int bex;
    private int bey;
    int answer = Integer.MAX_VALUE;
    private boolean[][] visitedRed;
    private boolean[][] visitedBlue;
    
    private int[] dx = {1, -1, 0, 0};
    private int[] dy = {0, 0, 1, -1};
    
    private void dfs(int rX, int rY, int bX, int bY, int[][] maze, int count){
        if (count >= answer) return;

        if(rX == rex && rY == rey && bX == bex && bY == bey){
            answer = Math.min(answer, count);
            return;
        }
        
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int nrX = rX;
                int nrY = rY;
                int nbX = bX;
                int nbY = bY;
                
                if (!(rX == rex && rY == rey)) {
                    nrX = rX + dx[i];
                    nrY = rY + dy[i];
                }

                if (!(bX == bex && bY == bey)) {
                    nbX = bX + dx[j];
                    nbY = bY + dy[j];
                }
            
                if(nrX == nbX && nrY == nbY) continue;
                if (nrX == bX && nrY == bY && nbX == rX && nbY == rY) continue;
                if(nrX < 0 || nrX >= N || nbX < 0 || nbX >= N
                   || nrY < 0 || nrY >= M || nbY < 0 || nbY >= M
                ) continue;

                boolean redMoved  = !(rX == rex && rY == rey);
                boolean blueMoved = !(bX == bex && bY == bey);

                if ((!redMoved || !visitedRed[nrX][nrY]) &&
                    (!blueMoved || !visitedBlue[nbX][nbY]) &&
                    maze[nrX][nrY] != 5 &&
                    maze[nbX][nbY] != 5) {

                    if (redMoved) visitedRed[nrX][nrY] = true;
                    if (blueMoved) visitedBlue[nbX][nbY] = true;

                    dfs(nrX, nrY, nbX, nbY, maze, count + 1);

                    if (redMoved) visitedRed[nrX][nrY] = false;
                    if (blueMoved) visitedBlue[nbX][nbY] = false;
                }

            }
        }
    }
    
    public int solution(int[][] maze) {
        N = maze.length;
        M = maze[0].length;
        int rsx = 0;
        int rsy = 0;
        int bsx = 0;
        int bsy = 0;
        visitedRed = new boolean[N][M];
        visitedBlue = new boolean[N][M];
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(maze[i][j] == 1) {
                    rsx = i;
                    rsy = j;
                } else if(maze[i][j] == 2){
                    bsx = i;
                    bsy = j;
                } else if(maze[i][j] == 3) {
                    rex = i;
                    rey = j;
                } else if(maze[i][j] == 4) {
                    bex = i;
                    bey = j;
                }
            }
        }
        
        visitedRed[rsx][rsy] = true;
        visitedBlue[bsx][bsy] = true;
        dfs(rsx, rsy, bsx, bsy, maze, 0);

        return answer == Integer.MAX_VALUE ? 0 : answer;
    }
}