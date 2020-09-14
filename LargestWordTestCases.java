
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class LargestWordTestCases {

	// Test data folder
	String testDir;

	public LargestWordTestCases() {
		testDir = System.getProperty("user.dir") + "/test-data/";
	}

	@Rule
	public ExpectedException exception = ExpectedException.none();

	/**
	 * Test case to validate handling of null as file name
	 * 
	 * @throws Exception
	 */
	@Test
	public void _01_emptyFileTest() throws Exception {
		exception.expect(java.lang.NullPointerException.class);
		final LargestWord lw = new LargestWord(null);
		final String[] result = lw.getLargestWord();
	}

	/**
	 * Test case to validate handling of non existing file
	 * 
	 * @throws Exception
	 */
	@Test
	public void _02_fileNotFoundTest() throws Exception {
		exception.expect(java.io.FileNotFoundException.class);
		exception.expectMessage("The system cannot find the file specified");
		final LargestWord lw = new LargestWord("no-existing-file");
		final String[] result = lw.getLargestWord();
	}

	/**
	 * Test case to validate handling directory as a file
	 * 
	 * @throws Exception
	 */
	@Test
	public void _03_fileIsADirectoryTest() throws Exception {
		exception.expect(java.io.FileNotFoundException.class);
		exception.expectMessage("Access is denied");
		final LargestWord lw = new LargestWord(testDir);
		final String[] result = lw.getLargestWord();
	}

	/**
	 * Test case to validate handling of empty file content. Expect null as a
	 * largest word
	 * 
	 * @throws Exception
	 */
	@Test
	public void _04_emptyContentFileTest() throws Exception {
		final LargestWord lw = new LargestWord(testDir + "test2.txt");
		final String[] result = lw.getLargestWord();
		assertNull(result[0]);
	}

	/**
	 * Test case to validate the positive scenario to find the largest word with its
	 * first occurance
	 * 
	 * @throws Exception
	 */
	@Test
	public void _05_largestWordSuccesTest() throws Exception {
		final LargestWord lw = new LargestWord(testDir + "test.txt");
		final String[] result = lw.getLargestWord();
		assertEquals(result[0], "abcde");
	}

	/**
	 * Test case to validate the negative scenario to find the largest word with its
	 * last occurance
	 * 
	 * @throws Exception
	 */
	@Test
	public void _06_largestWortLastOccranceTest() throws Exception {
		final LargestWord lw = new LargestWord(testDir + "test.txt");
		final String[] result = lw.getLargestWord();
		assertNotEquals(result[0], "edcba");
	}

	/**
	 * Test case to validate the positive scenario for finding the largest word and
	 * the transpose of that largest word
	 * 
	 * @throws Exception
	 */
	@Test
	public void _07_largestWordAndTransposeSuccessTest() throws Exception {
		final LargestWord lw = new LargestWord(testDir + "test.txt");
		final String[] result = lw.getLargestWord(true);
		String[] expectedWords = { "abcde", "edcba" };
		assertEquals(expectedWords, result);
	}

	/**
	 * Test case to validate the positive scenario for finding the largest word and
	 * the transpose of that largest word
	 * 
	 * @throws Exception
	 */
	@Test
	public void _08_transposeLargestWordSuccessTest() throws Exception {
		final LargestWord lw = new LargestWord(testDir + "test.txt");
		final String[] result = lw.getLargestWord(true);
		String[] expectedWords = { "abcde", "edcba" };
		assertEquals(expectedWords, result);
	}

	/**
	 * Test case to validate the transpose of the transpose word
	 * 
	 * @throws Exception
	 */
	@Test
	public void _09_transposeOfTransposeTest() throws Exception {
		final LargestWord lw = new LargestWord(testDir + "test.txt");
		final String[] result = lw.getLargestWord(true);
		assertEquals(result[0], lw.transpose(result[1]));
	}

	/**
	 * Test case to validate the negative scenario to find the largest word and its
	 * transpose using an empty file
	 * 
	 * @throws Exception
	 */
	@Test
	public void _10_largestWordAndTransposeEmptyTest() throws Exception {
		final LargestWord lw = new LargestWord(testDir + "test2.txt");
		final String[] result = lw.getLargestWord(true);
		String[] expectedWords = { null, null };
		assertEquals(expectedWords, result);
	}

	/**
	 * Test case to validate the negative scenario if the given input file is binary
	 * file
	 * 
	 * @throws Exception
	 */
	@Test
	public void _11_binaryDataTest() throws Exception {
		final LargestWord lw = new LargestWord(testDir + "test-binary.exe");
		final String[] result = lw.getLargestWord(true);
		assertEquals(result[0], lw.transpose(result[1]));
	}
}
