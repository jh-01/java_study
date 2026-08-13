class Solution {
    public int solution(int[] numbers) {
        int n = numbers.length;
        int t1 = 0, t2 = 0;
        
        for(int i = 0; i < n; i++){
            if(numbers[i] >= t1){
                int temp = t1;
                t1 = numbers[i];
                t2 = temp;
            }
            else if(numbers[i] > t2){
                t2 = numbers[i];
            }
        }
        
        System.out.println(t1 + ", " + t2);
        return t1 * t2;
    }
}