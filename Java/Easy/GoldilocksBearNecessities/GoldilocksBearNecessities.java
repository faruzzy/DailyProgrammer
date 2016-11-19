// https://www.reddit.com/r/dailyprogrammer/comments/5bn0b7/20161107_challenge_291_easy_goldilocks_bear/
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.List;
import java.util.ArrayList;

public class GoldilocksBearNecessities {
	public static void main(String[] args) throws IOException {
		String inputFile = "challenge_input.in";
		BufferedReader br = new BufferedReader(new FileReader(inputFile));
		String firstLine = br.readLine();
		String[] tokens = firstLine.split(" ");

		int weight = Integer.parseInt(tokens[0]);
		int max = Integer.parseInt(tokens[1]);

		int i = 1;
		List<Integer> output = new ArrayList<>();
		for (String s = br.readLine(); s != null; s = br.readLine()) {
			tokens = s.split(" ");
			int currentWeight = Integer.parseInt(tokens[0]);
			int currentMax = Integer.parseInt(tokens[1]);

			if (currentWeight > weight && currentMax < max) {
				output.add(i);	
			}
			i++;
		}

		for (int value : output)
			System.out.printf("%d ", value);
	}
}
