import java.util.Random;

public class SortMethod {
    // selectio Sort Algor
    public static int selectionSort(int[] arr) {
        int comparisons = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                comparisons++;
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
        return comparisons;
    }

    // Buble Sort Algo
    public static int bubbleSort(int[] arr) {
        int comparisons = 0;
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                comparisons++;
                if (arr[j] > arr[j + 1]) {
                    // swap j and j+!1
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return comparisons;
    }

    // Merge Sort Algo
    public static int mergeSort(int[] arr, int left, int right) {
        int comparisons = 0;
        if (left < right) {
            int mid = (left + right) / 2;
            comparisons += mergeSort(arr, left, mid);
            comparisons += mergeSort(arr, mid + 1, right);
            comparisons += merge(arr, left, mid, right);
        }
        return comparisons;
    }

    private static int merge(int[] arr, int left, int mid, int right) {
        int comparisons = 0;
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] L = new int[n1];
        int[] R = new int[n2];
        for (int i = 0; i < n1; ++i) {
            L[i] = arr[left + i];
        }
        for (int j = 0; j < n2; ++j) {
            R[j] = arr[mid + 1 + j];
        }
        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            comparisons++;
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
        return comparisons;
    }

    // Quick Sort Algor
    public static int quickSort(int[] arr, int low, int high) {
        int comparisons = 0;
        if (low < high) {
            int pi = partition(arr, low, high);
            comparisons += quickSort(arr, low, pi - 1);
            comparisons += quickSort(arr, pi + 1, high);
        }
        return comparisons;
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    // generates array with rand vals
    public static int[] generateRandomArray(int size) {
        int[] arr = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(10001); // Generate rand nums 0 - 10,000
        }
        return arr;
    }

    // copy array
    public static int[] copyArray(int[] arr) {
        int[] copy = new int[arr.length];
        System.arraycopy(arr, 0, copy, 0, arr.length);
        return copy;
    }

    // Data to sort mehtods
    public static int gatherData(int[] arr, String sortMethod) {
        int comparisons = 0;
        int[] copy = copyArray(arr);
        switch (sortMethod) {
            case "SelectionSort":
                comparisons = selectionSort(copy);
                break;
            case "BubbleSort":
                comparisons = bubbleSort(copy);
                break;
            case "MergeSort":
                comparisons = mergeSort(copy, 0, copy.length - 1);
                break;
            case "QuickSort":
                comparisons = quickSort(copy, 0, copy.length - 1);
                break;
            // Add cases for sorting methods
        }
        return comparisons;
    }     public static void main(String[] args) {
        int[] arraySizes = {2000, 4000, 6000, 8000, 10000};
        String[] sortMethods = {"SelectionSort", "BubbleSort", "MergeSort", "QuickSort"};
        int[][] comparisonsData = new int[sortMethods.length][arraySizes.length];
        
        // Gather data tha sort methods and array sizes
        for (int i = 0; i < arraySizes.length; i++) {
            int size = arraySizes[i];
            int[] arr = generateRandomArray(size);
            for (int j = 0; j < sortMethods.length; j++) {
                String method = sortMethods[j];
                int comparisons = gatherData(arr, method);
                comparisonsData[j][i] = comparisons;
            }
        }
        
        // Print
        for (int i = 0; i < sortMethods.length; i++) {
            System.out.println(sortMethods[i] + " comparisons:");
            for (int j = 0; j < arraySizes.length; j++) {
                System.out.println("Size " + arraySizes[j] + ": " + comparisonsData[i][j]);
            }
            System.out.println();
        }
    }
}
