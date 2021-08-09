
public class InputFactory {

	private ScannerWrapper scannerWrapper;
	 private SystemWrapper systemWrappe;
	
	
	
	public InputFactory(ScannerWrapper scannerWrapper, SystemWrapper systemWrappe) {
		super();
		this.scannerWrapper = scannerWrapper;
		this.systemWrappe = systemWrappe;
	}



	public Input create(String inputType){
		      if(inputType == null){
		         return null;
		      }	
		      if(inputType.equalsIgnoreCase("FILE")){
		          return new InputFromFile();
		          
		       } else if(inputType.equalsIgnoreCase("CONSOLE")){
		          return new InputFromConsole( scannerWrapper,  systemWrappe);
		          
		       }
		       else
		       {
		    	   throw new IllegalArgumentException();
		    	   
		       } 

}
}
