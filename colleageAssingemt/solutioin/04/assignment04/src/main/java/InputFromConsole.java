import java.util.ArrayList;
import java.util.List;

public class InputFromConsole implements Input {

	private ScannerWrapper scannerWrapper;
	private SystemWrapper systemWrapper;

	public InputFromConsole(ScannerWrapper scannerWrapper, SystemWrapper systemWrapper) {
		super();
		this.scannerWrapper = scannerWrapper;
		this.systemWrapper = systemWrapper;
	}

	@Override
	public List<String> read() {
		List<String> list = new ArrayList<String>();
		ScannerWrapper sw = ScannerWrapper.getInstance();
		while (sw.hasNext()) {
			String inputLine = sw.nextLine();
			if (inputLine.equals("-1"))
				break;
			list.add(inputLine);

		}

		return list;
	}

}
