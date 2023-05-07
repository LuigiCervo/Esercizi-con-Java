package Multimedia.test;

public class Audio extends ElementoMultimediale implements Riproducibile {	

	private int volume;
	private int durata;

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
		}
	}
	public Audio (String titolo , int volume){
		
		this.titolo = titolo;
		this.volume = volume;
		this.durata = 3;
	}

}

