import java.util.Arrays;
import java.util.Random;

public class HeapSort {
    public static void heapSort(Integer[] values) {
        int n = values.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            maxHeapify(values, n, i);
        }
        for (int i = n - 1; i > 0; i--) {
            swap(values, 0, i);
            maxHeapify(values, i, 0);
        }
    }

    private static void maxHeapify(Integer[] values, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < n && values[left] > values[largest]) {
            largest = left;
        }
        if (right < n && values[right] > values[largest]) {
            largest = right;
        }
        if (largest != i) {
            swap(values, i, largest);
            maxHeapify(values, n, largest);
        }
    }

    private static void swap(Integer[] values, int i, int j) {
        int temp = values[i];
        values[i] = values[j];
        values[j] = temp;
    }

    public static void main(String[] args) {
        int size = 20;
        Integer[] list = new Integer[size];

        for (int i = 0; i < list.length; i++) {
            list[i] = new Random().nextInt(50);
        }

        System.out.println("Unsorted List: " + Arrays.toString(list));
        heapSort(list);
        System.out.println("  Sorted List:" + Arrays.toString(list));
    }
}
