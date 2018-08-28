package searcher;

import java.io.File;

import org.junit.Test;

public class MainTest {
	
	Main main = new Main();
	String testDir = "./src/main/resources";

	/**
	 * Test an existing text
	 */
	@Test
	public void test1() {
		
		String words = "Lorem ipsum";
		File file = new File(testDir + "/testingFile_1.txt");
		
		double matchLevel = main.findMatchLevel(file, words);
		System.out.println("test1:matchLevel = " + matchLevel + "%");
		
		assert( matchLevel == 100.0 || matchLevel == 50.0 );
	}

	/**
	 * Test a no-existing text
	 */
	@Test
	public void test2() {
		
		String words = "XXXX";
		File file = new File(testDir + "/testingFile_1.txt");
		
		double matchLevel = main.findMatchLevel(file, words);
		System.out.println("test2:matchLevel = " + matchLevel + "%");
		
		assert( matchLevel == 0.0 );
	}	

	/**
	 * Test a percentage of coincidence
	 */
	@Test
	public void test3() {
		
		String words = "bb ccc dd ee ff";
		File file = new File(testDir + "/testingFile_1.txt");
		
		double matchLevel = main.findMatchLevel(file, words);
		System.out.println("test3:matchLevel = " + matchLevel + "%");
		
		assert( matchLevel == 80.0 );
	}	
	
}
