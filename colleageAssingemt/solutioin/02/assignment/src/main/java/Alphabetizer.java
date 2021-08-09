import java.util.Arrays;
import java.util.List;

public class Alphabetizer {
	/*
	 * This method will do a bubble sort on the passed List of circularly shifted
	 * strings
	 */
	public List<String> sort(List<String> lines) {
		String[] linesArray = lines.toArray(new String[0]);
		// i,j are loop control variables
		for (int i = 0; i < linesArray.length - 1; i++) {
			for (int j = i + 1; j < linesArray.length; j++) {
				if (linesArray[i].toLowerCase().charAt(0) > linesArray[j].toLowerCase().charAt(0)) {
					String temp = linesArray[i];
					linesArray[i] = linesArray[j];
					linesArray[j] = temp;
				}

			}
		}
		List<String> sortedItems = Arrays.asList(linesArray);

		return sortedItems;
	}

}
