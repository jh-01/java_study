import java.util.*;

class Solution {
    private static int N;
    private static int maxResult;
    private static boolean[] selected;
    private static int[] bestAnswer;

    public int[] solution(int[][] dice) {
        N = dice.length;
        selected = new boolean[N];
        bestAnswer = new int[N / 2];
        maxResult = 0;
        
        comb(dice, 0, 0);
        
        return bestAnswer;
    }
    
    private static void comb(int[][] dice, int start, int depth){
        if(depth == N / 2){
            int idx = 0;
            int[] selecetedDices = new int[depth];
            
            for(int i = 0; i < N; i++){
                if(selected[i]){
                    selecetedDices[idx++] = i;   
                }
            }
            
            int result = solve(dice, selecetedDices);
            
            if(result > maxResult){
                maxResult = result;
                for(int i = 0; i < N/2; i++){
                    bestAnswer[i] = selecetedDices[i] + 1;
                }
            }

            return;
        }
        
        for(int i = start; i < N; i++){
            selected[i] = true;
            comb(dice, i + 1, depth + 1);
            selected[i] = false; // 백트래킹
        }
    }
    
    private static int solve(int[][] dice, int[] selecetedDices){
        int[] other = new int[N/2];
        int idx = 0;

        for(int i = 0; i < N; i++){
            if(!selected[i]){
                other[idx++] = i;
            }
        }
        
        List<Integer> sumA = new ArrayList<>();
        makeSum(dice, selecetedDices, 0, 0, sumA);
        
        List<Integer> sumB = new ArrayList<>();
        makeSum(dice, other, 0, 0, sumB);
        
        Collections.sort(sumB);
        
        int win = 0;

        for(int a : sumA){
            win += lowerBound(sumB, a);
        }
        
        return win;
    }
    
    private static int lowerBound(List<Integer> list, int target){
        int left = 0;
        int right = list.size();

        while(left < right){
            int mid = (left + right) / 2;

            if(list.get(mid) < target){
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
    
    private static void makeSum(int[][] dice, int[] group,
                            int depth, int sum,
                            List<Integer> result){

        if(depth == group.length){
            result.add(sum);
            return;
        }

        int diceIndex = group[depth];

        for(int i = 0; i < 6; i++){
            makeSum(dice, group,
                    depth + 1,
                    sum + dice[diceIndex][i],
                    result);
        }
    }

}