import java.io.IOException;
import java.util.List;

public class MasterControl {
	private Input i =null;
	private Output out=null;
	private CircularShifter cs= null;
	private Alphabetizer al = null;

	public void start(ScannerWrapper scannerWrapper, SystemWrapper systemWrapper) {

		 i = new Input();
		 out = new Output();
		List<String> input = i.read(scannerWrapper, systemWrapper);
		 cs = new CircularShifter();
		List<String> csList = cs.shiftLines(input);
		
		 al = new Alphabetizer();
		List<String> alList = al.sort(csList);
		out.write(alList, systemWrapper);

	}

	public static void main(String args[]) throws IOException {
		MasterControl mc = new MasterControl();
		mc.start(ScannerWrapper.getInstance(), SystemWrapper.getInstance());

	}

}
