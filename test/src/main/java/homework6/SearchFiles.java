package homework6;

import java.io.IOException;
import java.util.Scanner;
import java.nio.file.Paths;
import java.nio.file.*;
import java.util.stream.Stream;
import java.util.stream.Collectors;

public class SearchFiles {

	private static Scanner sc;
	private static Stream<Path> searchFilter;

	private static void search(Path dir, int depth) throws IOException {
		searchFilter = Files.walk(dir, depth);
		{
			String filesOutput = searchFilter.map(String::valueOf).filter(path -> path.endsWith(".java")).sorted()
					.collect(Collectors.joining("\n"));
			System.out.println(filesOutput);
		}
	}

	public static void main(String[] args) throws IOException {
		sc = new Scanner(System.in);
		System.out.println("Введите директорию: ");
		String directory = sc.nextLine();
		Path dir = Paths.get(directory);
		System.out.println("Глубина: ");
		int depth = sc.nextInt();

		search(dir, depth);
	}

}