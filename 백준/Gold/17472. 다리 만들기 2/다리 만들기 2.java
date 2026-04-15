import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Edge implements Comparable<Edge> {
    int from;
    int to;
    int cost;

    public Edge(int from, int to, int cost){
        this.from = from;
        this.to = to;
        this.cost = cost;
    }
    
    @Override
    public int compareTo(Edge o){
        return Integer.compare(this.cost, o.cost);
    }
}

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static List<Edge> bridges;
    static int[][] dist;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];
        bridges = new ArrayList<>();

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 섬 번호 붙이기
        int number = makeMap();

         // 섬이 0개 또는 1개면 다리 필요 없음
        if (number <= 1) {
            System.out.println(0);
            return;
        }

        // 섬 간 최소 다리 길이 저장 배열
        dist = new int[number + 1][number + 1];
        for (int i = 0; i <= number; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        // 모든 섬 칸에서 4방향 직선 탐색
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(map[i][j] > 0){
                    makeBridge(i, j);
                }
            }
        }

        // dist -> 간선 리스트
        for (int i = 1; i <= number; i++) {
            for (int j = i + 1; j <= number; j++) {
                if (dist[i][j] != Integer.MAX_VALUE) {
                    bridges.add(new Edge(i, j, dist[i][j]));
                }
            }
        }

        // 5. 크루스칼
        Collections.sort(bridges);
        System.out.println(kruskal(number));
    }

    private static int makeMap(){
        int[][] newMap = new int[N][M];
        visited = new boolean[N][M];
        int number = 1;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(!visited[i][j] && map[i][j] == 1){
                    dfs(i, j, number, newMap);
                    number++;
                }
            }
        }
        map = newMap;
        return number - 1;
    }

    private static void dfs(int x, int y, int number, int[][] newMap){
        visited[x][y] = true;
        newMap[x][y] = number;

        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

            if(!visited[nx][ny] && map[nx][ny] == 1){
                dfs(nx, ny, number, newMap);
            }
        }
    }

    private static void makeBridge(int x, int y){
        int start = map[x][y];

        for(int i = 0; i < 4; i++){
            int len = 0;
            int nx = x + dx[i];
            int ny = y + dy[i];

            while(true){
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) break;

                if (map[nx][ny] == map[x][y]) break; // 같은 섬이면 끝내기

                if (map[nx][ny] == 0) {
                    len++;
                    nx += dx[i];
                    ny += dy[i];
                } else { // 다른 섬
                    if (len >= 2) {
                        // 간선 후보
                        int a = map[x][y];
                        int b = map[nx][ny];

                        dist[a][b] = Math.min(dist[a][b], len);
                        dist[b][a] = Math.min(dist[b][a], len);
                        
                    }
                    break;
                }
            }
        }
    }

    private static int kruskal(int number){
        parent = new int[number + 1];
        for (int i = 1; i <= number; i++) {
            parent[i] = i;
        }

        int total = 0;
        int count = 0;

        for (Edge e : bridges) {
            if (find(e.from) != find(e.to)) {
                union(e.from, e.to);
                total += e.cost;
                count++;

                if (count == number - 1) break;
            }
        }

        // 모든 섬 연결 못 하면 -1
        if (count != number - 1) return -1;
        return total;
    }

    private static int find(int x){
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    private static void union(int x, int y){
        x = find(x);
        y = find(y);
        if(x != y) parent[y] = x;
    }
}
