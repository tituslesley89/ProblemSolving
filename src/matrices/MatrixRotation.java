package matrices;

public class MatrixRotation {
    private static int[][] rotateMatrix(int[][] m, int n) {

        int layer = (int)Math.floor(n/2),
                temp;
        for(int l=0;l<layer;l++) {
            int start = l,
                    end = n-1-l;
            for(int i=start;i<end;i++) {
                //save top
                temp = m[start][start + i];

                //left -> top
                m[start][start + i] = m[end - i][start];

                //bottom -> left
                m[end-i][start] = m[end][end - i];

                //right -> bottom
                m[end][end-i] = m[start + i][end];

                //top -> right
                m[start+i][end] = temp;
            }
        }
        return m;
    }

    public static void main(String[] args) {
        int n = 4, count=0;
        int[][] matrix = new int[n][n];
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++){
                matrix[i][j] = count;
                count++;
            }
        System.out.println("Original matrix:");
        printMatrix(matrix, n);
        matrix = rotateMatrix(matrix, n);
        System.out.println("Matrix after rotation:");
        printMatrix(matrix, n);
    }

    private static void printMatrix(int[][] matrix, int n) {
        for(int i=0;i<n;i++) {
            System.out.println();
            for(int j=0;j<n;j++) {
                System.out.print(matrix[i][j]+",");
            }
        }
        System.out.println();
    }
}
