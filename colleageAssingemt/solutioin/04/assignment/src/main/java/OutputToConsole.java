import java.util.List;

public class OutputToConsole implements Output {

	SystemWrapper systemWrapper ;
	
	public OutputToConsole(SystemWrapper systemWrapper) {
		super();
		this.systemWrapper = systemWrapper;
	}

	@Override
	public void write(List<String> lines) {

	 	lines.forEach(e -> systemWrapper.println(e));

		}


}
