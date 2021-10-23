import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CircularShifter extends Filter {
	public CircularShifter(Pipe inPipe, Pipe outPipe) {
		super(inPipe, outPipe);
		// TODO Auto-generated constructor stub
	}

	public static final String separator = " ";

	/*
	 * sub-method to circular shift individual line.This is called from shiftLines
	 * method
	 */
	public List<String> shiftIndividualLine(String inputLine) {

		String inputLineString = inPipe.read();
		String lineToBeShifted = inputLineString;
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
		StringBuilder stringBuilderObj = new StringBuilder(lastWord);
		for (int i = 0; i < lastWordExcludedArray.length; i++) {
			stringBuilderObj.append(separator + lastWordExcludedArray[i]);
		}

		return stringBuilderObj.toString().trim();
	}


	@Override
	void filter() {
		while (inPipe.isNotEmptyOrIsNotClosed()) {
			if (inPipe.hasNext()) {
				String inputLineString = inPipe.read();
				String lineToBeShifted = inputLineString;
				do {
					String[] words = lineToBeShifted.split(separator);
					String circularShiftLine = circularShiftLine(words[words.length - 1],
							Arrays.copyOfRange(words, 0, words.length - 1));
					outPipe.write(circularShiftLine);
					lineToBeShifted = circularShiftLine;
				} while (!lineToBeShifted.equals(inputLineString));

			}
	
		}
		stop();
		outPipe.close();

	}

}
