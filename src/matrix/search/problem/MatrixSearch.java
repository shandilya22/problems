package matrix.search.problem;

public class MatrixSearch {
	
	/*
	 * This method will search an element in a matrix which is sorted row-wise and
	 * column-wise. Time complexity = O(n), Space complexity = O(1)
	 */
	public static int[] search(int element, int[][] matrix) {
		int[] position = { -1, -1 };
		int   rows     = matrix.length;
		int   cols     = matrix[0].length;
		int   i        = 0;
		int   j        = cols - 1;
		
		while (i < rows && j >= 0) {
			if (element == matrix[i][j]) {
				position[0] = i;
				position[1] = j;
				break;
			} else if (element > matrix[i][j]) {
				i += 1;
			} else if (element < matrix[i][j]) {
				j -= 1;
			}
		}
		if (i == rows || j == cols && (position[0] == -1 && position[1] == -1)) {
			System.out.println("Number doesn't exist");
			return null;
		}
		return position;
	}
	
	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 5 }, { 4, 6, 7 }, { 8, 9, 10 } };
		int[]   result = search(7, matrix);
		if (result != null) {
			System.out.println("Element found at [row, column] : " + result[0] + ", " + result[1]);
		}
	}
}
