import java.io.*;
import java.util.*;

public class Main {
    private static int N, M;
    private static int[][] map;
    private static int[] hole;
    private static int[] dx = {-1,1,0,0};
    private static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        hole = new int[2];
        int[] red = new int[2];
        int[] blue = new int[2];
        for(int i = 0; i < N; i++){
            String s = br.readLine();
            char[] temp = s.toCharArray();

            for(int j = 0; j < M; j++){
                if(temp[j] == '#'){
                    map[i][j] = -1;
                } else if(temp[j] == '.'){
                    map[i][j] = 0;
                } else if(temp[j] == 'O'){
                    map[i][j] = 1;
                    hole[0] = i;
                    hole[1] = j;
                } else if(temp[j] == 'R'){
                    map[i][j] = 0;
                    red[0] = i;
                    red[1] = j;
                } else if(temp[j] == 'B'){
                    map[i][j] = 0;
                    blue[0] = i;
                    blue[1] = j;
                }
            }
        }
        int result = bfs(red[0], red[1], blue[0], blue[1]);
        System.out.println(result);
    }

    private static int bfs(int rx, int ry, int bx, int by){
        Queue<int[]> q = new LinkedList<>();
        boolean[][][][] visited = new boolean[N][M][N][M];

        visited[rx][ry][bx][by] = true;
        q.add(new int[]{rx, ry, bx, by, 0});

        while(!q.isEmpty()){
            int[] temp = q.poll();
            int depth = temp[4];

            if(depth == 10) continue;
            
            for(int i = 0; i < 4; i++){
                int[] redNext = move(temp[0], temp[1], i);
                int[] blueNext = move(temp[2], temp[3], i);

                if(blueNext[0] == hole[0] && blueNext[1] == hole[1]){
                    continue;
                }

                if(redNext[0] == hole[0] && redNext[1] == hole[1]) {
                    return depth + 1;
                }
                
                if(redNext[0] == blueNext[0] && redNext[1] == blueNext[1]){
                    if(redNext[2] > blueNext[2]){
                        redNext[0] -= dx[i];
                        redNext[1] -= dy[i];
                    } else {
                        blueNext[0] -= dx[i];
                        blueNext[1] -= dy[i];
                    }
                }

                if(!visited[redNext[0]][redNext[1]][blueNext[0]][blueNext[1]]) {
                    visited[redNext[0]][redNext[1]][blueNext[0]][blueNext[1]] = true;
                    q.add(new int[]{redNext[0], redNext[1], blueNext[0], blueNext[1], depth + 1});
                }
            }
        }

        return -1;
    }

    private static int[] move(int x, int y, int direction){
        int count = 0;
        int[] result = new int[3];

        while(map[x + dx[direction]][y + dy[direction]] != -1){
            x += dx[direction];
            y += dy[direction];
            count++;

            if(map[x][y] == 1) break; // 구멍
        }
        result[0] = x;
        result[1] = y;
        result[2] = count;

        return result;
    }
}
