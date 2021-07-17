import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface Input {

 public	List<String> read() throws IOException;
	/*public List<String> read(ScannerWrapper scannerWrapper, SystemWrapper systemWrapper) {
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

	*/
}
