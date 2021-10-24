package Arrays;

/*leetcode:二维子矩阵的和*/
/*最佳解法：利用二维前缀和（大矩阵减去小矩阵）*/
public class NumMatrix {
    private int[][] matrix = null;
    private int[][] preSums = null;

    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
        //前缀和减少运算
        int rows = matrix.length;
        if (rows > 0) {
            int cols = matrix[0].length;
            preSums = new int[rows][cols + 1];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    //preSum[0][j]=0
                    preSums[i][j + 1] = preSums[i][j] + matrix[i][j];
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {1, 2, 3}, {1, 23, 3}};
        NumMatrix numMatrix = new NumMatrix(matrix);
        int ans1 = numMatrix.sumRegion_modified(1, 1, 2, 2);
        int ans2 = numMatrix.sumRegion(1, 1, 2, 2);
        System.out.println(ans1);
        System.out.println(ans2);
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        //暴力解法
        int sum = 0;
        for (int i = row1; i <= row2; i++) {
            for (int j = col1; j <= col2; j++) {
                sum += matrix[i][j];
            }
        }
        return sum;
    }

    public int sumRegion_modified(int row1, int col1, int row2, int col2) {
        int sum = 0;
        //二维变一维
        for (int i = row1; i <= row2; i++) {
            //col2+1是因为preSum[i+1]对应为matrix（0到i）的和
            sum += preSums[i][col2 + 1] - preSums[i][col1];
        }
        return sum;
    }
}
