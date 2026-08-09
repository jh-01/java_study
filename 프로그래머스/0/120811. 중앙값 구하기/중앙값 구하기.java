import java.util.*;

class Solution {
    public int solution(int[] array) {
        int answer = 0;
        int n = array.length;
        
        // // 버블 정렬
        // for(int i = 0; i < n - 1; i++){
        //     for(int j = i + 1; j < n; j++){
        //         if(array[i] > array[j]){
        //             int temp = array[j];
        //             array[j] = array[i];
        //             array[i] = temp;
        //         }
        //     }
        // }
        
        // 선택 정렬
        // for(int i = 0; i < n - 1; i++){
        //     int minIndex = i;
        //     for(int j = i + 1; j < n; j++){
        //         if(array[minIndex] > array[j]){
        //             minIndex = j;
        //         }
        //     }
        //     int temp = array[i];
        //     array[i] = array[minIndex];
        //     array[minIndex] = temp;
        // }
        
        // 삽입 정렬
        // for(int i = 1; i < n; i++){
        //     int key = array[i];
        //     int j = i - 1;
        //     while(j >= 0 && array[j] > key){
        //         array[j + 1] = array[j];
        //         j--;
        //     }
        //     array[j + 1] = key;
        // }
        
        
        // 쉘 정렬
//         for(int gap = n / 2; gap > 0; gap /= 2){
//             for(int i = gap; i < n; i++){
//                 int key = array[i];
//                 int j = i;
                
//                 while(j >= gap && array[j - gap] > key){
//                     array[j] = array[j - gap];
//                     j -= gap;
//                 }
                
//                 array[j] = key;
//             }
//         }
        
        // 퀵 정렬
        // quickSort(array, 0, n - 1);
        
        // 병합 정렬
        // mergeSort(array, 0, n - 1);
        
        Arrays.sort(array);
        
        return array[n / 2];
    }
    
    
    public static void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        int pivot = arr[(left + right) / 2];

        int i = left;
        int j = right;

        while (i <= j) {

            while (arr[i] < pivot) {
                i++;
            }

            while (arr[j] > pivot) {
                j--;
            }

            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

                i++;
                j--;
            }
        }

        if (left < j) {
            quickSort(arr, left, j);
        }

        if (i < right) {
            quickSort(arr, i, right);
        }
    }
    
    public static void mergeSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = (left + right) / 2;

        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);

        merge(arr, left, mid, right);
    }

    public static void merge(int[] arr, int left, int mid, int right) {

        int[] temp = new int[right - left + 1];

        int i = left;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= right) {

            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= right) {
            temp[k++] = arr[j++];
        }

        for (int x = 0; x < temp.length; x++) {
            arr[left + x] = temp[x];
        }
    }
}