import java.util. *;

class Solution {
    public int[] solution(int[] arr) {
        int i = 0;
        int n = arr.length;
        List<Integer> list = new ArrayList<>();
        
        while(i < n){
            if(list.isEmpty()){
                list.add(arr[i++]);
            } else if(!list.isEmpty() && list.get(list.size() - 1) == arr[i]){
                list.remove(list.size() - 1);
                i++;
            } else {
                list.add(arr[i++]);
            }
        }
        
        if(list.isEmpty()) return new int[]{-1};
        
        int[] answer = new int[list.size()];

        for (int j = 0; j < list.size(); j++) {
            answer[j] = list.get(j);
        }

        return answer;
    }
}