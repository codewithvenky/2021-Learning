import java.util.List;

public class Output {

	public void write(List<String> lines, SystemWrapper systemWrapper) {

		lines.forEach(e -> systemWrapper.println(e));

	}

}
