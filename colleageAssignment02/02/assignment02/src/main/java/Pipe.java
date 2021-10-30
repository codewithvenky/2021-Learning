import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public interface Pipe {

	void write(String string);

	String read();

	boolean isNotEmptyOrIsNotClosed();

	boolean hasNext();

	void close();
}
