package aueb.mcsis.omada7.domain.eforia;


import java.time.LocalDate;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import aueb.mcsis.omada7.domain.eforia.ElegxosAnantistixiwn;
import aueb.mcsis.omada7.domain.eforia.Dhlwsh;
import aueb.mcsis.omada7.domain.eforia.Trimhno;
public class ElegxosAnantistixoiwnTester {

	@Before
	
	@Test
	public void AnantistoixiaEnaProsEnaTester(){
		ElegxosAnantistixiwn ele = new ElegxosAnantistixiwn(20000);
		//Dhlwsh d = new Dhlwsh();
		ele.setDiaforaposou(30000);
		Assert.assertEquals(ele.getDiaforaposou(), 30000.0, 0.1);
		 LocalDate a=  LocalDate.of(2018, 1, 1);
		 LocalDate b= LocalDate.of(2018, 7, 15);
		 
		 Dhlwsh d = new Dhlwsh(3,a,0,true);
		 Dhlwsh d1 = new Dhlwsh(3,b,0,false);
		Trimhno tr=new Trimhno(d.getSubmissiondate().getMonthValue(), d.getSubmissiondate().getYear(), d.getSubmissiondate().getDayOfMonth());
		Assert.assertTrue(ele.tsekareEanEntosXronikouOriou(d));
		Assert.assertFalse(ele.tsekareEanEntosXronikouOriou(d1));
	}}
	
	
	
	

