package aueb.mcsis.omada7.services;

import java.time.LocalDate;


import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.Assert;
import org.junit.Test;

import aueb.mcsis.omada7.domain.eforia.Dhlwsh;
import aueb.mcsis.omada7.domain.eforia.Parastatiko;
import aueb.mcsis.omada7.persistence.eforia.JPAUtil;
import aueb.mcsis.omada7.services.eforia.ElegxosGiaAnantistixoiesService;

public class ElegxosAnantistoixiwnServiceTest extends GenikoServiceTest {
	
	ElegxosGiaAnantistixoiesService s;

	@Test
	public void TestKaneEisagwghSthBash(){
		s=new ElegxosGiaAnantistixoiesService(em);
		s.KaneEisagwghSthBash(1000);
		Assert.assertEquals(s.girnaTisAnantistoixies().size(),1);
	}
	
	@Test
	public void TestfindallDhlwseis(){
		s=new ElegxosGiaAnantistixoiesService(em);
		Assert.assertEquals(s.findAllDhlwseis().size(), 3);
	}

	
	@Test
	public void TestElegxosAnantistoixiwn(){
		EntityManager em = JPAUtil.getCurrentEntityManager();
		s=new ElegxosGiaAnantistixoiesService(em);
		Dhlwsh d=new Dhlwsh(3, LocalDate.of(2017, 11, 28), 0, true);
		Dhlwsh d2=new Dhlwsh(3,LocalDate.of(2017, 11, 27), 0, true);
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(d);
		em.persist(d2);
		LocalDate a= LocalDate.now();
		Parastatiko p1=new Parastatiko("252525252", 100,true, 10000,a);
		Parastatiko p2=new Parastatiko("102030405", 101,false, 100, a);
		Parastatiko p3=new Parastatiko("252525252", 102,true, 10000, a);
		Parastatiko p4=new Parastatiko("102030405", 103,false, 100, a);
		em.persist(p1);
		em.persist(p2);
		em.persist(p3);
		em.persist(p4);
		d.addParastatiko(p1);
		d.addParastatiko(p2);
		d2.addParastatiko(p3);
		d2.addParastatiko(p4);
		tx.commit();
		s.elegxosAnantistoixiwn();
		Assert.assertTrue(s.girnaTisAnantistoixies().size()!=0);
	}
	
	@Test
	public void TestGirnaTisAnantistoixies(){
		s=new ElegxosGiaAnantistixoiesService(em);
		Assert.assertEquals(s.girnaTisAnantistoixies().size(), 0);
	}
	
	
}
