import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CircularShifter extends Filter {
	public CircularShifter(Pipe inPipe, Pipe outPipe) {
		super(inPipe, outPipe);
	}

	public static final String separator = " ";

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
