package Test.test;

import java.util.Scanner;
import java.lang.Object;

public class Task3 {
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter number of columns: ");
		int columns = sc.nextInt();
		System.out.println("Please enter number of rows: ");
		int rows = sc.nextInt();
		int a = 0;
		String s = "";
		for (int i=0; i<rows; i++) {
		while(a<columns) {
			s+="+++***";
			a++;
			} 
		System.out.println(s);
		
		}
		
	}

}
