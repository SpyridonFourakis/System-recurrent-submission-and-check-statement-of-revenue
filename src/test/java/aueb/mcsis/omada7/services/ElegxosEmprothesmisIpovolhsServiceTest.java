package aueb.mcsis.omada7.services;

import org.junit.Assert;
import org.junit.Test;

import aueb.mcsis.omada7.services.eforia.ElegxosEmprothesmisIpovolhsService;


public class ElegxosEmprothesmisIpovolhsServiceTest extends GenikoServiceTest {
	
	
	ElegxosEmprothesmisIpovolhsService empro;
	
	public ElegxosEmprothesmisIpovolhsServiceTest() {
		// TODO Auto-generated constructor stub
	}

	@Test
	public void TestfereolestisDhlwseis(){
		empro=new ElegxosEmprothesmisIpovolhsService(em);
		Assert.assertEquals(empro.FereOlesTisDhlwseis().size(), 3);
	}
	
	
	@Test
	public void TestApothikeusePoioiDikaiountaiTropopoihsh(){
		empro=new ElegxosEmprothesmisIpovolhsService(em);
		Assert.assertEquals(empro.ApothikeusePoioiDikaiountaitropopoihsh(),3);
	}
	
}
