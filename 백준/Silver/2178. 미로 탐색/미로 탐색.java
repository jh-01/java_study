import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static int M;
    private static int[][] map;
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};

    private static int bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{x, y});

        while(!q.isEmpty()){
            int[] temp = q.poll();

            for(int i = 0; i < 4; i++){
                int nx = temp[0] + dx[i];
                int ny = temp[1] + dy[i];

                if(nx > -1 && nx < N && ny > -1 && ny < M){
                    if(map[nx][ny] == 1){
                        map[nx][ny] = map[temp[0]][temp[1]] + 1;
                        q.offer(new int[]{nx, ny});
                    }
                }
            }
        }

        return map[N - 1][M - 1];
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for(int i = 0; i < N; i++){
            String s = br.readLine();
            for(int j = 0; j < M; j++){
                map[i][j] = s.charAt(j) - '0';
            }
        }

        System.out.println(bfs(0, 0));
    }
}
