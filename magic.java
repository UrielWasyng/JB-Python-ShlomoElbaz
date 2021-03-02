import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

public class magic {
	static int ROW, COL, riverSize;

	// A function to check if a given cell (row, col)
	// can be included in find
	static boolean check(int[][] M, int row, int col,
						boolean[][] visited)
	{
		// row number is in range, column number is in
		// range and value is 1 and not yet visited
		return (
			(row >= 0) && (row < ROW) && (col >= 0)
			&& (col < COL)
			&& (M[row][col] == 1 && !visited[row][col]));
	}

	// A utility function to do find for a 2D boolean
	// matrix. It only considers the 8 neighbours as
	// adjacent vertices
	static void find(int[][] M, int row, int col,
					boolean[][] visited)
	{
		// These arrays are used to get row and column
		// numbers of 8 neighbours of a given cell
		int[] rowNbr = {  -1, 0, 0, 1 };
		int[] colNbr = {  0, -1, 1, 0 };

		// Mark this cell as visited
		visited[row][col] = true;

		// Recur for all connected neighbours
		for (int k = 0; k < 4; k++) 
		{
			if (check(M, row + rowNbr[k], col + colNbr[k],
					visited)) 
			{
				// increment region length by one
				riverSize++;
				find(M, row + rowNbr[k], col + colNbr[k],
					visited);
			}
		}
	}

	// The main function that returns largest length region
	// of a given boolean 2D matrix
	static List<Integer> getarray(int[][] M)
	{
		// Make a boolean array to mark visited cells.
		// Initially all cells are unvisited
		boolean[][] visited = new boolean[ROW][COL];
		List<Integer> riversSize = new ArrayList<Integer>();

		// Initialize result as 0 and traverse through the
		// all cells of given matrix
		int result = 0;
		for (int i = 0; i < ROW; i++) 
		{
			for (int j = 0; j < COL; j++) 
			{

				// If a cell with value 1 is not
				if (M[i][j] == 1 && !visited[i][j]) 
				{

					// visited yet, then new region found
					riverSize = 1;
					find(M, i, j, visited);
                    riversSize.add(riverSize);
                    
				}
			}
		}
		
		
		Collections.sort(riversSize);
		return  riversSize;
	}

	

	// Driver code
	public static void main(String args[])
	{
		int arr1[][] = { { 1, 0, 0, 1 },
				{ 0, 0, 1, 0 },
				{ 1, 0, 0, 0 },
				{ 1, 0, 0, 0 } };
		ROW = 4;
		COL = 4;
	
		// Function call 1
		System.out.println(getarray(arr1));
		
				
			int arr2[][] = { { 0, 0, 0, 1, 0, 0, 0, 1 },
					{ 1, 1, 0, 0, 0, 0, 1, 0 },
					{ 0, 0, 0, 0, 1, 1, 0, 1 },
					{ 1, 1, 1, 0, 0, 0, 0, 0 } };
			ROW = 4;
			COL = 8;

			// Function call 2
			System.out.println(getarray(arr2));
	
	
			int arr3[][] = { { 0, 0, 0, 0, 1 },
					{ 0, 1, 1, 1, 0 },
					{ 0, 1, 0, 1, 0 },
					{ 0, 1, 1, 1, 0 },
					{ 1, 0, 0, 0, 0 } };
			ROW = 5;
			COL = 5;

			// Function call 3
			System.out.println(getarray(arr3));	
		
		
	}	
}
