package aueb.mcsis.omada7.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import aueb.mcsis.omada7.domain.eforia.Dhlwsh;
import aueb.mcsis.omada7.domain.eforia.LogariasmosEtairias;
import aueb.mcsis.omada7.persistence.eforia.Initializer;
import aueb.mcsis.omada7.persistence.eforia.JPAUtil;

public class InitializerTest {

	  private Initializer dataHelper;

	    @Before
	    public void setUpJpa() {
	        dataHelper = new Initializer();
	        dataHelper.prepareData();
	    }
	    
	    
	    @SuppressWarnings("unchecked")
	    @Test
	    public void SwstosArithmosLogariamwn(){
	        int EXPECTED_LOGARIASMOS_NUMBER = 4;
	        EntityManager em = JPAUtil.getCurrentEntityManager();
	        Query query = em.createQuery("select log from LogariasmosEtairias log");
	        List<LogariasmosEtairias> results = query.getResultList();      
	        Assert.assertEquals(EXPECTED_LOGARIASMOS_NUMBER, results.size());
		
		
	}
	    
	    @SuppressWarnings("unchecked")
	    @Test
	    public void SwstosArithmosDhlweswn(){
	    	  int EXPECTED_DHLWSEWN_NUMBER = 3;
		        EntityManager em = JPAUtil.getCurrentEntityManager();
		        Query query = em.createQuery("select dhl from Dhlwsh dhl");
		        List<Dhlwsh> results = query.getResultList();      
		        Assert.assertEquals(EXPECTED_DHLWSEWN_NUMBER, results.size());
	    }
	    
	    @SuppressWarnings("unchecked")
	    @Test
	    public void SwstosArithmosParastatikwn(){
	  	  int EXPECTED_PARASTATIKA_NUMBER = 9;
	        EntityManager em = JPAUtil.getCurrentEntityManager();
	        Query query = em.createQuery("select para from Parastatiko para");
	        List<Dhlwsh> results = query.getResultList();      
	        Assert.assertEquals(EXPECTED_PARASTATIKA_NUMBER, results.size());
	    }
}
