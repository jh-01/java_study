class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = {51, 51, -1, -1};
        char temp;
        boolean startFound = false;
        
        for(int i = 0; i < wallpaper.length; i++){
            for(int j = 0; j < wallpaper[i].length(); j++){
                temp = wallpaper[i].charAt(j);
                if(temp == '.') continue;
                if(answer[0] >= i) {
                    answer[0] = i;
                } 
                if(answer[1] >= j){
                    answer[1] = j;
                }
                if(answer[2] <= i){
                    answer[2] = i;
                } 
                if(answer[3] <= j){
                    answer[3] = j;
                }
            }
        }
        answer[2]++;
        answer[3]++;
        
        return answer;
    }
}