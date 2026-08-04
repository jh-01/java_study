class Solution {
    public int[] solution(int[] arr) {
        int[] answer = {};
        
        if(arr.length <= 1){
            answer = new int[]{-1};
            return answer;
        }
        
        int minN = Integer.MAX_VALUE;
        answer = new int[arr.length - 1];
        for(int i = 0; i < arr.length; i++){
            minN = Math.min(minN, arr[i]);
        }
        int j = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] != minN){
                answer[j++] = arr[i];
            }
        }
        
        return answer;
    }
}