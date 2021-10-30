import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OutputTest {

	Output output;
	Pipe inPipe;
	List<String> actual;

	@BeforeEach
	void setUp() {
		actual = new ArrayList<>();
	}

	@Test
	void output_lines_to_file_with_queues() throws IOException, InterruptedException {
		inPipe = new PipeQueue();
		output = new Output(inPipe, null);
		setUpInputPipe();

		output.start();
		Thread.sleep(1000);
		getActualList();
		assertSizeAndContents(actual);
	}

	@Test
	void output_lines_to_file_with_list() throws IOException, InterruptedException {
		inPipe = new PipeList();
		output = new Output(inPipe, null);
		setUpInputPipe();

		output.start();
		Thread.sleep(1000);

		getActualList();
		assertSizeAndContents(actual);
	}

	private void assertSizeAndContents(List<String> actual) {
		assertSame(2, actual.size());
		assertEquals("hi bye", actual.get(0));
		assertEquals("hi bye foo", actual.get(1));
	}

	private void getActualList() throws FileNotFoundException {
		File file = new File("kwic_output.txt");
		Scanner reader = new Scanner(file);
		while (reader.hasNextLine()) {
			actual.add(reader.nextLine());
		}
		reader.close();
	}

	private void setUpInputPipe() {
		inPipe.write("hi bye");
		inPipe.write("hi bye foo");
		inPipe.close();
	}

}
