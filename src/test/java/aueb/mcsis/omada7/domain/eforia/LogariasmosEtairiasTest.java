package aueb.mcsis.omada7.domain.eforia;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import aueb.mcsis.omada7.domain.eforia.LogariasmosEtairias;
import org.junit.*;

import aueb.mcsis.omada7.domain.eforia.Dhlwsh;
//dimiourgrei logariasmo/null ka/ ekxorei koita me assert ola ta stoixeia 
// dimiourgei kai dilosei pali me null ka kai use assert for all (gia to size tou set twn dilosewn
// kai canmakedilosi
//kai canmaketropoisi
// me boolean ta duo panw
//kai isos kati san to testGetDhlwshDue

public class LogariasmosEtairiasTest {
	LogariasmosEtairias e;
	
	
	@Test
	public void MporeiNaKaneiDhlwshTester(){
		e=new LogariasmosEtairias(5,"aek", LocalDate.now(), "123456879", "aek@aek.com", 2105689745, true, true);
		Assert.assertFalse(e.MporeiNaKaneiDhlwsh(e));
		e.setNeedCheck(false);
		Assert.assertTrue(e.MporeiNaKaneiDhlwsh(e));
		e.setExeiElefthei(false);
		Assert.assertFalse(e.MporeiNaKaneiDhlwsh(e));
		
	}
	
	
	@Test
	public void EanToAfmEinaiValid(){
		LogariasmosEtairias a=new LogariasmosEtairias();
		
		a.setAfm("1234567889");
		
		
		Assert.assertFalse(a.isValidAfm(a));
		
		LogariasmosEtairias b=new LogariasmosEtairias();
		b.setAfm("123456789");
		Assert.assertTrue(b.isValidAfm(b));
	}
	
	
	  @Test
	  public void setDhlwshToLogariasmouEtairias() {
		  
		  
		 
		   LogariasmosEtairias logariasmos = new  LogariasmosEtairias();
		   Assert.assertEquals(0,logariasmos.getDhlwseis().size());
		   Dhlwsh dhlwsh = new Dhlwsh();//kai null dilosi se alo
		   dhlwsh.setLogarismosEtairias(logariasmos);
	       logariasmos.addDhlwsh(dhlwsh);
	        Assert.assertEquals(1,logariasmos.getDhlwseis().size());
	        Assert.assertTrue(logariasmos.getDhlwseis().contains(dhlwsh));
	        
	  }

	  @Test
	  public void setDhlwshToNewLogariasmosEtairias() {
		  
		 
		  
		  
		  LogariasmosEtairias logariasmos = new  LogariasmosEtairias() ;      
				  Dhlwsh dhlwsh = new Dhlwsh();
				  dhlwsh.setLogarismosEtairias(logariasmos);
				  logariasmos.addDhlwsh(dhlwsh);
				  Set<Dhlwsh> dhlwseis=new HashSet<>();
				  dhlwseis.add(dhlwsh);
				  logariasmos.setDhlwseis(dhlwseis);
	        Assert.assertTrue(logariasmos.getDhlwseis().contains(dhlwsh));
	        Assert.assertEquals(1, dhlwseis.size());
	        LogariasmosEtairias newlogariasmos = new  LogariasmosEtairias();
	        dhlwsh.setLogarismosEtairias(newlogariasmos);
	        newlogariasmos.addDhlwsh(dhlwsh);
	        LocalDate a=  LocalDate.of(2017, 10, 2);
	         LogariasmosEtairias VEROPOULOS = new LogariasmosEtairias(1, "veropoulos",a, "987654321", "veropoulos@ver.gr",2102574575,true,true);
	         Assert.assertTrue(VEROPOULOS.getEpwnimia().equals("veropoulos"));
	        Assert.assertTrue(logariasmos.getDhlwseis().size() == 1);
	                
	        Assert.assertTrue(newlogariasmos.getDhlwseis().size() == 1);
	        Assert.assertTrue(newlogariasmos.getDhlwseis().contains(dhlwsh));
	        
	        LogariasmosEtairias log =new LogariasmosEtairias();
	        log.setEpwnimia("kostas");
	        Assert.assertTrue(VEROPOULOS.getHmeromhniasistashs().equals(a));
	        Assert.assertTrue(VEROPOULOS.getEmail().equals( "veropoulos@ver.gr"));
	        
	    }


@Test
public void miscellaniousTest(){
	LocalDate a= LocalDate.of(2017, 10, 2);
	LogariasmosEtairias JUMBO = new LogariasmosEtairias(3, "jumbo",a, "987654323", "jumbo@jum.gr",2102579574,
	        false, true);
	Assert.assertEquals(-769680559,JUMBO.hashCode());
	
}

@Test
public void testEquals(){
	LocalDate a = LocalDate.now();
	LogariasmosEtairias JUMBO = new LogariasmosEtairias(3, "jumbo",a, "987654323", "jumbo@jum.gr",2102579574,
	        false, true);
	LogariasmosEtairias XAITOGLOU = new LogariasmosEtairias(4, "xaitoglou",a, "987654324", "xaitoglou@xai.gr",2102584575,
	        false, false);
	LogariasmosEtairias l3=new LogariasmosEtairias();
	LogariasmosEtairias l4=new LogariasmosEtairias();
	LogariasmosEtairias l5=null;
	
	Assert.assertTrue(JUMBO.equals(JUMBO));
	Assert.assertFalse(JUMBO.equals(XAITOGLOU));
	Assert.assertFalse(JUMBO.equals(l3));
	Assert.assertFalse(JUMBO.equals(a));
}
	
	
}

	
