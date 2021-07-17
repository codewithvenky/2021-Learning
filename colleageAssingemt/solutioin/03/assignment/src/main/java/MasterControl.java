import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class MasterControl {
	private Input i = null;
	private Output out = null;
	private CircularShifter cs = null;
	private Alphabetizer al = null;

	public void start(ScannerWrapper scannerWrapper, SystemWrapper systemWrapper) throws IOException {

		//Scanner s = new Scanner(System.in);
		System.out.println("Please enter FILE to input from file or CONSOLE to input from console:");
		String input = scannerWrapper.nextLine();
		if (input.equalsIgnoreCase("FILE")) {
			i = new InputFromFile();
		} else if (input.equalsIgnoreCase("CONSOLE")) {
			i = new InputFromConsole(scannerWrapper, systemWrapper);
		} else {
			System.out.println("Please enter FILE to output from file or CONSOLE to output from console:");
			System.exit(0);
		}
		
		System.out.println("Plese enter FILE to output from file or  CONSOLE to output from console");
		String output = scannerWrapper.nextLine();
		if (output.equalsIgnoreCase("FILE")) {
			out = new OutputToFile();
		} else if (output.equalsIgnoreCase("CONSOLE")) {
			out = new OutputToConsole(systemWrapper);
		} else {
			System.out.println("You have chosen a wrong output kindly choose FILE or CONSOLE");
			System.exit(0);
		}
	

		List<String> inputList = i.read();
		cs = new CircularShifter();
		List<String> csList = cs.shiftLines(inputList);
		al = new Alphabetizer();
		List<String> alList = al.sort(csList);
		out.write(alList);

	}

	public static void main(String args[]) throws IOException {
		MasterControl mc = new MasterControl();
		mc.start(ScannerWrapper.getInstance(), SystemWrapper.getInstance());

	}

}
