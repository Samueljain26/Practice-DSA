class RotateImage {
    public void rotate(int[][] matrix) {
        // int n = matrix.length;
        // int[][] temp = new int[n][n];

        // for (int i =0; i<n; i++) {
        //     for (int j=0; j<n; j++) {
        //         temp[j][n-i-1] = matrix[i][j];
        //     }
        // }

        // for (int i = 0; i <n; i++) {
        //     for (int j=0; j < n; j++) {
        //         matrix[i][j] = temp[i][j];
        //     }
        // }
    
        int n = matrix.length;

        //transpose
        for (int i=0; i<n; i++) {
            for (int j=i; j<n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        //reverse
        for (int i=0; i<n; i++) {
            for (int j = 0; j < n/2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }
    }
}