import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Input extends Filter {

	public Input(Pipe inPipe, Pipe outPipe) {
		super(inPipe, outPipe);
	}


	@Override
	void filter() {
		List<String> input = null;
		BufferedReader bufferedReaderInstance = null;
		try {
			bufferedReaderInstance = new BufferedReader(new FileReader("kwic.txt"));
			input = new ArrayList<String>();
			String line = bufferedReaderInstance.readLine();
			while (line != null) {
				outPipe.write(line);
				line = bufferedReaderInstance.readLine();
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (bufferedReaderInstance != null) {
				try {
					bufferedReaderInstance.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			outPipe.close();
		}
	}
}
