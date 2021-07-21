import java.util.Scanner;

/*
ScannerWrapper should be a singleton that sets up a Scanner and has a nextLine() method to 
leverage Scanner’s nextLine() method
*/
public class ScannerWrapper {

	// static variable single_instance of type Singleton
	private static ScannerWrapper scannerWrapperinstance = null;
	private static Scanner sc = null;

	// private constructor restricted to this class itself
	private ScannerWrapper() {
		sc = new Scanner(System.in);
	}

	public boolean hasNext() {
		return sc.hasNext();
	}

	public String nextLine() {
		return sc.nextLine();
	}

	// static method to create instance of Singleton class
	public static ScannerWrapper getInstance() {
		if (scannerWrapperinstance == null) { // first time lock
			synchronized (ScannerWrapper.class) {
				if (scannerWrapperinstance == null) { // second time lock
					scannerWrapperinstance = new ScannerWrapper();
				}
			}
		}
		return scannerWrapperinstance;
	}
}
