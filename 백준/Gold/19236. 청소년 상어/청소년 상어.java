import java.io.*;
import java.util.*;

class Fish {
    int x;
    int y;
    int dir;

    public Fish(int x, int y, int dir){
        this.x = x;
        this.y = y;
        this.dir = dir;
    }
}

public class Main {
    private static int N = 4;
    static int[] dx = {-1,-1,0,1,1,1,0,-1};
    static int[] dy = {0,-1,-1,-1,0,1,1,1};
    static int max = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] map = new int[4][4];
        Fish[] fishes = new Fish[17];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                map[i][j] = a;
                fishes[a] = new Fish(i, j, b - 1);
            }
        }

        // 초기: (0,0) 물고기 먹기
        int first = map[0][0];
        Fish f = fishes[first];

        int dir = f.dir;
        fishes[first] = null;
        map[0][0] = -1; // 상어 위치

        dfs(map, fishes, 0, 0, dir, first);
        System.out.println(max);
    }

    static void dfs(int[][] map, Fish[] fishes, int sx, int sy, int sdir, int sum){
        max = Math.max(max, sum);

        // map 복사
        int[][] copyMap = new int[4][4];
        for(int i=0;i<4;i++) copyMap[i] = map[i].clone();

        // 물고기 복사
        Fish[] copyFish = new Fish[17];
        for(int i=1;i<=16;i++){
            if(fishes[i] != null){
                Fish f = fishes[i];
                copyFish[i] = new Fish(f.x, f.y, f.dir);
            }
        }

        // 물고기 이동
        for(int i=1;i<=16;i++){
            if(copyFish[i] == null) continue;

            Fish fish = copyFish[i];

            for(int d = 0; d < 8; d++){
                int nd = (fish.dir + d) % 8;
                int nx = fish.x + dx[nd];
                int ny = fish.y + dy[nd];

                // 범위 밖 or 상어 위치면 패스
                if(nx<0 || ny<0 || nx>=4 || ny>=4) continue;
                if(copyMap[nx][ny] == -1) continue;

                // 이동
                int target = copyMap[nx][ny];

                // map 갱신
                copyMap[fish.x][fish.y] = target;
                copyMap[nx][ny] = i;

                // 다른 물고기 위치 갱신
                if(target != 0){
                    copyFish[target].x = fish.x;
                    copyFish[target].y = fish.y;
                }

                // 현재 물고기 위치 갱신
                fish.x = nx;
                fish.y = ny;
                fish.dir = nd;

                break;
            }
        }

        // 상어 이동
        for (int step = 1; step < 4; step++) {
            int nx = sx + dx[sdir] * step;
            int ny = sy + dy[sdir] * step;

            if (nx < 0 || ny < 0 || nx >= 4 || ny >= 4) break;
            if (copyMap[nx][ny] == 0) continue;

            int fishNum = copyMap[nx][ny];
            Fish eaten = copyFish[fishNum];

            // 상태 복사
            int[][] nextMap = new int[4][4];
            for (int i = 0; i < 4; i++) nextMap[i] = copyMap[i].clone();

            Fish[] nextFish = new Fish[17];
            for (int i = 1; i <= 16; i++) {
                if (copyFish[i] != null) {
                    Fish f = copyFish[i];
                    nextFish[i] = new Fish(f.x, f.y, f.dir);
                }
            }

            // 상어 이동 처리
            nextMap[sx][sy] = 0;
            nextMap[nx][ny] = -1;
            nextFish[fishNum] = null;

            dfs(nextMap, nextFish, nx, ny, eaten.dir, sum + fishNum);
        }
    }
}
