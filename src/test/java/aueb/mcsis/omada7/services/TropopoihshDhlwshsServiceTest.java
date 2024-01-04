package aueb.mcsis.omada7.services;
import java.time.LocalDate;

import java.util.HashSet;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.Assert;
import org.junit.Test;

import aueb.mcsis.omada7.domain.eforia.Parastatiko;
import aueb.mcsis.omada7.persistence.eforia.JPAUtil;
import aueb.mcsis.omada7.domain.eforia.Dhlwsh;
import aueb.mcsis.omada7.services.eforia.TropopoihshDhlwshsService;
import aueb.mcsis.omada7.services.eforia.IpovolhDhlwshsService;
import aueb.mcsis.omada7.domain.eforia.LogariasmosEtairias;


public class TropopoihshDhlwshsServiceTest {
	
	private EntityManager em;
	
	@Test
	public void VresThnTeleutaiaDhlwshTest(){
		LocalDate a =  LocalDate.now();
		LogariasmosEtairias VEROPOULOS = new LogariasmosEtairias(1, "veropoulos",a, "987654321",
				"veropoulos@ver.gr",2102574575,
		        true, false); //ftiaxno adikimeno logariasmo

		
		
		Dhlwsh d1 = new Dhlwsh(3,a,0 ,true);
		Dhlwsh d2 = new Dhlwsh(1,a,0 ,false);
		EntityManager em = JPAUtil.getCurrentEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(d1);
		tx.commit();
		TropopoihshDhlwshsService tds = new TropopoihshDhlwshsService(em);
		Assert.assertEquals(d1, tds.VresThnTeleutaiaDhlwsh(d1.getId()));

	}
	
	@Test
	public void TestTropopoihshDhlwshs(){
		EntityManager em = JPAUtil.getCurrentEntityManager();
		TropopoihshDhlwshsService tds = new TropopoihshDhlwshsService(em);
		LocalDate a = LocalDate.now();
		Dhlwsh d1 = new Dhlwsh(3,a,0 ,true);
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(d1);
		tx.commit();
		Assert.assertTrue(tds.TropopoihshDhlwshs(d1.getId(), LocalDate.now()));
	}
	
	@Test
	public void TestTropopoihshParastatikwn(){
		EntityManager em = JPAUtil.getCurrentEntityManager();
		TropopoihshDhlwshsService tds = new TropopoihshDhlwshsService(em);
		LocalDate a = LocalDate.now();
		Dhlwsh d1 = new Dhlwsh(3,a,0 ,true);
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(d1);
		tx.commit();
		Parastatiko p1= new Parastatiko("987654322" ,1234,true ,300000 ,a);
        Parastatiko p2= new Parastatiko("987654323" ,2341,true ,250000 ,a);
		d1.addParastatiko(p1);
		d1.addParastatiko(p2);

		Assert.assertTrue(tds.TropopoihshParastatikwn(d1.getId(), 1234, 5, true));
	}
	
	@Test
	public void troponeadhlwshtester(){
		EntityManager em = JPAUtil.getCurrentEntityManager();
		TropopoihshDhlwshsService tds = new TropopoihshDhlwshsService(em);
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		List<Dhlwsh> l= em.createQuery("select d from Dhlwsh d").getResultList();
		tx.commit();
		LocalDate a = LocalDate.now();
		Dhlwsh d1 = new Dhlwsh(3,a,0 ,true);
		d1.setId(l.get(0).getId());
		Assert.assertEquals(true, tds.troponea(d1));
	}
	
}
