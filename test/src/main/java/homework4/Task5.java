package Test.test;

public class Task5 {
	     public static void main(String[] args) {
	     int [][] array = new int [5][5];
	         for (int i = 0; i < 5; i++){
	             for (int j = 0; j < 5; j++){
	                 array[i][j]=(int)(Math.random()*20);
	             }
	         }
	         directArray(array);
	         horizont(array);
	         vertical(array);
	         diagonal(array);
	     }
	 
	         public static void directArray(int [][] array){ 
	             System.out.println("Исходный массив: ");                    
	         for (int[] array1 : array) {
	             for (int j = 0; j < array1.length; j++) {
	                 System.out.print(array1[j] + " ");
	             }
	             System.out.println();
	         }
	         System.out.println();
	     }
	         
	        public static void horizont (int [][] array){        
	         System.out.println("Горизонтальное отражение: ");
	         for (int i = array.length - 1; i >= 0; i--){
	             for (int j = 0; j < array[i].length; j++){
	                 System.out.print(array[i][j] + " ");
	             }
	             System.out.println();
	         }
	         System.out.println();
	     } 
	        
	     public static void vertical (int [][] array){
	         String space = "";
	         
	         System.out.println("Вертикальное отражение: ");
	         for (int[] array1 : array) {
	             for (int a = 0; a < 3 * (array.length - array1.length); a++) {
	                 space += " ";
	             }
	             System.out.print(space);
	             space = "";
	             for (int j = array1.length - 1; j >= 0; j--) {
	                 System.out.print(array1[j] + " ");
	             }
	             System.out.println();
	         }
	         System.out.println();
	     }
	     
	     public static void diagonal(int [][] array){
	         String space = "";
	         System.out.println("Горизонтальное и вертикальное отражение: ");
	         for (int i = array.length - 1; i >= 0; i--){
	             for (int a = 0; a < (array.length-array[i].length)*3; a++){
	                     space += " ";
	             }
	             System.out.print(space);
	             space = "";
	             for (int j = array[i].length - 1; j >= 0; j--){
	                 System.out.print(array[i][j] + " ");
	             }
	             System.out.println();
	         }
	 
	     }
	   
	 } 