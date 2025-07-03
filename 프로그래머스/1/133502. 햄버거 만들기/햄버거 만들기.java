import java.util.ArrayList;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        ArrayList<Integer> stack = new ArrayList<>();
        
        for(int ingre : ingredient) {
            stack.add(ingre);
            int stackSize = stack.size();
            if(
                stackSize >= 4 &&
                stack.get(stackSize - 4) == 1 &&
                stack.get(stackSize - 3) == 2 &&
                stack.get(stackSize - 2) == 3 &&
                stack.get(stackSize - 1) == 1
            ){
                for(int j = 0; j < 4; j++){
                    stack.remove(stack.size() - 1);
                }
                answer++;
            }
        }
        return answer;
    }
}