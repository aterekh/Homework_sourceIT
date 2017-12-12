package Test.test;

import java.util.Arrays;

public class Task4 {
	public static void main(String[] args) {
		int[] startArray = {1,2,3,4,5,6,7,8,9,10};
		int[] doubleArray = new int[10];
		int[] finalArray = new int[20];
		for (int i=0; i < startArray.length; i++) {
			doubleArray[i]=startArray[i]*2;
		}
		System.arraycopy(startArray, 0, finalArray, 0, 10);
		System.arraycopy(doubleArray, 0, finalArray, 10, 10);
		String finalArr = Arrays.toString(finalArray);
		System.out.println("Array with double values:");
		System.out.println(finalArr);
		
	}
}
