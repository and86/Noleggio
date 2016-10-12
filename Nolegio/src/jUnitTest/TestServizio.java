package jUnitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import Dao.MacchinaDao;
import Dao.MacchinaPersonaDao;
import Dao.PersonaDao;
import Model.Macchina;
import Model.Persona;
import Servizio.Servizio;

public class TestServizio {

	@Test
	public void testMacchina() {
		
		MacchinaDao mDao = new MacchinaDao();
		assertNotNull(mDao);
		
		PersonaDao pDao = new PersonaDao();
		assertNotNull(pDao);
		
		MacchinaPersonaDao mPDao=new MacchinaPersonaDao();
		assertNotNull(mPDao);
		
		Servizio s=new Servizio();
		Macchina m=null;
		m=s.aggiungiMacchina("Lancia Y","tatata");
		assertNotNull(m);
				
	}
	
	@Test
	public void testPersona() {
		Servizio s = new Servizio();
		Persona p = null;
		p = s.aggiungiPersona("Andrea", "Laneri", "agagga");
		assertNotNull(p);

	}
	
	@Test
	public void testAssegnaMacchina(){
		MacchinaPersonaDao mPDao = new MacchinaPersonaDao();
		assertNotNull(mPDao);
		
		
		
		
		
	}
}
