/**
 * https://www.reddit.com/r/dailyprogrammer/comments/55nior/20161003_challenge_286_easy_reverse_factorial/
 */

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;

public class ReverseFactorial {
	private static void reverse(int value) {
		int current = value;
		int i = 2;

		while (current % i == 0) {
			int result = current / i;
			if (result != 1) {
				i++;
				current = result;
			} else {
				System.out.printf("%d = %d\n", value, current);
				break;
			}
		}
		
		System.out.println("None");
	}

	public static void main(String[] args) {
		String inputFile = "input.in";
		try {
			String read = "";
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
