// https://www.reddit.com/r/dailyprogrammer/comments/5aemnn/20161031_challenge_290_easy_kaprekar_numbers/
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
