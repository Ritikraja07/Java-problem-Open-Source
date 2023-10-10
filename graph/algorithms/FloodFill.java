package graph.algorithms;

public class FloodFill {

    public static void floodFill(int[][] image, int sr, int sc, int newColor) {
        int rows = image.length;
        int cols = image[0].length;
        int oldColor = image[sr][sc];

        if (oldColor != newColor) {
            dfs(image, sr, sc, oldColor, newColor, rows, cols);
        }
    }

    public static void dfs(int[][] image, int row, int col, int oldColor, int newColor, int rows, int cols) {
        if (row < 0 || row >= rows || col < 0 || col >= cols || image[row][col] != oldColor) {
            return;
        }

        image[row][col] = newColor;

        dfs(image, row - 1, col, oldColor, newColor, rows, cols);
        dfs(image, row + 1, col, oldColor, newColor, rows, cols);
        dfs(image, row, col - 1, oldColor, newColor, rows, cols);
        dfs(image, row, col + 1, oldColor, newColor, rows, cols);
    }

    public static void main(String[] args) {
        int[][] image = {
            {1, 1, 1},
            {1, 1, 0},
            {1, 0, 1}
        };

        int sr = 1, sc = 1, newColor = 2;

        floodFill(image, sr, sc, newColor);

        System.out.println("Flood-Filled Image:");
        for (int[] row : image) {
            for (int pixel : row) {
                System.out.print(pixel + " ");
            }
            System.out.println();
        }
    }
}



   
// Description of the above code:

// 1. The `FloodFill` class contains three methods: `floodFill`, `dfs`, and `main`.

// 2. `floodFill` method:
//    - This method serves as the entry point for the flood fill algorithm.
//    - It takes four parameters:
//      - `image`: A 2D integer array representing the image where the flood fill should be performed.
//      - `sr` and `sc`: The starting row and column coordinates from where the flood fill should begin.
//      - `newColor`: The new color that should replace the old color in the connected region.
//    - It gets the dimensions of the `image` (number of rows and columns) and stores them in `rows` and `cols`.
//    - It retrieves the old color from the `image` at the starting coordinates `(sr, sc)`.
//    - If the old color is not equal to the new color, it calls the `dfs` method to perform the flood fill.

// 3. `dfs` method:
//    - This is a recursive depth-first search (DFS) function that performs the actual flood fill.
//    - It takes six parameters:
//      - `image`: The 2D integer array representing the image.
//      - `row` and `col`: The current row and column coordinates being processed.
//      - `oldColor`: The old color that needs to be replaced.
//      - `newColor`: The new color to fill the region with.
//      - `rows` and `cols`: The dimensions of the image.
//    - It checks if the current coordinates are outside the image boundaries or if the pixel at `(row, col)` does not match the old color. In such cases, it returns, indicating that this branch of the recursion should stop.
//    - If the conditions are met, it updates the color at `(row, col)` to the new color.
//    - Then, it recursively calls `dfs` for the four neighboring pixels (up, down, left, and right), continuing the flood fill process.

// 4. `main` method:
//    - In the `main` method, an example image represented by a 2D array `image` is defined.
//    - The starting row (`sr`), starting column (`sc`), and the new color (`newColor`) are specified.
//    - The `floodFill` method is called with these parameters to perform the flood fill.
//    - Finally, the modified image is printed to the console to display the result.

// The code demonstrates how to use the flood fill algorithm to replace a connected region of pixels with a new color in a 2D image.

/*The provided Java code implements the flood fill algorithm to change the color of a connected region in a 2D image. It starts from a given pixel and recursively fills adjacent pixels of the same original color with a new color. Here's a short description:

The `floodFill` method:
- Takes an image represented as a 2D array, a starting pixel (sr, sc), and a new color.
- Checks if the old color at the starting pixel is different from the new color.
- If they are different, it calls the `dfs` method to perform the flood fill.

The `dfs` method:
- Recursively explores neighboring pixels in four directions (up, down, left, right).
- Changes the color of each visited pixel to the new color.
- Stops when it encounters out-of-bounds pixels or pixels with colors different from the old color.

In the `main` method:
- An example image is provided as a 2D array.
- A starting point (sr, sc) and a new color are specified.
- The `floodFill` method is called to fill the connected region starting from the specified point with the new color.
- The resulting image is printed to the console.*/

