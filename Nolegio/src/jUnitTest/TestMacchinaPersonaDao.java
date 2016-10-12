package jUnitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import Dao.MacchinaDao;
import Dao.MacchinaPersonaDao;

public class TestMacchinaPersonaDao {

	@Test
	public void test() {

		// test INSERT
		MacchinaPersonaDao mPDao = new MacchinaPersonaDao();
		assertNotNull(mPDao);
		
		boolean inserito = mPDao.inserisciNoleggio(1,1);
		assertTrue(inserito);
	}

}
