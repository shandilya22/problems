package highest.sum.submatrix.problem;

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		int row, col, maxWidth, sum, maxSum = 0;
		
		// the size of below 3 arrays can be reduced depending on space constraints.
		int     matrix[][]       = new int[100][100];
		int     subMat[][]       = new int[100][100];
		int     resultantMat[][] = new int[100][100];
		Scanner sc               = new Scanner(System.in);
		
		System.out.println("Input width and height of matrix : ");
		col = sc.nextInt();
		row = sc.nextInt();
		
		System.out.println("Input Matrix with numbers from 0 to 9 : ");
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				matrix[i][j] = sc.nextInt();
			}
		}
		System.out.println("Input maximum width of square submatrix (for square submatrix height and width are same) : ");
		maxWidth = sc.nextInt();
		
		// Below 4 for loops are used to create all possible square submatrix of given
		// maxWidth from a given matrix
		for (int i = maxWidth; i <= row; i++) {
			for (int j = maxWidth; j <= col; j++) {
				for (int k = i - maxWidth, m = 0; k < i; k++, m++) {
					for (int l = j - maxWidth, n = 0; l < j; l++, n++) {
						subMat[m][n] = matrix[k][l];
					}
				}
				sum = findSum(subMat, maxWidth);
				if (sum > maxSum) {
					maxSum = sum;
					
					for (int m = 0; m < maxWidth; m++) {
						for (int n = 0; n < maxWidth; n++) {
							resultantMat[m][n] = subMat[m][n];
						}
					}
				}
			}
		}
		System.out.println("The sub matrix with maximum sum of boundary elements is :");
		for (int m = 0; m < maxWidth; m++) {
			for (int n = 0; n < maxWidth; n++) {
				System.out.print(resultantMat[m][n] + " ");
			}
			System.out.println();
		}
		sc.close();
	}
	
	// this findSum function will calculate sum of boundary elements of the
	// submatrix
	static int findSum(int mat[][], int dim) {
		int sm = 0;
		for (int i = 0; i < dim; i++) {
			for (int j = 0; j < dim; j++) {
				if (i == 0 || j == 0 || i == (dim - 1) || j == (dim - 1)) {
					sm += mat[i][j];
				}
			}
		}
		return sm;
	}
}
