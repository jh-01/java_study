import java.io.*;
import java.util.*;

public class Main {

    private static int[][] map;
    private static int l;
    private static int x;
    private static int y;
    static int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] dy = {2, 1, -1, -2, -2, -1, 1, 2};


    private static int bfs(int tx, int ty){
        Queue<int[]> q = new LinkedList<>();

        map[tx][ty] = 1;
        q.offer(new int[]{tx, ty});

        while(!q.isEmpty()){
            int[] temp = q.poll();

            if(temp[0] == x && temp[1] == y){
                return map[temp[0]][temp[1]] - 1;
            }

            for(int i = 0; i < 8; i++){
                int nx = temp[0] + dx[i];
                int ny = temp[1] + dy[i];

                if(nx > -1 && nx <l && ny > -1 && ny < l){
                    if(map[nx][ny] == 0){
                        map[nx][ny] = map[temp[0]][temp[1]] + 1;
                        q.offer(new int[]{nx, ny});
                    }
                }
            }
        }

        return 0;
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while(T-- > 0){
            l = Integer.parseInt(br.readLine());
            map = new int[l][l];

            StringTokenizer st = new StringTokenizer(br.readLine());
            int tx = Integer.parseInt(st.nextToken());
            int ty = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            if(tx == x && ty == y) System.out.println(0);
            else System.out.println(bfs(tx, ty));
        }

    }
}
