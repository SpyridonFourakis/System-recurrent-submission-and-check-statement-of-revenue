package aueb.mcsis.omada7.domain.eforia;
import java.time.LocalDate;


import org.junit.Assert;
import org.junit.Test;

import aueb.mcsis.omada7.domain.eforia.AithmaElegxouEmprothesmisIpovolhs;

public class AithmaEleEmproIpoTest {
	
	@Test
	public void prwtoTest(){
	AithmaElegxouEmprothesmisIpovolhs aempI = new AithmaElegxouEmprothesmisIpovolhs(30000);
	
	Assert.assertEquals(30000, aempI.getProstimoekprothesmis(),0.01);
	}
	

	@Test
	public void ElegkseGiaEkprothesmh(){
	AithmaElegxouEmprothesmisIpovolhs aempI = new AithmaElegxouEmprothesmisIpovolhs(30000);
	Dhlwsh d = new Dhlwsh(1,LocalDate.now(),0 ,true);
	aempI.ElegkseGiaEkprothesmh(d);
	Assert.assertTrue(d.isEmprothesmh());

	AithmaElegxouEmprothesmisIpovolhs aempI2 = new AithmaElegxouEmprothesmisIpovolhs(30000);
	Dhlwsh d1=new Dhlwsh();
	aempI2.ElegkseGiaEkprothesmh(d1);
	d1.setEmprothesmh(false);

	Assert.assertFalse(d1.isEmprothesmh());

	
	}
	
	@Test
	public void updatesinoloprosTest(){
		Dhlwsh d = new Dhlwsh(1,LocalDate.now(),0 ,true);
		AithmaElegxouEmprothesmisIpovolhs aempI = new AithmaElegxouEmprothesmisIpovolhs();
		aempI.updatesinolopros(d);
		Assert.assertEquals(500,d.getSinoloprostimou(),0.01);
	}
	
	
	
}
