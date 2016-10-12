package jUnitTest;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import Dao.PersonaDao;
import Model.Persona;

public class TestPersonaDao {

	@Test
	public void test() {
		
		//test INSERT
		PersonaDao pDao=new PersonaDao();
		assertNotNull(pDao);
		
		boolean inserito= pDao.inserisciPersona("aaa","aaa","aaaa");
		assertTrue(inserito);
		
		
		//test SELECT
		Persona pers=pDao.trovaPersona("aaa","aaa","aaaa",7);
		assertNotNull(pers);
		
		//test SELECT tutte le Persone
		Map<Integer,Persona> listaPersone=new HashMap<Integer,Persona>();
		listaPersone=pDao.trovaTuttePersone();
		assertNotNull(listaPersone);
		
//		//test UPDATE
		boolean aggiornato=pDao.aggiornaPersona ("bbb","bbb","bbbb",4);
		assertTrue(aggiornato);
		
//		//test DELETE
		boolean cancellato=pDao.cancellaPersona(5);
		assertTrue(cancellato);
	}

}
