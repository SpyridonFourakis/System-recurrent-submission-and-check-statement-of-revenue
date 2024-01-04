package aueb.mcsis.omada7.services;


import org.junit.Assert;
import org.junit.Test;

import aueb.mcsis.omada7.services.eforia.ElegxosEggrafwnService;

public class ElegxosEggrafwnServiceTest extends GenikoServiceTest {
	
	ElegxosEggrafwnService e;

	public ElegxosEggrafwnServiceTest() {
		super();
	}
	
	
	@Test 
	public void TestFeretouslogariasmouspoudenexounelegxthei(){
		e= new ElegxosEggrafwnService(em);
	    Assert.assertEquals(e.FerePendingLogariasmous().size(), 1);
	}
	

	@Test
	public void TestAllakseKatastashLogariasmou(){
		e= new ElegxosEggrafwnService(em);
	    e.TropopoihseKatastashLogariasmwn();
	    Assert.assertEquals(e.FerePendingLogariasmous().size(), 0);
	}
	
}
