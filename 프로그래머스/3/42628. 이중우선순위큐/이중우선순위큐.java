import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        int n = operations.length;
        TreeMap<Integer, Integer> tree = new TreeMap<>();
        
        for(int i = 0; i < n; i++){
            String[] oper = operations[i].split(" ");
            int x = Integer.parseInt(oper[1]);
            
            if(oper[0].equals("I")){
                tree.put(x, tree.getOrDefault(x, 0) + 1);
            } else if(oper[0].equals("D")){
                if (tree.isEmpty()) continue;
                if(x == 1){
                    int max = tree.lastKey();
                    if(tree.put(max, tree.get(max) - 1) == 1) tree.remove(max);
                } else {
                    int min = tree.firstKey();
                    if(tree.put(min, tree.get(min) - 1) == 1) tree.remove(min);
                }
            }
        }
        
        if (!tree.isEmpty()) {
            answer[0] = tree.lastKey();
            answer[1] = tree.firstKey();
        }
        
        return answer;
    }
}