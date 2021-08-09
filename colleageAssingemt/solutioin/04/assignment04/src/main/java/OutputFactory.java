public class OutputFactory {
	
	private SystemWrapper systemWrapper;
	
	public OutputFactory(SystemWrapper systemWrapper) {
		super();
		this.systemWrapper = systemWrapper;
	}

	public Output create(String outputType){ 
	      if(outputType == null){
	         return null;
	      }	
	      if(outputType.equalsIgnoreCase("FILE")){
	          return new OutputToFile();
	          
	       } else if(outputType.equalsIgnoreCase("CONSOLE")){
	         
			return new OutputToConsole(systemWrapper);
	          
	       }
	       else
	       {
	        throw new IllegalArgumentException();
	       }

 
}
}