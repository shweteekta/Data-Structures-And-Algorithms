public class MatrixProblem {
    public static void main(String[] args) {
        int m = 3;
        int n=3;
        int[][] matrix = {
                {0, 2, 1},
                {1, 15, 1},
                {3,1,0},
        };
        int row = 0;
        int col = 0;
        int maxx = 0;
        while (row<m && col<n){
            maxx = maxx + matrix[row][col];
            if(row==m-1){
                col = col + 1;
            }
            else if(col==n-1){
                row = row + 1;
            }


               else {
                    if(matrix[row + 1][col] < matrix[row][col + 1]) {
                        row = row + 1;
                    }
                    else  {
                        col = col + 1;
                        //System.out.println(col);
                    }
                    //System.out.print(row);
                }



        }
        System.out.println(maxx);


    }
}
