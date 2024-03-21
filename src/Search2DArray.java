
public class Search2DArray {

    public static void main(String args[])
    {
        int[][] mat = {{2,3,5,7}, {10,11,16,20}, {23,30,34,60}};
        System.out.print(findTargetInMatrix(mat,3,4,1));

    }

        static boolean findTargetInMatrix(int[][] mat, int m, int n, int target) {


            int startRow = 0;
            int endRow = m-1;
            int result = -1;

            if(target > mat[m-1][n-1]){
                return false;
            }


            while(startRow < endRow){
                int middleRow = (startRow + endRow )/2 ;
                if(mat[middleRow][0] == target){
                    return true;
                }
                else if (mat[middleRow][0] < target && target < mat[middleRow][n-1]){
                    result = middleRow;
                    break;
                }
                else if (mat[middleRow][0] > target){
                    endRow = middleRow - 1;
                }
                else if(mat[middleRow][0] < target){
                    startRow = middleRow;
                }
            }
            if(result != -1){
                int low = 0;
                int high = n-1;
                while(low<high){
                    int mid = (low + high ) / 2;
                    if (mat[result][mid] == target){
                        return true;
                    }
                    else if (mat[result][mid] > target ){
                        high = mid;
                    }
                    else{
                        low = mid + 1;
                    }
                }
            }
            System.out.println(startRow + " " + endRow + " " + result);

            return false;

    }

}
