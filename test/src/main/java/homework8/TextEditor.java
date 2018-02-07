package homework8;
/*
Написать программу Text editor 
Программа позволяет пользователю, взаимодействуя с консолью записывать в файл.
Программа завершается, если наберу слово “exit”
По завершению программы, вывести статистику файла:
Содержимое файла в консоль.
Общее количество символов
Номер строки с самым большим количеством гласных
количество слов 

 */

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;

public class TextEditor {

	public static void main(String[] args) throws IOException {
		String file = "/Users/andrew/git/Homework_sourceIT/test/src/main/java/newFile1.txt";
		fillingFile();
		reader(file);
		counter(file);
		vowels(file);

	}

	private static void fillingFile() throws IOException {
		File file = new File("/Users/andrew/git/Homework_sourceIT/test/src/main/java/newFile1.txt");

		if (!file.exists())
			file.createNewFile();

		FileWriter fw = new FileWriter(file.getAbsoluteFile());
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(fw);
		while (true) {
			String nextLine = br.readLine();
			if (nextLine.equals("exit"))
				break;
			bw.write(nextLine + "\n");
		}
		br.close();
		bw.close();
	}

	private static void reader(String fileName) throws IOException {
		File file = new File(fileName);
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String line;
		System.out.println("File consists of the following text:");
		while ((line = br.readLine()) != null) {
			System.out.println(line);
		}
		br.close();
		fr.close();

	}

	public static void counter(String fileName) throws IOException {
		int charsCount = 0;
		int wordsCount = 0;
		File file = new File(fileName);

		Scanner fileScanner = new Scanner(file);

		while (fileScanner.hasNextLine()) {
			String line = fileScanner.nextLine();
			Scanner lineScanner = new Scanner(line);

			while (lineScanner.hasNext()) {
				wordsCount++;
				String word = lineScanner.next();
				charsCount += word.length();
			}

			lineScanner.close();
		}

		System.out.println("Number of chars (no spaces): " + charsCount);
		System.out.println("Number of words: " + wordsCount);
		fileScanner.close();
	}


	private static void vowels(String fileName) throws IOException {
		File file = new File(fileName);
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String line;
		int lineNumber = 0;
		while ((line = br.readLine()) != null) {
			lineNumber++;
			int vowels = 0;
			for (int i = 0; i < line.length(); i++) {
				
				if (line.charAt(i) == 'a' || line.charAt(i) == 'e' || line.charAt(i) == 'i' || line.charAt(i) == 'o'
						|| line.charAt(i) == 'u' || line.charAt(i) == 'y') {
					vowels++;
				
				}
				
			}
			System.out.println("Number of vowels in line " + lineNumber + ": " + vowels);
		}
		br.close();
		fr.close();

	}
}
