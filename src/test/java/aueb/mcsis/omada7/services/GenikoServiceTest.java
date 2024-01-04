package aueb.mcsis.omada7.services;

import javax.persistence.EntityManager;
import aueb.mcsis.omada7.persistence.eforia.*;

import org.junit.After;
import org.junit.Before;



public class GenikoServiceTest {
	Initializer dataHelper;
	protected EntityManager em;

	public GenikoServiceTest() {
		super();
	}

	protected void beforeDatabasePreparation(){}
	
	protected void afterDatabasePreparation(){}

	@Before
	public final void setUp() {
		beforeDatabasePreparation();
		dataHelper = new Initializer();
		dataHelper.prepareData();
		em = JPAUtil.getCurrentEntityManager();
		afterDatabasePreparation();
	}

	protected void afterTearDown(){}
	
	@After
	public final void tearDown() {
		em.close();
		afterTearDown();
	}

}
