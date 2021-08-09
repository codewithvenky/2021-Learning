import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class MasterControl {
	private Input i = null;
	private Output out = null;
	private CircularShifter cs = null;
	private Alphabetizer al = null;
	private InputFactory inputFactory = null;
	private OutputFactory outputFactory = null;

	public void start(ScannerWrapper scannerWrapper, SystemWrapper systemWrapper) throws IOException {

	
		systemWrapper.println("Please enter FILE to input from file or CONSOLE to input from console:");
		String input = scannerWrapper.nextLine();
		inputFactory = new InputFactory(scannerWrapper, systemWrapper);
		outputFactory = new OutputFactory(systemWrapper);

		i = inputFactory.create(input);
		systemWrapper.println("Plese enter FILE to output from file or  CONSOLE to output from console");
		String output = scannerWrapper.nextLine();
		out = outputFactory.create(output);

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
