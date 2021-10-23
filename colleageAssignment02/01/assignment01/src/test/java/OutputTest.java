import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OutputTest {

	Output output;
	Pipe inPipe;

	@BeforeEach
	void setUp() throws Exception {
		inPipe = new Pipe();
		output = new Output(inPipe, null);
	}

	@Test
	void output_lines_to_file() throws IOException {
		inPipe.write("hi bye");
		inPipe.write("hi bye foo");
		inPipe.close();

		output.start();

		List<String> actual = new ArrayList<>();
		File file = new File("kwic_output.txt");
		Scanner reader = new Scanner(file);
		while (reader.hasNextLine()) {
			actual.add(reader.nextLine());
		}
		reader.close();
		assertSame(2, actual.size());
		assertEquals("hi bye", actual.get(0));
		assertEquals("hi bye foo", actual.get(1));
	}

}
