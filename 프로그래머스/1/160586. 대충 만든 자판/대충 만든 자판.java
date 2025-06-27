class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        char c;
        int temp;
        int sum;
        
        for(int i = 0; i < targets.length; i++){
            sum = 0;
            for(int j = 0; j < targets[i].length(); j++){
                c = targets[i].charAt(j);
                temp = 102;
                for(int k = 0; k < keymap.length; k++){
                    int target = keymap[k].indexOf(c);
                    if(target != -1){
                        int index = target + 1;
                        if(index < temp) temp = index;
                    }
                }
                if(temp == 102) {
                    answer[i] = -1;
                    break;
                }
                else sum += temp;
            }
            if (answer[i] != -1) {
                answer[i] = sum;
            }
        }
        return answer;
    }
}