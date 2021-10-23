import java.util.List;

public class MasterControl {
	public static void main(String[] args) {
		MasterControl masterControlInstance = new MasterControl();
		masterControlInstance.start();
	}

	/*
	 * This method reads Strings from kwic.txt and circular shifts the input strings
	 * & then alphabetizes them. Finally writes them to kwic_output.txt
	 */
	public void start() {
		Pipe inputPipe = new Pipe();
		Pipe circularShiftPipe = new Pipe();
		Pipe alphabetizerPipe = new Pipe();
	
		try {
			Input inputInstance = new Input(null, inputPipe);
			CircularShifter circularShifterInstance = new CircularShifter(inputPipe, circularShiftPipe);
			Alphabetizer alphabetizerInstance = new Alphabetizer(circularShiftPipe, alphabetizerPipe);
			Output outputInstance = new Output(alphabetizerPipe,null);
			inputInstance.start();
			circularShifterInstance.start();
			alphabetizerInstance.start();
			outputInstance.start();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
