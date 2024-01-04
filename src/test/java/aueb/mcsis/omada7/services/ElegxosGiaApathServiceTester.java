package aueb.mcsis.omada7.services;


import java.time.LocalDate;


import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.Assert;
import org.junit.Test;

import aueb.mcsis.omada7.domain.eforia.Dhlwsh;
import aueb.mcsis.omada7.domain.eforia.ElegxosApaths;
import aueb.mcsis.omada7.domain.eforia.Parastatiko;
import aueb.mcsis.omada7.persistence.eforia.JPAUtil;
import aueb.mcsis.omada7.services.GenikoServiceTest;
import aueb.mcsis.omada7.services.eforia.ElegxosGiaApathService;

public class ElegxosGiaApathServiceTester extends GenikoServiceTest{
	
	private ElegxosGiaApathService natos;
	public ElegxosGiaApathServiceTester() {
		super();
	}




	 
	
	@Test
	public void testFindElegxosApathsById()
	{
		//ftiaxnw ena antikeimeno tipou elegxos apaths kai to vazw sth vash
	
		natos=new ElegxosGiaApathService(em);
		ElegxosApaths e=new ElegxosApaths(100, 0, false);
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(e);
		tx.commit();
		

		Assert.assertEquals(natos.ferePosesEggrafes(), 1);
	}
	
	
	
	

	
	
	@Test
	public void TestIpologismosApaths(){
		natos=new ElegxosGiaApathService(em);
		Dhlwsh d=new Dhlwsh(3,LocalDate.of(2017, 11, 28), 0, true);
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(d);
		Parastatiko p1=new Parastatiko("252525252", 100,true, 10000, LocalDate.now());
		Parastatiko p2=new Parastatiko("102030405", 101,false, 100, LocalDate.now());
		em.persist(p1);
		em.persist(p2);
		d.addParastatiko(p1);
		d.addParastatiko(p2);
		tx.commit();
		Assert.assertTrue(natos.FindElegxosApathsById(natos.ipologismosApaths(d)));
		Assert.assertEquals(natos.ferePosesEggrafes(),1);
	}
	
	
	
	
	
	


	
}
