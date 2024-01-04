package aueb.mcsis.omada7.domain.eforia;




import org.junit.Assert;
import org.junit.Test;
import aueb.mcsis.omada7.domain.eforia.Trimhno;

public class TrimhnoTest {

	//an douleuei gia to shemra
	@Test
	public void ElegxosGiaSystemDate(){

		Trimhno shmera= new Trimhno();

		
		//Period periodos= Period.between(a,shmera.ela); 
	//	int daysipo= periodos.getDays()+1+periodos.getMonths()*30;
		int days=shmera.paremeres();
		System.out.println(days);
		Assert.assertEquals(days,75);
	}
	
	
	
	@Test
	public void TixaiaHmeromhnia(){
		Trimhno tote=new Trimhno(1, 2018, 20);
		Assert.assertEquals(tote.paremeres(),71);
		
	}
	
	
	
	//elegxei ama exoume valei esfalmena kakh hmeromhnia
	@Test
	public void ElegxosGiaAllhXronia(){
		Trimhno a=new Trimhno(2, 2016, 2);
		Assert.assertEquals(a.SePioTrimhnoEisai(), null);
	}
	
	@Test
	public void ElegxosGiaTrimhno(){
		//deutero trimhno ento xronou
		Trimhno a=new Trimhno(2, 7, 2018, 2);
		Assert.assertEquals(a.Einaiemprothesmh(),true);
		//deutero trimhno apo prohgoumeno
		Trimhno a1=new Trimhno(2, 6, 2018, 2);
		Assert.assertEquals(a1.Einaiemprothesmh(),false);
		//deutero trimhno ektos apo xrono
		Trimhno a2=new Trimhno(2, 7, 2018, 21);
		Assert.assertEquals(a2.Einaiemprothesmh(),false);
		//lathos trimhno
		Trimhno a3=new Trimhno(1, 7, 2018, 2);
		Assert.assertEquals(a3.Einaiemprothesmh(),false);
		
	}
	
}
