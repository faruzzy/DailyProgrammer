/**
 * https://www.reddit.com/r/dailyprogrammer/comments/55nior/20161003_challenge_286_easy_reverse_factorial/
 */

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;

public class ReverseFactorial {
	private static void reverse(int value) {
		int number = value;
		int divisor = 2;

		while (number % divisor == 0) {
			number /= divisor;
			divisor++;
		}

		String output = (number == 1) ? String.format("%d = %d!\n", value, divisor -1) : "None"; 
		System.out.print(output);
	}

	public static void main(String[] args) {
		String inputFile = "input.in";
		try {
			String read;
			BufferedReader in = new BufferedReader(new FileReader("input.in"));
			while ((read = in.readLine()) != null) 
				reverse(Integer.parseInt(read));
		} catch (FileNotFoundException e) {
			System.out.printf("File \"%s\" was not found", inputFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
