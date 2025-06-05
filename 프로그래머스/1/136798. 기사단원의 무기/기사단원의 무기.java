class Solution {
    public int solution(int number, int limit, int power) {
        boolean[] isPrime = new boolean[number];
        int[] array = new int[number];
        boolean flag = true;
        
        for (int i = 1; i < number; i++) {
            isPrime[i] = true;
        }
        for (int i = 1; i < number; i++) {
            if(isPrime[i]) {
                for (int j = i * 2; j < number; j += i) {
                    isPrime[j] = false;
                }	
            }
        }

        array[0] = 1;
        for (int i = 1; i < number; i++) {
            if(isPrime[i]) array[i] = 2;
            else {
                int cnt = 0;
                for(int j = 1; j * j <= i + 1; j++){
                    if(j * j == i + 1) cnt++;
                    else if((i + 1) % j == 0) cnt += 2;
                }
                if(cnt > limit) array[i] = power;
                 else array[i] = cnt;
            }
        }
        int sum = 0;
        for(int i = 0; i < array.length; i++){
            sum += array[i];
        }
        return sum;
    }
}