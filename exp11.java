import java.util.Random;
public class exp11 {

    static Random random = new Random();

    // Function to perform randomized quicksort
    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    // Function to partition the array
    static int partition(int[] arr, int low, int high) {
        // Choose a random pivot element
        int randomIndex = random.nextInt(high - low + 1) + low;
        swap(arr, randomIndex, high);

        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    // Utility function to swap two elements in an array
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Function to print the array
    static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = { 10, 7, 8, 9, 1, 5 };
        int n = arr.length;
        System.out.println("Original array:");
        printArray(arr);
        quickSort(arr, 0, n - 1);
        System.out.println("Sorted array:");
        printArray(arr);
    }
}
