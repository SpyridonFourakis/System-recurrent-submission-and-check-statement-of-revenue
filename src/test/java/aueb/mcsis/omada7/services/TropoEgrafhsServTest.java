package aueb.mcsis.omada7.services;

import java.time.LocalDate;


import javax.persistence.EntityManager;

import org.junit.Assert;
import org.junit.Test;

import aueb.mcsis.omada7.services.eforia.TropopoihshEggrafhsService;
import aueb.mcsis.omada7.services.eforia.EgrafhStoSistimaService;
import aueb.mcsis.omada7.domain.eforia.LogariasmosEtairias;

public class TropoEgrafhsServTest  {
	private EntityManager so;
	private EntityManager ha;
	private EgrafhStoSistimaService EgStoSys = new EgrafhStoSistimaService(so);
	
	@Test
	public void TropopoihshLogariasmouTest()
	{	
		
		LocalDate ho = LocalDate.now();

		
		TropopoihshEggrafhsService service = new TropopoihshEggrafhsService(ha);
		
		LogariasmosEtairias logEt = new LogariasmosEtairias(20, "KostasAE", ho , "123456678", "email@em.co", 2106547395,
				true, false);
		
		Assert.assertTrue(EgStoSys.KaneNeaEggrafh(logEt));
		
		
		service.TropopoihshLogariasmou("123456678", "ParisAE", "emailo@em.co", 2103547395, ho);
		Assert.assertEquals(EgStoSys.VresEanExeiKsanakataxwrhtheiToAfm("123456678").getThlefwno(), 2103547395);
		
	
		
	}
	
}
