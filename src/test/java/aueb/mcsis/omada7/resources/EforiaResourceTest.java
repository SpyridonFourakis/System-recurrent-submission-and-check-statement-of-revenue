package aueb.mcsis.omada7.resources;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.ws.rs.core.Application;

import org.glassfish.jersey.test.JerseyTest;
import org.glassfish.jersey.test.spi.TestContainerFactory;

import aueb.mcsis.omada7.domain.eforia.Dhlwsh;
import aueb.mcsis.omada7.domain.eforia.LogariasmosEtairias;
import aueb.mcsis.omada7.domain.eforia.Parastatiko;
import aueb.mcsis.omada7.persistence.eforia.Initializer;
import aueb.mcsis.omada7.persistence.eforia.JPAUtil;



public class EforiaResourceTest extends JerseyTest {

	Initializer dataHelper; 
	

	public EforiaResourceTest() {
		super();
	}

	public EforiaResourceTest(TestContainerFactory testContainerFactory) {
		super(testContainerFactory);
	}
	
	public EforiaResourceTest(Application jaxrsApplication) {
		super(jaxrsApplication);
	}

	@Override
	public void setUp() throws Exception {
		super.setUp();
		dataHelper = new Initializer();
		dataHelper.prepareData();
	}

	
	

	@SuppressWarnings("unchecked")
	public List<LogariasmosEtairias> FereOlousTousLog(){
		EntityManager em = JPAUtil.getCurrentEntityManager();
		 List<LogariasmosEtairias> l = em.createQuery("select e from LogariasmosEtairias e").getResultList();
		 em.close();
		 return l;
	}
	
	//na fernei tis dhlwseis gia na mporw a parw ena id
	 @SuppressWarnings("unchecked")
		public List<Dhlwsh> fereOlestisDhlwseis(){
			EntityManager em = JPAUtil.getCurrentEntityManager();
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			List<Dhlwsh> l= em.createQuery("select d from Dhlwsh d").getResultList();
			em.close();
			return l;
			}
	
	 
		@SuppressWarnings("unchecked")
		 public List<Parastatiko>fereTaParastatika(){
			EntityManager em = JPAUtil.getCurrentEntityManager(); 
			EntityTransaction tx = em.getTransaction();
				tx.begin();
				List<Parastatiko> l= em.createQuery("select d from Parastatiko d").getResultList();
			em.close();
			return l;
		 }
		
	
}
