package third.max.problem;

public class ThirdMax {
	
	/*
	 * This method will find 3rd max in an array Time complexity = O(n), Space
	 * complexity : O(1)
	 */
	public static int getThirdMax(int[] array) {
		int firstMax  = array[0];
		int secondMax = array[0];
		int thirdMax  = array[0];
		
		for (int i = 1; i < array.length; i++) {
			if (array[i] > firstMax) {
				thirdMax  = secondMax;
				secondMax = firstMax;
				firstMax  = array[i];
			} else if ((array[i] > secondMax && array[i] != firstMax) || firstMax == secondMax) {
				thirdMax  = secondMax;
				secondMax = array[i];
			} else if ((array[i] > thirdMax && array[i] != firstMax && array[i] != secondMax)
			        || (thirdMax == firstMax || thirdMax == secondMax)) {
				thirdMax = array[i];
			}
		}
		
		if ((firstMax == secondMax && secondMax == thirdMax) || secondMax == thirdMax) {
			System.out.println("3rd max doesn't exist");
			thirdMax = -1;
		}
		
		return thirdMax;
	}
	
	public static void main(String[] args) {
		int[] arr = { -1, -2, -3 };
		System.out.println(getThirdMax(arr));
	}
}