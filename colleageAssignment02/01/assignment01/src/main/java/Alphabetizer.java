import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class Alphabetizer extends Filter {

	public Alphabetizer(Pipe inPipe, Pipe outPipe) {
		super(inPipe, outPipe);
		// TODO Auto-generated constructor stub
	}



	@Override
	void filter() {
		TreeSet<String> treesetObj = new TreeSet<>(new AlphabetComparator());
		List<String> outputList = new ArrayList<>();
		
		while (inPipe.isNotEmptyOrIsNotClosed()) {
			if (inPipe.hasNext()) {
				treesetObj.add(inPipe.read());
			}}
		
		 for(String line:treesetObj){
	            System.out.println(line);
	            outputList.add(line);
	            outPipe.write(line);
	        }
		 outPipe.close();
	
	}
}
class AlphabetComparator implements Comparator<String>{

	@Override
	public int compare(String s1, String s2) {
		 return s1.compareToIgnoreCase(s2);
	}

}

