package eserciziEpicode.test;

public class Call {
	
	String lastCall;
	String lastNum;

	public Call (String lastCall, String lastNum){
		
		this.lastCall = lastCall;
		this.lastNum = lastNum;
		
	}
	
	public void stampCall(){
		System.out.println(lastNum + " " + "alle"+ lastCall );
	}
}
