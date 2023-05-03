package eserciziEpicode.test;

public class Rettangolo {
	
	double lato1;
	double lato2;
	double area;
	double perimetro;
	 
	public Rettangolo (double num1 , double num2) {
		this.lato1 = num1;
		this.lato2 = num2;
		
	}
	
	public void stampaAreaEPerimetro() {
		this.area = lato1 * lato2 ;
		this.perimetro = (lato1 * 2) + (lato2 * 2);		
		System.out.println("area:" + area + " " + "perimetro:" + perimetro);
	}
}

