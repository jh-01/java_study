import java.io.*;
import java.util.*;

class Planet {
    int number;
    Long x;
    Long y;
    Long z;

    public Planet(int number, Long x, Long y, Long z){
        this.number = number;
        this.x = x;
        this.y = y;
        this.z = z;
    }
}

class Edges implements Comparable<Edges> {
    int from;
    int to;
    Long cost;

    public Edges(int from, int to, Long cost){
        this.from = from;
        this.to = to;
        this.cost = cost;
    }
    
    @Override
    public int compareTo(Edges o){
        return Long.compare(this.cost, o.cost);
    }
}

public class Main {
    private static List<Edges> dist;
    private static int[] root;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Planet> planets = new ArrayList<>();
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            Long x = Long.parseLong(st.nextToken());
            Long y = Long.parseLong(st.nextToken());
            Long z = Long.parseLong(st.nextToken());

            planets.add(new Planet(i, x, y, z));
        }

        dist = new ArrayList<>();
        root = new int[N];

        for (int i = 0; i < N; i++) {
            root[i] = i;
        }

        // 거리순 정렬
        Collections.sort(planets, (a, b) -> Long.compare(a.x, b.x));
        for (int i = 0; i < N - 1; i++) {
            Planet a = planets.get(i);
            Planet b = planets.get(i + 1);
            dist.add(new Edges(a.number, b.number, Math.abs(a.x - b.x)));
        }

        Collections.sort(planets, (a, b) -> Long.compare(a.y, b.y));
        for (int i = 0; i < N - 1; i++) {
            Planet a = planets.get(i);
            Planet b = planets.get(i + 1);
            dist.add(new Edges(a.number, b.number, Math.abs(a.y - b.y)));
        }

        Collections.sort(planets, (a, b) -> Long.compare(a.z, b.z));
        for (int i = 0; i < N - 1; i++) {
            Planet a = planets.get(i);
            Planet b = planets.get(i + 1);
            dist.add(new Edges(a.number, b.number, Math.abs(a.z - b.z)));
        }

        Collections.sort(dist);

        long answer = 0;
        int count = 0;

        for (Edges e : dist) {
            if (find(e.from) != find(e.to)) {
                union(e.from, e.to);
                answer += e.cost;
                count++;

                if (count == N - 1) break;
            }
        }

        System.out.println(answer);
    }

    private static int find(int x){
        if(root[x] == x) return x;
        return root[x] = find(root[x]);
    }

    private static void union(int x, int y){
        x = find(x);
        y = find(y);
        if (x != y) {
            root[y] = x;
        }
    }
}
