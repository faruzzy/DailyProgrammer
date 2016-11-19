// https://www.reddit.com/r/dailyprogrammer/comments/5as91q/20161102_challenge_290_intermediate_blinking_leds/

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;

public class IntermediateBlinkingLEDs {
	private static int[] registerA;
	private static int[] registerB;
	private static int[] bits = new int[] { 7, 6, 5, 4, 3, 2, 1, 0 };

	private static int[] convertToBit(int value) {
		int[] out = new int[bits.length];
		int total = 0;

		for (int k = 0; k < bits.length; k++) {
			double curr = Math.pow(2, bits[k]);
			if (curr <= value && (total + curr) <= value) {
				out[k] = 1;
				total += curr;
			} else {
				out[k] = 0;
			}

			if (total == value)
				break;
		}

		return out;
	}

	private static int convertBitToValue(int[] register) {
		int value = 0;
		for (int k = 0; k < register.length; k++)
			if (register[k] != 0)
				value += Math.pow(2, bits[k]);
		return value;
	}

	private static String LEDRepresentation(int[] arr) {
		StringBuilder sb = new StringBuilder();
		for (int val: arr)
			if (val == 1)
				sb.append("*");
			else
				sb.append(".");
		return sb.toString();
	}

	private static void updateRegister(String s) {
		String[] tokens = s.split(",");
		if (tokens[0].trim().equals("a"))
			registerA = convertToBit(Integer.parseInt(tokens[1]));
		else
			registerB = convertToBit(Integer.parseInt(tokens[1]));
	}

	private static void parseProgram() throws IOException {
		String inputFile = "input1.in";
		String currDir = System.getProperty("user.dir");
		List<String> lines = Files.readAllLines(
				Paths.get(currDir + "/Intermediate/IntermediateBlinkingLEDs/" +  inputFile), StandardCharsets.UTF_8);
		List<String> loopInstructions = new ArrayList<>();

		for (int j = 0; j < lines.size(); j++) {
			String line = lines.get(j);

			int ldIdx = line.indexOf("ld");
			int ldOut = line.indexOf("out");
			int colmIdx = line.indexOf(":");

			if (ldIdx > 0) {
				updateRegister(line.substring(ldIdx + 2));
			}

			int c = line.indexOf(",");
			if (ldOut > 0) {
				String s = line.charAt(c + 1) + "";
				String output = s.equals("a") ? LEDRepresentation(registerA) : LEDRepresentation(registerB);
				System.out.println(output);
			}

			if (colmIdx > 0) {
				int loopCount = convertBitToValue(registerB);
				int k = 0;
				int st = j + 1;

				while (k++ < loopCount)
					for (int h = st; h < lines.size() -1; h++)
						loopInstructions.add(lines.get(h));

                for (String instruction: loopInstructions) {
					ldIdx = instruction.indexOf("ld");
					ldOut = instruction.indexOf("out");
					if (ldIdx > 0) {
						updateRegister(instruction.substring(ldIdx + 2));
					}

					c = instruction.indexOf(",");
					if (ldOut > 0) {
						String s = instruction.charAt(c + 1) + "";
						String output = s.equals("a") ? LEDRepresentation(registerA) : LEDRepresentation(registerB);
						System.out.println(output);
					}
				}
			}
		}
	}

	public static void main(String... args) throws IOException {
		parseProgram();
	}
}
