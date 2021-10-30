import java.util.List;

public class MasterControl {
	public static void main(String[] args) {
		MasterControl masterControlInstance = new MasterControl();
masterControlInstance.start(new PipeList(), new PipeQueue(), new PipeList());
	}

	public void start(Pipe inputPipe,Pipe circularShiftPipe,Pipe alphabetizerPipe) {
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
