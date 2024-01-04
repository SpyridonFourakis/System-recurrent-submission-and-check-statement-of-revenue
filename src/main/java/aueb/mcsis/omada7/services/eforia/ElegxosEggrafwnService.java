package aueb.mcsis.omada7.services.eforia;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import aueb.mcsis.omada7.domain.eforia.LogariasmosEtairias;
import aueb.mcsis.omada7.persistence.eforia.JPAUtil;



public class ElegxosEggrafwnService {
	// elegxos pinaka etairiwn gia nees eggrafes(koitaei ta dio boolean pedia)
	// stooixeia ston eforo
	// ta vlepei allazei ta pedia analoga thn apofash tou(aporipsh,tropo,epitixia) 
	 
	private EntityManager em;

	
	
	public ElegxosEggrafwnService(EntityManager em) {
		super();
		this.em = em;
	}
	
	@SuppressWarnings("unchecked")
	public List<LogariasmosEtairias> FerePendingLogariasmous(){
		//fernei apo ton pinaka ths vashs tis eggrafes twn logariasmwn pou den exoun elegthei
		List<LogariasmosEtairias> results = null;
		results=em.
		createQuery("select e from LogariasmosEtairias e where e.exeiElefthei=FALSE AND e.needCheck=TRUE").getResultList();
		return results;	
	
		
	}
	


	public void TropopoihseKatastashLogariasmwn(){
		List<LogariasmosEtairias> lista=FerePendingLogariasmous();
		for(LogariasmosEtairias e: lista){
			e.setExeiElefthei(true);
			e.setNeedCheck(true);
			EntityManager em = JPAUtil.getCurrentEntityManager();
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			//apothikeush sth vash gia tis allages
			em.persist(e);
			tx.commit();
			
		}
	}
	
}
