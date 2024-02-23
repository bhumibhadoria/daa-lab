public class exp5 {

    public static int[][] strassenMultiply2x2(int[][] A, int[][] B) {
        // Calculate the products required for the result matrix
        int M1 = (A[0][0] + A[1][1]) * (B[0][0] + B[1][1]);
        int M2 = (A[1][0] + A[1][1]) * B[0][0];
        int M3 = A[0][0] * (B[0][1] - B[1][1]);
        int M4 = A[1][1] * (B[1][0] - B[0][0]);
        int M5 = (A[0][0] + A[0][1]) * B[1][1];
        int M6 = (A[1][0] - A[0][0]) * (B[0][0] + B[0][1]);
        int M7 = (A[0][1] - A[1][1]) * (B[1][0] + B[1][1]);

        // Calculate the result matrix
        int[][] C = new int[2][2];
        C[0][0] = M1 + M4 - M5 + M7;
        C[0][1] = M3 + M5;
        C[1][0] = M2 + M4;
        C[1][1] = M1 - M2 + M3 + M6;

        return C;
    }

    public static void main(String[] args) {
        int[][] A = { { 1, 2 }, { 3, 4 } };
        int[][] B = { { 5, 6 }, { 7, 8 } };

        int[][] C = strassenMultiply2x2(A, B);

        // Output the result matrix
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(C[i][j] + " ");
            }
            System.out.println();
        }
    }
}
