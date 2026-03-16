import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int[][] map;

    // 토네이도 이동 방향
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {-1, 0, 1, 0};

    // 왼쪽 기준 모래 퍼짐 패턴
    // 4방향에 대한 모래 확산 좌표 (좌, 하, 우, 상 순서)
    private static int[][] dsx = {
        {-1, 1, -2, 2, 0, -1, 1, -1, 1, 0}, // 좌 (0)
        {-1, -1, 0, 0, 2, 0, 0, 1, 1, 1},  // 하 (1)
        {-1, 1, -2, 2, 0, -1, 1, -1, 1, 0}, // 우 (2)
        {1, 1, 0, 0, -2, 0, 0, -1, -1, -1}  // 상 (3)
    };
    private static int[][] dsy = {
        {1, 1, 0, 0, -2, 0, 0, -1, -1, -1}, // 좌
        {-1, 1, -2, 2, 0, -1, 1, -1, 1, 0}, // 하
        {-1, -1, 0, 0, 2, 0, 0, 1, 1, 1},  // 우
        {-1, 1, -2, 2, 0, -1, 1, -1, 1, 0}  // 상
    };
    private static int[] ratios = {1, 1, 2, 2, 5, 7, 7, 10, 10}; // 마지막은 alpha용 (계산 제외)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int startX= N / 2;
        int startY = N / 2;
        int result = move(startX, startY);
        System.out.println(result);
    }


    private static int move(int x, int y){
        int outDust = 0;
        int dir = 0;
        int dist = 1; // 현재 방향으로 이동할 거리

        while (true) {
            for(int i = 0; i < 2; i++){ // 같은 거리로 두 번 이동 (좌-하, 우-상)
                for(int j = 0; j < dist; j++){
                    x += dx[dir];
                    y += dy[dir];

                    outDust += spread(x,y,dir);

                    if(x==0 && y==0){
                        return outDust;
                    }
                }
                dir = (dir + 1) % 4;
            }
            dist++;
        }
    }

    private static int spread(int x, int y, int dir){
        int outDust = 0;
        int sand = map[x][y];
        int spreadSum = 0;

        for(int i = 0; i < 9; i++){
            int nx = x + dsx[dir][i];
            int ny = y + dsy[dir][i];

            // 각 비율만큼의 모래 계산 (소수점 버림은 자동 적용)
            int amount = (sand * ratios[i]) / 100;
            spreadSum += amount;

            if(nx < 0 || nx >= N || ny < 0 || ny >= N){
                outDust += amount;
            } else {
                map[nx][ny] += amount;
            }
        }

        // 알파(α) 위치 계산 (남은 모래 전부 이동)
        int ax = x + dx[dir];
        int ay = y + dy[dir];
        int alpha = sand - spreadSum;

        if(ax<0 || ay<0 || ax>=N || ay>=N){
            outDust += alpha;
        }else{
            map[ax][ay] += alpha;
        }

        // 원래 위치의 모래는 0이 됨
        map[x][y] = 0;

        return outDust;
    }
}
