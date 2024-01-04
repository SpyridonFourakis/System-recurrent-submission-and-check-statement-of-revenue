package aueb.mcsis.omada7.services;

import java.time.LocalDate;


import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.Assert;
import org.junit.Test;

import aueb.mcsis.omada7.domain.eforia.Dhlwsh;
import aueb.mcsis.omada7.domain.eforia.ElegxosAnantistixiwn;
import aueb.mcsis.omada7.domain.eforia.ElegxosApaths;
import aueb.mcsis.omada7.domain.eforia.Parastatiko;
import aueb.mcsis.omada7.persistence.eforia.JPAUtil;
import aueb.mcsis.omada7.services.eforia.ElegxosGiaApathService;
import aueb.mcsis.omada7.services.eforia.EpivolhProstimouService;



public class EpivolhProstimouServiceTester  extends GenikoServiceTest{

	private EpivolhProstimouService ep;
	private ElegxosGiaApathService natos;
	
	public EpivolhProstimouServiceTester() {
		super();
	}
	
	@Test
	public void TestFereTisApates(){
	//vazw mia apath 	
		EntityManager em = JPAUtil.getCurrentEntityManager();
		ep=new EpivolhProstimouService(em);
		ElegxosApaths e=new ElegxosApaths();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(e);
		tx.commit();
		Assert.assertEquals(ep.FereTisApates().size(), 1);
	}
	
	
	@Test
	public void TestFereTisAnantistoixies(){
		EntityManager em = JPAUtil.getCurrentEntityManager();
		ep=new EpivolhProstimouService(em);
		ElegxosAnantistixiwn e=new ElegxosAnantistixiwn();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(e);
		tx.commit();
		Assert.assertEquals(ep.FereTisAnantistoixies().size(), 1);
	}
	
	
	
	
	@Test
	public void Testupdatesinoloprostimogiathnkathedhlwsh(){
	
		EntityManager em = JPAUtil.getCurrentEntityManager();
		natos=new ElegxosGiaApathService(em);
		Dhlwsh d=new Dhlwsh(3, LocalDate.of(2017, 11, 28), 0, true);
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(d);
		Parastatiko p1=new Parastatiko("252525252", 100,true, 10000, LocalDate.now());
		Parastatiko p2=new Parastatiko("102030405", 101,false, 100, LocalDate.now());
		p1.setD(d);
		p2.setD(d);
		em.persist(p1);
		em.persist(p2);
		d.addParastatiko(p1);
		d.addParastatiko(p2);
		tx.commit();
		natos.ipologismosApaths(d);
		ep=new EpivolhProstimouService(em);
		Assert.assertEquals(ep.updateSinolikoProstimoGiathnkatheDhlwsh(),true);
	}
	
}
