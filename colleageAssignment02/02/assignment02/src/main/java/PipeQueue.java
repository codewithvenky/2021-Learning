import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class PipeQueue implements Pipe {
	public  Queue<String> queue;
	private boolean closed;

	public PipeQueue() {
		queue = new ConcurrentLinkedQueue<>();
		closed = false;
	}

	public void write(String string) {
		queue.offer(string);
	}

	public String read() {
		return queue.poll();
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
