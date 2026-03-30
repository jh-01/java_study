import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Parameter;
import java.util.*;

class Star{
    double x;
    double y;

    public Star(double x, double y){
        this.x = x;
        this.y = y;
    }
}

class Edge implements Comparable<Edge> {
    int from;
    int to;
    double cost;

    public Edge(int from, int to, double cost){
        this.from = from;
        this.to = to;
        this.cost = cost;
    }
    
    @Override
    public int compareTo(Edge o){
        return Double.compare(this.cost, o.cost);
    }
}

public class Main {
    private static int N;
    private static Star[] stars;
    private static List<Edge> edges;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        stars = new Star[N];
        edges = new ArrayList<>();
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());
            
            stars[i] = new Star(x, y);
        }

       edges = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                double dist = Math.sqrt(
                    Math.pow(stars[i].x - stars[j].x, 2) +
                    Math.pow(stars[i].y - stars[j].y, 2)
                );
                edges.add(new Edge(i, j, dist));
            }
        }

        Collections.sort(edges);
        System.out.printf("%.2f\n", kruskal());
    }

    private static double kruskal(){
        double answer = 0;
        int count = 0;

        int[] parent = new int[N];
        for(int i = 0; i < N; i++){
            parent[i] = i;
        }

        for(Edge edge : edges){
            if(findParent(parent, edge.from) != findParent(parent, edge.to)){
                union(parent, edge.from, edge.to);
                answer += edge.cost;
                count++;
                if(count == N - 1) return answer;
            }
        }
        return answer;
    }

    private static int findParent(int[] parent, int x){
        if(parent[x] == x) return x;
        return parent[x] = findParent(parent, parent[x]);
    }

    private static void union(int[] parent, int a, int b){
        a = findParent(parent, a);
        b = findParent(parent, b);

        if(a < b) parent[b] = a;
        else parent[a] = b;
    }
}
