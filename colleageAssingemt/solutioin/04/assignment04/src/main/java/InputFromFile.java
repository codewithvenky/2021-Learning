import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class InputFromFile implements Input {

	@Override
	/*
	 * Reads the strings from kwic.txt file
	 */
	public List<String> read() throws IOException {
		List<String> input = null;
		BufferedReader bufferedReaderInstance = null;
		try {
			System.out.println("Reading input file ");
			Path path 
			  = FileSystems.getDefault().getPath("").toAbsolutePath();
				System.out.println(path.toString());
				// above code will get the abosolute path for  your root dir
			
			bufferedReaderInstance = new BufferedReader(new FileReader(path.toString()+"\\kwic.txt"));
			input = new ArrayList<String>();
			String line = bufferedReaderInstance.readLine();
			while (line != null) {
				input.add(line);
				line = bufferedReaderInstance.readLine();
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (bufferedReaderInstance != null) {
				bufferedReaderInstance.close();
			}
		}
		return input;
	}
	
	public static void main (String args[]) throws IOException
	{
		InputFromFile n = new InputFromFile();
	List<String > ss = 	n.read();
	System.out.println(ss);
		
		
	}
}
