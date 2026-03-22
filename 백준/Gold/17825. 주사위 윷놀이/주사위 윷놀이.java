import java.io.*;
import java.util.*;

class Node {
    int score;
    Node next;
    Node blueNode;

    public Node(int score){
        this.score = score;
    }

    public Node(int score, Node next){
        this.score = score;
        this.next = next;
    }

    public Node(int score, Node next, Node bluNode){
        this.score = score;
        this.next = next;
        this.blueNode = bluNode;
    }
}

public class Main {
    private static int[] dices = new int[10];
    private static Node[] nodes = new Node[41];
    private static int answer = 0;
    // 말 4개 위치
    static Node[] horses = new Node[4];
    static Node START;
    static Node END;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0 ; i < 10; i++){
            dices[i] = Integer.parseInt(st.nextToken());
        }

        init();
        dfs(0, 0);

        System.out.println(answer);
    }

    public static void init(){
         // 끝 노드
        END = new Node(0);
        START = new Node(0);
        Node prev = START;
        nodes[0] = START;

        for(int i = 2; i <= 40; i+=2){
            Node cur = new Node(i);
            nodes[i] = cur;
            prev.next = cur;
            prev = cur;
        }

        // 40 다음은 end
        nodes[40].next = END;

         // 공통 경로 (25 → 30 → 35 → 40)
        Node n25 = new Node(25);
        Node n30 = new Node(30);
        Node n35 = new Node(35);

        n25.next = n30;
        n30.next = n35;
        n35.next = nodes[40]; // 기존 40 재사용

        // 4️⃣ 10 분기 (13 → 16 → 19 → 25)
        Node n13 = new Node(13);
        Node n16 = new Node(16);
        Node n19 = new Node(19);

        nodes[10].blueNode = n13;

        n13.next = n16;
        n16.next = n19;
        n19.next = n25;

        // 5️⃣ 20 분기 (22 → 24 → 25)
        Node n22 = new Node(22);
        Node n24 = new Node(24);

        nodes[20].blueNode = n22;

        n22.next = n24;
        n24.next = n25;

        // 6️⃣ 30 분기 (28 → 27 → 26 → 25)
        Node n28 = new Node(28);
        Node n27 = new Node(27);
        Node n26 = new Node(26);

        nodes[30].blueNode = n28;

        n28.next = n27;
        n27.next = n26;
        n26.next = n25;

        for(int i = 0; i < 4; i++){
            horses[i] = START;
        }
    }

    /*
    depth: 몇 번째 주사위인지 (0 ~ 9)
    score: 현재까지 점수
    horsePositions: 말 4개의 현재 위치
    */
    private static void dfs(int depth, int score){
        if(depth == 10) {
            answer = Math.max(answer, score);
            return;
        }

        int move = dices[depth];

        // 말 4개 중 하나 선택해서 이동
        for (int i = 0; i < 4; i++) {
            Node cur = horses[i];

            // 이미 도착한 말이면 스킵
            if(cur == END) continue;

            // 이동
            Node next = move(cur, move);

            // 겹치는지 체크
            if(isOverlap(i, next)) continue;

            Node prev = horses[i];
            horses[i] = next;

            dfs(depth + 1, score + next.score);

            horses[i] = prev;
        }


    }

    private static Node move(Node cur, int dist){
        Node now = cur;

        if(now.blueNode != null){
            now = now.blueNode;
            dist--;
        } else {
            now = now.next;
            dist--;
        }

        while(dist-- > 0 && now != END){
            now = now.next;
        }

        return now;
    }

    private static boolean isOverlap(int i, Node next){
        if (next == END) return false;

        for(int j = 0; j < 4; j++){
            if(i == j) continue;
            if(horses[j] == next) return true;
        }
        return false;
    }
}