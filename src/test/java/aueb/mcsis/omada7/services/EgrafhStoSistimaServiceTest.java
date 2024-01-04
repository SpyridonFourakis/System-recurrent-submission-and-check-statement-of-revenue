package aueb.mcsis.omada7.services;

import aueb.mcsis.omada7.services.eforia.EgrafhStoSistimaService;
import aueb.mcsis.omada7.domain.eforia.LogariasmosEtairias;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Test;

public class EgrafhStoSistimaServiceTest extends GenikoServiceTest {
	

	LocalDate ho =  LocalDate.now();
	private LogariasmosEtairias logEt = new LogariasmosEtairias(20, "KostasAE", ho , "123456678", "email@em.co", 2106547395,
			true, false);
	private LogariasmosEtairias logEtf = new LogariasmosEtairias(50, "RostasAE", ho , "12345667", "email@semm.co", 2107647395,
			true, false);
	private EgrafhStoSistimaService EgStoSys = new EgrafhStoSistimaService(em);
	
		

	@Test
	public void testVresEanExeiKsanakataxwrhtheiToAfm(){
		Assert.assertEquals(EgStoSys.VresEanExeiKsanakataxwrhtheiToAfm(logEt.getAfm()),null);
		
	}
	
	
	@Test
	public void testKaneNeaEggrafh(){
		
		Assert.assertEquals(EgStoSys.KaneNeaEggrafh(logEt),true);
		Assert.assertEquals(EgStoSys.FerePosoiEinaiStoSysthma(),5);
		
		//Assert.assertTrue();
		
		
	}
	
	@Test
	public void testEgirosAfm(){
				
		
		
		
		Assert.assertTrue(EgStoSys.EgirosAfm(logEt));
		Assert.assertFalse(EgStoSys.EgirosAfm(logEtf));
		
		
		
		
	}
	
	
	
	
}
