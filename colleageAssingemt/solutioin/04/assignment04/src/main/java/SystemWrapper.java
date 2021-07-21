/*
 * SystemWrapper should be a singleton that has a println() method to leverage 
System.out.println()
*/
public class SystemWrapper {
	// static variable single_instance of type Singleton
	private static SystemWrapper systemWrapperinstance = null;

	// private constructor restricted to this class itself
	private SystemWrapper() {
	}

	public void println(String p) {
		System.out.println(p);
	}

	// static method to create instance of Singleton class
	public static SystemWrapper getInstance() {
		if (systemWrapperinstance == null) { // first time lock
			synchronized (SystemWrapper.class) {
				if (systemWrapperinstance == null) { // second time lock
					systemWrapperinstance = new SystemWrapper();
				}
			}
		}
		return systemWrapperinstance;
	}
}