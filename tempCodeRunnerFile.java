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