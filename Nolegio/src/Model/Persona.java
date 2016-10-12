package Model;

public class Persona {
	
	private String nome;
	private String cognome;
	private String codiceFiscale;
	private int id_Persona;
	
	public Persona() {
		
	}

	public Persona(String nome, String cognome, String codiceFiscale,
			int id_Persona) {
		
		this.nome = nome;
		this.cognome = cognome;
		this.codiceFiscale = codiceFiscale;
		this.id_Persona = id_Persona;
	}

	public Persona(String name, String surname, String cF) {
		this.nome=name;
		this.cognome=surname;
		this.codiceFiscale=cF;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public int getId_Persona() {
		return id_Persona;
	}

	public void setId_Persona(int id_Persona) {
		this.id_Persona = id_Persona;
	}
	
	
	
	
	
	
	

}
