package thread.java;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		Contenitore1 cont1 = new Contenitore1("Contenitore 1");
		Contenitore1 cont2 = new Contenitore1("Contenitore 1");
		Contenitore1 cont3 = new Contenitore1("Contenitore 1");
		Contatore c1 = new Contatore("Primo contatore"); 
		Contatore c2 = new Contatore("Seconddo contatore");
		
	c1.start();
	c2.start();
	
	
	
	int[] arr = new int[3000];
	Random rand = new Random();
	
	for(int i = 0; i < 3000 ;i++){
      arr[i] = rand.nextInt(100);
	}
	return arr;	
	} 

	
    static class Contatore extends Thread{
		
		private String numero;
		
		public Contatore(String messaggio) {
			
			this.numero = messaggio;
		}
		
		@Override
		public void run() {
			
			for(int i = 0 ; i<11 ; i++) {
			try {	
				System.out.println(this.numero + " " + i);
				Thread.sleep(1000);
			}
			catch(Exception e) {
               System.out.println("Error");			
				}
			}
		}
	}
    
    static class Contenitore1 extends Thread{
    	
    	private String messaggio;
    	public int[] arr;
    	
    	  public Contenitore1(String messaggio){
    	    	
    	   this.messaggio = messaggio;
			
    	    }
    	  public void run() {
    		  for(int i = 0 ; i< arr[999] ; i++) {
    				try {	
    					System.out.printf(this.messaggio);
    				}
    				catch(Exception e) {
    	               System.out.println("Error");			
    				}
    		  }
    	  }
  static class Contenitore2 extends Thread{
    	
    	private String messaggio;
    	public int[] arr;
    	
    	 public Contenitore2 (String messaggio){
 	    	
      	   this.messaggio = messaggio;
  			
      	    }
    	  @Override
    	  public void run() {
    		  for(int i = 0 ; i< arr[999] ; i++) {
    				try {	
    					System.out.printf(this.messaggio);
    				}
    				catch(Exception e) {
    	               System.out.println("Error");			
    				}
    		  }
    	  }
    	  public int somma(int numero1, int  numero2) {
    		  return numero1 + numero2;
    	  }
    	  static class Contenitore3 extends Thread{
    	    	
    	    	private String messaggio;
    	    	public int[] arr;
    	    	
    	    	  public Contenitore3(String messaggio) {
    	    	    	
    	    		 this.messaggio = messaggio;		
    	    	  }
    	    	  @Override
    	    	  public void run() {
    	    		  for(int i = 0 ; i<arr[999]; i++) {
    	    				try {	
    	    					System.out.printf(this.messaggio);
    	    				}
    	    				catch(Exception e) {
    	    	               System.out.println("Error");			
    	    				}
    	    		  }
    	    	  }
    	  	}
  		}
    }
}
