import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Input {

	public List<String> read(ScannerWrapper scannerWrapper, SystemWrapper systemWrapper) {
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
