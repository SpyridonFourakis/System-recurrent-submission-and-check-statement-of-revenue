package aueb.mcsis.omada7.domain.eforia;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Test;


public class ElegxosApathsTester {
	@SuppressWarnings("deprecation")
	@Test
	public void ElegkseAnperasan35Meres(){
		
		Dhlwsh d1= new Dhlwsh(3,LocalDate.of(2018, 11, 15), 0, true);
		Dhlwsh d2= new Dhlwsh(3,LocalDate.of(2018, 10, 10), 0, true);
		ElegxosApaths elegxosApaths1=new ElegxosApaths();
		ElegxosApaths elegxosApaths2=new ElegxosApaths();
		//trexoun apla kanoun mia vlakia
		Assert.assertEquals(elegxosApaths1.ElegkseAnPerasan35Meres(d1),true);
		Assert.assertEquals(elegxosApaths2.ElegkseAnPerasan35Meres(d2),false);
			
	}
	@Test
	public void GenikaTest(){
		ElegxosApaths elegxosApaths2=new ElegxosApaths(40000,20000,false);
		elegxosApaths2.setApath(true);
		elegxosApaths2.setProstimo(30000);
		elegxosApaths2.setSoumaesodwneskodwn(20000);
		Assert.assertEquals(30000.0,elegxosApaths2.getProstimo(),0.01);
		Assert.assertEquals(20000,elegxosApaths2.getSoumaesodwneskodwn(),0.01);
		Assert.assertEquals(true, elegxosApaths2.isApath()); 
		
	}
	
}
