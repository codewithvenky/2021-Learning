import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MasterControlTest {

	MasterControl masterControl;

	@BeforeEach
	void setUp() throws Exception {
		masterControl = new MasterControl();
		List<String> lines = new ArrayList<>();
		lines.add("Descent of Man");
		lines.add("The Ascent of Man");
		lines.add("The Old Man and The Sea");
		FileWriter fileWriter = new FileWriter("kwic.txt");
		for (String line : lines) {
			fileWriter.write(line);
			fileWriter.write("\n");
		}
		fileWriter.close();
	}

	@Test
	void full_kwic_all_queues() throws IOException, InterruptedException {
		masterControl.start(new PipeQueue(), new PipeQueue(), new PipeQueue());
		Thread.sleep(3000);

		List<String> actual = getActualList();
		assertSizeAndContents(actual);
	}

	@Test
	void full_kwic_all_lists() throws IOException, InterruptedException {
		masterControl.start(new PipeList(), new PipeList(), new PipeList());
		Thread.sleep(3000);

		List<String> actual = getActualList();
		assertSizeAndContents(actual);
	}

	@Test
	void full_kwic_queue_list_list() throws IOException, InterruptedException {
		masterControl.start(new PipeQueue(), new PipeList(), new PipeList());
		Thread.sleep(3000);

		List<String> actual = getActualList();
		assertSizeAndContents(actual);
	}

	@Test
	void full_kwic_list_queue_list() throws IOException, InterruptedException {
		masterControl.start(new PipeList(), new PipeQueue(), new PipeList());
		Thread.sleep(3000);

		List<String> actual = getActualList();
		assertSizeAndContents(actual);
	}

	private void assertSizeAndContents(List<String> actual) {
		assertSame(13, actual.size());
		assertEquals("and The Sea The Old Man", actual.get(0));
		assertEquals("Ascent of Man The", actual.get(1));
		assertEquals("Descent of Man", actual.get(2));
		assertEquals("Man and The Sea The Old", actual.get(3));
		assertEquals("Man Descent of", actual.get(4));
		assertEquals("Man The Ascent of", actual.get(5));
		assertEquals("of Man Descent", actual.get(6));
		assertEquals("of Man The Ascent", actual.get(7));
		assertEquals("Old Man and The Sea The", actual.get(8));
		assertEquals("Sea The Old Man and The", actual.get(9));
		assertEquals("The Ascent of Man", actual.get(10));
		assertEquals("The Old Man and The Sea", actual.get(11));
		assertEquals("The Sea The Old Man and", actual.get(12));
	}

	private List<String> getActualList() throws FileNotFoundException {
		List<String> actual = new ArrayList<>();
		File file = new File("kwic_output.txt");
		Scanner reader = new Scanner(file);
		while (reader.hasNextLine()) {
			actual.add(reader.nextLine());
		}
		reader.close();
		return actual;
	}

}
