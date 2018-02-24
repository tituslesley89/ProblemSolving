package matrices;

public class MatrixZeroResolver {

    private static int[][] resolveZeroMatrix(int[][] arr) {
        int x = arr.length,
                y = arr[0].length;

        int[] xArr = prePopulateArray(x),
                yArr = prePopulateArray(y);

        for(int i=0;i<x;i++) {
            for(int j=0;j<y;j++){
                if(arr[i][j] == 0) {
                    xArr[i] = 0;
                    yArr[j] = 0;
                }
            }
        }

        int[][] resolvedMatrix = new int[x][y];

        for(int i=0;i<x;i++) {
            for(int j=0;j<y;j++) {
                if(xArr[i] == 0 || yArr[j] == 0) {
                    resolvedMatrix[i][j] = 0;
                } else {
                    resolvedMatrix[i][j] = arr[i][j];
                }
            }
        }
        return resolvedMatrix;
    }

    private static int[] prePopulateArray(int size) {
        int[] arr = new int[size];
        for(int i=0;i<size;i++) {
            arr[i] = -1;
        }
        return arr;
    }

    public static void main(String[] args) {
        int arr[][] = new int[][]{
                {10,0,5,2,1,2,3,4},
                {1,5,2,4,56,6,2,1},
                {5,0,2,1,20,2,3,0},
                {8,9,3,2,12,3,21,2},
                {6,7,4,3,1,1,3,45}
        };
        System.out.println("Input matrix:");
        printArray(arr);
        System.out.println("\nResolving..");
        int[][] resolvedArray = resolveZeroMatrix(arr);
        System.out.println("Resolved matrix:");
        printArray(resolvedArray);
    }

    private static void printArray(int[][] arr) {
        for(int i=0;i<arr.length;i++) {
            System.out.print('{');
            for(int j=0;j<arr[0].length;j++){
                System.out.print(arr[i][j]+", ");
            }
            System.out.print("}\n");
        }
    }
}
