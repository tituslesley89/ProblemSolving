package matrices;

public class MatrixSubmatrix {

    public static int[][] constructSubmatrix(int[][] matrix, int[] rowsToDelete, int[] columnsToDelete) {
        int r = matrix.length,
                c = matrix[0].length;

        int finalR = r - rowsToDelete.length,
                finalC = c - columnsToDelete.length;

        int[][] finalMatrix = new int[finalR][finalC];

        int finalRPtr = 0, finalCPtr = 0;

        int curDelRow = 0;
        for(int iR=0;iR<r;iR++) {
            if(iR == rowsToDelete[curDelRow]) {
                curDelRow = curDelRow + 1 >= rowsToDelete.length ? curDelRow : curDelRow + 1;
            } else {
                int curDelCol = 0;
                for(int jC=0;jC<c;jC++) {
                    if(jC == columnsToDelete[curDelCol]) {
                        curDelCol = curDelCol + 1 >= columnsToDelete.length ? curDelCol : curDelCol + 1;
                    } else {
                        finalMatrix[finalRPtr][finalCPtr] = matrix[iR][jC];
                        finalCPtr++;
                    }
                }
                finalRPtr++;
            }
        }

        return finalMatrix;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                { 5, 0, 0, 4, 3},
                { 0, 1, 0, 0, 2},
                { 0, 8, 9, 0, 0},
                { 0, 6, 0, 10, 11},
                { 0, 3, 6, 9, 0}
        };

        int[] rowsToDelete = new int[] { 1,2,4};
        int[] colToDelete = new int[] { 1,2};
        int[][] finalMatrix = constructSubmatrix(matrix, rowsToDelete, colToDelete);

        System.out.println(finalMatrix);
    }
}
