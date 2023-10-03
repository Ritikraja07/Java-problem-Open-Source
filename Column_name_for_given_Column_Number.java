class Solution
{
    //Function to return list of integers that form the boundary 
    //traversal of the matrix in a clockwise manner.
    static ArrayList<Integer> boundaryTraversal(int matrix[][], int n, int m)
    {
        // code here 
        ArrayList<Integer> al = new ArrayList<Integer>();
        for (int i = 0; i < m; i++) {
            al.add(matrix[0][i]);
        }
        for (int i = 1; i < n; i++) {
            al.add(matrix[i][m - 1]);
        }
        // Check if there is more than one row in the matrix
        if (n > 1) {
            for (int i = m - 2; i >= 0; i--) {
                al.add(matrix[n - 1][i]);
            }
        }
        // Check if there is more than one column in the matrix
        if (m > 1) {
            for (int i = n - 2; i > 0; i--) {
                al.add(matrix[i][0]);
            }
        }
        return al;
    }
}
