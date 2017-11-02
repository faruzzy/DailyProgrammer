/*
 *  https://www.reddit.com/r/dailyprogrammer/comments/5aemnn/20161031_challenge_290_easy_kaprekar_numbers/
 *  In mathematics, a Kaprekar number for a given base is a non-negative integer,
 *  the representation of whose square in that base can be split into two parts that add up to the original number again.
 *  For instance, 45 is a Kaprekar number, because 452 = 2025 and 20+25 = 45. The Kaprekar numbers are named after D. R. Kaprekar.
 *  I was introduced to this after the recent Kaprekar constant challenge.
 *  For the main challenge we'll only focus on base 10 numbers. For a bonus, see if you can make it work in arbitrary bases.
 *
 * *****************************
 * Input Description
 * ****************************
 * Your program will receive two integers per line telling you the start and end of the range to scan, inclusively.
 * Example:
 * 1 50
 *
 * ****************************
 * Output Description
 * ****************************
 * Your program should emit the KaprekarNumberar numbers in that range. From our example:
 * 45
 *
 * ****************************
 * Challenge Input
 * ****************************
 * 2 100
 * 101 9000
 *
 * ****************************
 * Challenge Output
 * ****************************
 * 9 45 55 99
 * 297 703 999 2223 2728 4879 5050 5292 7777
 *
 */

import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.BufferedReader;

public class KaprekarNumber {
	public static void main(String... args) {
		String inputFile = "input.in";
		try {
			BufferedReader in = new BufferedReader(new FileReader(inputFile));
			for (String s = in.readLine(); s != null; s = in.readLine()) {
				String[] params = s.split(" ");
				int a = Integer.parseInt(params[0]);
				int b = Integer.parseInt(params[1]);
				System.out.println(K(a, b));
			}
			in.close();
		} catch(FileNotFoundException cx) {
			System.out.printf("File \"%s\" was not found", inputFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static String K(int s, int e) {
		StringBuilder sb = new StringBuilder();
		for (int i = s; i <= e; i++) {
			double pow = Math.pow(i, 2);
			String powStr = Double.toString(pow);
			int idx = powStr.indexOf(".");
			powStr = powStr.substring(0, idx);

			if (powStr.length() > 1) {
				for (int k = 1; k < powStr.length(); k++) {
					int left = Integer.parseInt(powStr.substring(0, k));
					int right = Integer.parseInt(powStr.substring(k));

					if (left < i && right < i) {
						if (left + right == i) {
							sb.append(String.format("%d ", i));
						}
					}
				}
			}
		}

		return sb.toString();
	}
}
