package jUnitTest;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import Dao.MacchinaDao;
import Dao.PersonaDao;
import Model.Macchina;
import Model.Persona;


public class TestMacchinaDao {

	@Test
	public void test() {

		// test INSERT
		MacchinaDao mDao = new MacchinaDao();
		assertNotNull(mDao);

		boolean inserito = mDao.inserisciMacchina("alfa giulia", "traa");
		assertTrue(inserito);

		// test SELECT
		Macchina mac= mDao.tovaMacchina("alfa giulia","traa",1);
		assertNotNull(mac);
		
		//test UPDATE
		boolean aggiornato=mDao.aggiornaMacchina ("Lancia delta","trttr",3);
		assertTrue(aggiornato);
		
		//test DELETE
		boolean cancellato=mDao.cancellaMacchina(2);
		assertTrue(cancellato);

	}
	
	@Test
	public void testMacchinePersona(){
		MacchinaDao mDao = new MacchinaDao();
		
		
		Map<Integer,Macchina> listaMacchine=new HashMap<Integer,Macchina>();
		listaMacchine=mDao.trovaTutteMacchinePerPersona(1);
		assertNotNull(listaMacchine);
				
	}
}
