package Multimedia.test;

public class Video extends ElementoMultimediale implements Riproducibile, LuminositaRegolabile {	

	private int volume;
	private int durata;
	private int luminosita;
	
	@Override
	public void alzaVolume(){
		if (volume < 10) {
			volume++;
		}
	}
	
	@Override
	public void abbassaVolume() {
		if(volume > 0) {
			volume--;
		}
	}
	
	@Override
	public void show() {
		for(int i=0 ; i< durata; i++) {
			System.out.print(i + titolo);
			for(int j=0 ; j< volume; j++) {
				System.out.print("!");
			}
			for(int l=0 ;l< luminosita; l++) {
				System.out.print("*");
			}
			System.out.print("\n");
		}
		
	}

	@Override
	public void aumentaLuminosita() {
		if(luminosita < 10) {
			luminosita++;
		}
	}

	@Override
	public void abbassaLuminosita() {
		if(luminosita > 0) {
			luminosita--;
		}
	}
	public Video(String titolo, int luminosita , int volume){
		
		this.titolo = titolo;
		this.luminosita = luminosita;
		this.volume = volume;
		this.durata = 3;
	}
}
