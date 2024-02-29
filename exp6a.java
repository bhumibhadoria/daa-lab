public class exp6a {
    public static void main(String[] args) {
        int[] array = { 7, 2, 9, 1, 5, 10, 3 };

        int min = array[0]; // Assume first element as minimum
        int max = array[0]; // Assume first element as maximum

        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
            if (array[i] > max) {
                max = array[i];
            }
        }

        System.out.println("Minimum: " + min);
        System.out.println("Maximum: " + max);
    }
}
