package homework4;

import java.util.Scanner;

public class Task1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter number: ");
		int userValue = sc.nextInt();
		String star = "*";
		for (int i=0; i<userValue; i++) {
			System.out.println(star);
			star+="*";
		}
		for	(int i=userValue-1; i>0; i--) {
			int a=0;
			while(a<i) {
				System.out.print("*");
				a++;
				}
			System.out.println();	
		}
	}			
}

