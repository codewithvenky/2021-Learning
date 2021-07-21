import java.util.Arrays;
import java.util.List;

public class CircularShifterMy {

	public List<String> shiftLines(List<String> lines) {
		// TODO Auto-generated method stub
		for (String s : lines) {
			String lies[] = s.split("\\s+");
			String circularStirng = getCicularString(lies);
		}

		return lines;
	}

	private String getCicularString(String[] words) {

		String destString;
		int l = words.length;
		int i = 0;
		String[] subArray = Arrays.copyOfRange(words, 1, l);
		System.out.println(Arrays.toString(subArray));

		return "";
	}

	public static void main(String args[]) {

		CircularShifter cs = new CircularShifter();
		cs.shiftLines(Arrays.asList("Who are you"));

	}

}
