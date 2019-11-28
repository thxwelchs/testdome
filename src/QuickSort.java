import java.util.Arrays;

/**
 * 퀵 정렬 직접 구현해보기
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {45, 15, 5, 33, 96, 4, 7, 0, 3, 120, 97, 50, 60, 70, 65, 43};
        System.out.println("정렬 전 = " + Arrays.toString(arr));
        quickSort(arr);
        System.out.println("정렬 후 = " + Arrays.toString(arr));
    }

    private static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);

    }

    private static void quickSort(int[] arr, int start, int end) {
        int part2 = partition(arr, start, end);
        if(start < part2 - 1) {
            quickSort(arr, start, part2 - 1);
        }
        if(part2 < end) {
            quickSort(arr, part2, end);
        }

    }

    private static int partition(int[] arr, int start, int end) {
        int pivot = arr[(start + end) / 2];
        while(start <= end) {
            while(arr[start] < pivot)  start++;
            while(arr[end] > pivot) end--;
            if(start <= end) {
                swap(arr, start, end);
                start++;
                end--;
            }
        }
        return start;
    }

    private static void swap(int [] arr, int start, int end) {
        int tmp = arr[start];
        arr[start] = arr[end];
        arr[end] = tmp;
    }

}
