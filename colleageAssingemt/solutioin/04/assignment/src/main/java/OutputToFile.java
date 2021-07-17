import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.List;

public class OutputToFile implements Output {
	// writes the alphabetized strings to kwic_output.txt file
		public void write(List<String> lines) throws IOException {
		
			if (lines.size() > 0) {
				Path path 
				  = FileSystems.getDefault().getPath("").toAbsolutePath();
					System.out.println(path.toString());
					// above code will get the abosolute path for  your root dir
				
				BufferedWriter bufferedWriterInstance = new BufferedWriter(new FileWriter(path.toString()+"\\kwic_output.txt"));
				try {
					for (String sortedString : lines) {
						bufferedWriterInstance.write(sortedString);
						bufferedWriterInstance.newLine();
					}
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					if (bufferedWriterInstance != null) {
						System.out.println("End of Writing output to kwic_output.txt");
						bufferedWriterInstance.close();
					}
				}
			}
		}
}
