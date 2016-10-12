package Model;

public class Macchina {
	
	private String modello;
	private String targa;
	private int id_Macchina;
	
	public Macchina() {
		
	}

	public Macchina(String modello, String targa, int id_Macchina) {
		
		this.modello = modello;
		this.targa = targa;
		this.id_Macchina = id_Macchina;
	}

	public Macchina(String model, String targ) {
		this.modello=model;
		this.targa=targ;
	}

	public String getModello() {
		return modello;
	}

	public void setModello(String modello) {
		this.modello = modello;
	}

	public String getTarga() {
		return targa;
	}

	public void setTarga(String targa) {
		this.targa = targa;
	}

	public int getId_Macchina() {
		return id_Macchina;
	}

	public void setId_Macchina(int id_Macchina) {
		this.id_Macchina = id_Macchina;
	}
	
	
	
	
	
	

}
