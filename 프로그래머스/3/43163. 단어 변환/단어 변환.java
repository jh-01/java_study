import java.util.*;

class Pair {
    String s;
    int depth;
    
    Pair(String s, int depth){
        this.s = s;
        this.depth = depth;
    }
}

class Solution {
    private int N;
    
    private int bfs(String begin, String target, String[] words){
        Queue<Pair> q = new LinkedList<>();
        boolean[] isVisited = new boolean[N];
        
        q.offer(new Pair(begin, 0));
        while(!q.isEmpty()) {
            Pair pair = q.poll();
            String temp = pair.s;
            int depth = pair.depth;
            
            if(temp.equals(target)) return depth;
            
            for(int i = 0; i < N; i++){
                if(isVisited[i]) continue;
                String next = words[i];
                
                int count = 0;
                for(int j = 0; j < temp.length(); j++){
                    if(temp.charAt(j) != next.charAt(j))
                        count++;
                }
                
                if(count > 1) continue;
                else if(count == 1) {
                    isVisited[i] = true;
                    q.offer(new Pair(next, depth + 1));
                }
            }
        }
        return 0;
    }
    
    public int solution(String begin, String target, String[] words) {
        N = words.length;
        
        // target이 words에 없는 경우
        canConvert(target, words);

        // bfs 반환
        return bfs(begin, target, words);
    }
    
    private boolean canConvert(String target, String[] words){
        boolean flag = false;
        for(int i = 0; i < N; i++){
            if(target.equals(words[i])) flag = true;
        }
        return flag;
    }
}