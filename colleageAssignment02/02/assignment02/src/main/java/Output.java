import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Output extends Filter {
	public Output(Pipe inPipe, Pipe outPipe) {
		super(inPipe, outPipe);
		
	}

	@Override
	void filter() {
		BufferedWriter bufferedWriterInstance=null;
				try {
					bufferedWriterInstance	 = new BufferedWriter(new FileWriter("kwic_output.txt"));					
					while (inPipe.isNotEmptyOrIsNotClosed()) {
						if (inPipe.hasNext()) {
						String test =inPipe.read();
						//	 System.out.println(test);
							bufferedWriterInstance.write(test);
							bufferedWriterInstance.newLine();
						}}
					bufferedWriterInstance.close();	
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					if (bufferedWriterInstance != null) {
						try {
							bufferedWriterInstance.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			
		
	stop();	
	}
}
