import java.util.*;
import java.awt.Point;
public class FloodFillAlgorithm
{
	static boolean isValid(int[][] screen, int m, int n, int x, int y, int prevC, int newC)
	{
		if(x < 0 || x >= m || y < 0 || y >= n || screen[x][y] != prevC
		|| screen[x][y]== newC)
			return false;
		return true;
	}


	
	static void floodFill(int[][] screen, int m, int n, int x, int y, int prevC, int newC)
	{
		Vector<Point> queue = new Vector<Point>();

		
		queue.add(new Point(x, y));

		screen[x][y] = newC;

	
		while(queue.size() > 0)
		{
			Point currPixel = queue.get(queue.size() - 1);
			queue.remove(queue.size() - 1);

			int posX = currPixel.x;
			int posY = currPixel.y;

			
			if(isValid(screen, m, n, posX + 1, posY, prevC, newC))
			{
				
				screen[posX + 1][posY] = newC;
				queue.add(new Point(posX + 1, posY));
			}

			if(isValid(screen, m, n, posX-1, posY, prevC, newC))
			{
				screen[posX-1][posY]= newC;
				queue.add(new Point(posX-1, posY));
			}

			if(isValid(screen, m, n, posX, posY + 1, prevC, newC))
			{
				screen[posX][posY + 1]= newC;
				queue.add(new Point(posX, posY + 1));
			}

			if(isValid(screen, m, n, posX, posY-1, prevC, newC))
			{
				screen[posX][posY-1]= newC;
				queue.add(new Point(posX, posY-1));
			}
		}
	}
	
	public static void main(String[] args) {
		int[][] screen ={
		{1, 1, 1, 1, 1, 1, 1, 1},
		{1, 1, 1, 1, 1, 1, 0, 0},
		{1, 0, 0, 1, 1, 0, 1, 1},
		{1, 2, 2, 2, 2, 0, 1, 0},
		{1, 1, 1, 2, 2, 0, 1, 0},
		{1, 1, 1, 2, 2, 2, 2, 0},
		{1, 1, 1, 1, 1, 2, 1, 1},
		{1, 1, 1, 1, 1, 2, 2, 1}};
	
		// Row of the display
		int m = screen.length;
	
		int n = screen.length;
	
		int x = 4;
		int y = 4;
	
		
		int prevC = screen[x][y];
	
	
		int newC = 3;
		floodFill(screen, m, n, x, y, prevC, newC);
	
		
		for(int i = 0; i < m; i++)
		{
			for(int j = 0; j < n; j++)
			{
				System.out.print(screen[i][j] + " ");
			}
			System.out.println();
		}
	}
}

