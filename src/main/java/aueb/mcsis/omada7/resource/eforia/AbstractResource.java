package aueb.mcsis.omada7.resource.eforia;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import aueb.mcsis.omada7.domain.eforia.Dhlwsh;
import aueb.mcsis.omada7.persistence.eforia.JPAUtil;



public class AbstractResource {
	protected EntityManager getEntityManager() {

		return JPAUtil.getCurrentEntityManager();

	}

	
	
		
}
