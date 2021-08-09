import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CircularShifter {

	public static final String separator = " ";

	/*
	 * Method used for circularly shifting all the input lines from kwic.txt file
	 */
	public List<String> shiftLines(List<String> lines) {
		List<String> circularShiftedStringsList = new ArrayList<String>();
		if (lines.size() > 0) {
			for (String s : lines) {
				circularShiftedStringsList.addAll(shiftIndividualLine(s));
			}
		}
		return circularShiftedStringsList;
	}

	/*
	 * sub-method to circular shift individual line.This is called from shiftLines
	 * method
	 */
	public static List<String> shiftIndividualLine(String inputLine) {

		String inputLineString = inputLine;
		String lineToBeShifted = inputLine;
		List<String> circularShiftedStringsPerLine = new ArrayList<String>();

		do {
			String[] words = lineToBeShifted.split(separator);
			String circularShiftLine = circularShiftLine(words[words.length - 1],
					Arrays.copyOfRange(words, 0, words.length - 1));
			circularShiftedStringsPerLine.add(circularShiftLine);

			lineToBeShifted = circularShiftLine;
		} while (!lineToBeShifted.equals(inputLineString));
		return circularShiftedStringsPerLine;
	}

	/*
	 * sub-method that has code to shift the words. This is called from
	 * shiftIndividualLine.
	 */
	public static String circularShiftLine(String lastWord, String[] lastWordExcludedArray) {
		StringBuilder sb = new StringBuilder(lastWord);
		for (int i = 0; i < lastWordExcludedArray.length; i++) {
			sb.append(separator + lastWordExcludedArray[i]);
		}

		return sb.toString().trim();
	}

}
