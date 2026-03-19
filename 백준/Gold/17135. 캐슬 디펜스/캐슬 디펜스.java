import java.io.*;
import java.util.*;

public class Main {
    private static int N, M, D;
    private static int[][] map;
    private static int[] archer = new int[3];
    static int max = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);
        System.out.println(max);
    }

    // 궁수 배치
    // depth = 현재 선택된 궁수 수
    private static void dfs(int start, int depth){
        // 궁수 3명 선택 완료 → 시뮬레이션 실행
        if(depth == 3) {
            max = Math.max(max, simulate(archer));
            return;
        }
        
        for (int i = start; i < M; i++){
            archer[depth] = i;
            dfs(i+1, depth+1);
        }
    }

    // 선택된 궁수 배치로 게임 시뮬레이션 실행
    private static int simulate(int[] archer){
        int kill = 0;

        // 맵 복사
        int[][] copy = new int[N][M];
        for (int i = 0; i < N; i++) {
            copy[i] = map[i].clone();
        }

        // 게임 진행
        for(int turn = 0; turn < N; turn++){
            // 이번 턴에 죽일 적들 저장
            Set<String> targets = new HashSet<>();

            // 각 궁수마다 공격할 적 탐색
            for(int i = 0; i < 3; i++){
                int col = archer[i];
                int[] target = bfs(col, copy);

                if(target != null){
                    targets.add(target[0] + "," + target[1]);
                }
            }

            // 적 제거
            for(String t : targets){
                String[] pos = t.split(",");
                int x = Integer.parseInt(pos[0]);
                int y = Integer.parseInt(pos[1]);

                if (copy[x][y] == 1) {
                    kill++;
                    copy[x][y] = 0;
                }
            }

            // 적 이동 (아래로 한 칸)
            for (int i = N - 1; i > 0; i--) {
                copy[i] = copy[i - 1].clone();
            }

            // 맨 위는 비움
            Arrays.fill(copy[0], 0);
        }
        return kill;
    }

    // 한 궁수가 공격할 적을 BFS로 탐색
    private static int[] bfs(int archerCol, int[][] copy){
        boolean[][] visited = new boolean[N][M];
        Queue<int[]> q = new LinkedList<>();
        int[] dx = {0, -1, 0};
        int[] dy = {-1, 0, 1};

        // 시작: 궁수 바로 위
        q.offer(new int[]{N - 1, archerCol, 1}); // x, y, 거리
        visited[N - 1][archerCol] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int dist = cur[2];

            // 공격 거리 초과 시 무시
            if(dist > D) continue;

            // 적 발견 → 가장 가까운 + 왼쪽 우선이므로 바로 반환
            if(copy[x][y] == 1){
                return new int[]{x, y};
            }

            // 다음 위치 탐색
            for (int i = 0; i < 3; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 범위 체크
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                // 방문 체크
                if (visited[nx][ny]) continue;

                visited[nx][ny] = true;
                q.offer(new int[]{nx, ny, dist + 1});
            }
        }

        return null; // 공격할 적 없음
    }
}
