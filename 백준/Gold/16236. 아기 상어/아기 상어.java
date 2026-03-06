import java.io.*;
import java.util.*;

class Fish {
    int x;
    int y;
    int size;
    int dist;

    public Fish(int x, int y, int size, int dist){
        this.x = x;
        this.y = y;
        this.size = size;
        this.dist = dist;
    }
}

public class Main {

    private static int N;
    private static int[][] map;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        int tempX = -1;
        int tempY = -1;

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 9){
                    tempX = i;
                    tempY = j;
                    map[i][j] = 0;
                }
            }
        }

        int time = 0;
        int count = 0;
        int size = 2;
        while(true){
            // 먹을 수 있는 물고기 후보
            List<Fish> candidates = bfs(tempX, tempY, size);

            if(candidates.size() == 0) break;

            candidates.sort((a, b) -> {
                if(a.dist != b.dist) return a.dist - b.dist; // 거리
                if(a.x != b.x) return a.x - b.x; // 위쪽
                return a.y - b.y; // 왼쪽
            });

            // 물고기 먹기
            Fish fish = candidates.get(0);
            candidates.remove(0);

            map[fish.x][fish.y] = 0;
            tempX = fish.x;
            tempY = fish.y;

            count++;
            if(count == size){
                size++;
                count = 0;
            }


            time += fish.dist;
        }

        System.out.println(time);
    }

    private static List<Fish> bfs(int sx, int sy, int size){
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        boolean[][] visited = new boolean[N][N];
        Queue<int[]> q = new LinkedList<>();
        List<Fish> candidates = new ArrayList<>();
        int minDist = Integer.MAX_VALUE;

        q.add(new int[]{sx, sy, 0});
        visited[sx][sy] = true;

        while(!q.isEmpty()){
            int[] temp = q.poll();

            if(temp[2] > minDist) break;

            for(int i = 0; i < 4; i++){
                int nx = temp[0] + dx[i];
                int ny = temp[1] + dy[i];
                int nDist = temp[2] + 1;

                if(nx < 0 || nx >= N || ny < 0 || ny >= N){
                    continue;
                }
                if(!visited[nx][ny] && map[nx][ny] <= size){
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny, nDist});

                    if(map[nx][ny] != 0 && map[nx][ny] < size){
                        candidates.add(new Fish(nx, ny, map[nx][ny], nDist));
                        minDist = nDist;
                    }
                }
            }
        }

        return candidates;
    }
}
