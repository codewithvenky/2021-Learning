import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PipeList  extends PipeQueue{
	public  List<String> queue;
	private boolean closed;

	public PipeList() {
		queue = Collections.synchronizedList(new ArrayList<String>());
		closed = false;
	}

	public void write(String string) {
		queue.add(0,string);
	}

	public String read() {
		int size= queue.size();
		return queue.remove(size-1);
	}

	public boolean isNotEmptyOrIsNotClosed() {
		return !queue.isEmpty() || !closed;
	}

	public boolean hasNext() {
		return !queue.isEmpty();
	}

	public void close() {
		closed = true;
	}
}
