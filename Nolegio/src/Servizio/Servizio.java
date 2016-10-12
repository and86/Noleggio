package Servizio;

import Dao.MacchinaDao;
import Dao.MacchinaPersonaDao;
import Dao.PersonaDao;
import Model.Macchina;
import Model.Persona;

public class Servizio {
	
	private MacchinaDao mDao = new MacchinaDao();
	private PersonaDao pDao = new PersonaDao();
	private MacchinaPersonaDao nDao = new MacchinaPersonaDao();

	public Macchina aggiungiMacchina(String modello, String targa) {
		Macchina m=null;
		m = mDao.trovaMacchina(modello, targa);
		if (m==null) {
			mDao.inserisciMacchina(modello, targa);
			m= mDao.trovaMacchina(modello, targa);
						
		}
		return m;
	}
	
	public Persona aggiungiPersona(String nome,String cognome,String codiceFiscale){
		Persona p=null;
		p=pDao.trovaPersona(nome, cognome, codiceFiscale);
		if(p==null){
			pDao.inserisciPersona(nome, cognome, codiceFiscale);
			p=pDao.trovaPersona(nome, cognome, codiceFiscale);
		}
		return p;
		
	}
	

	public boolean assegnaPersonaMacchina(Persona p, Macchina m){
		int id_persona = p.getId_Persona();
		int id_macchina = m.getId_Macchina();
		boolean res=nDao.inserisciNoleggio(id_macchina, id_persona);	
		return res;
	}
	
	

}
