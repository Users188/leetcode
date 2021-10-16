/*leetcode:二维子矩阵的和*/
public class NumMatrix {
    private final int[][] matrix;
    public NumMatrix(int[][] matrix){
        this.matrix=matrix;
    }
    public int sumRegion(int row1,int col1,int row2,int col2){
        //暴力解法
        int sum=0;
        for (int i = row1; i <=row2 ; i++) {
            for (int j = col1; j <=col2 ; j++) {
                sum+=matrix[i][j];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] matrix={{1,2,3},{1,2,3},{1,23,3}};
        NumMatrix numMatrix=new NumMatrix(matrix);
        int ans=numMatrix.sumRegion(1,1,2,2);
        System.out.println(ans);
    }
}
