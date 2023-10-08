/*
Boolean Matrix
Link Of Problem - https://practice.geeksforgeeks.org/problems/boolean-matrix-problem-1587115620/1
*/

class BooleanMatrix
{
    //Function to modify the matrix such that if a matrix cell matrix[i][j]
    //is 1 then all the cells in its ith row and jth column will become 1.
    void booleanMatrix(int matrix[][])
    {
        // code here 
        int R = matrix.length;
        int C = matrix[0].length;
        boolean row[] = new boolean[R];
        boolean col[] = new boolean[C];
        int i ,j ;
        for(i=0;i<R;i++){
            row[i] = false;
        }
        for( i=0;i<C;i++){
            col[i] = false;
        }
        for( i=0;i<R;i++){
            for( j=0;j<C;j++){
                if(matrix[i][j]==1){
                    row[i] = true;
                    col[j] = true;
                }
            }
        }
        for( i=0;i<R;i++){
            for( j=0;j<C;j++){
                if(row[i]==true || col[j]==true){
                    matrix[i][j] = 1;
                }
            }
        }
    }
}
