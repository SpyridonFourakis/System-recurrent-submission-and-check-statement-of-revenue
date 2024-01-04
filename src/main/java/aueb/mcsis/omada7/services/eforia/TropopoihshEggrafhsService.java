package aueb.mcsis.omada7.services.eforia;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import aueb.mcsis.omada7.domain.eforia.LogariasmosEtairias;
import aueb.mcsis.omada7.persistence.eforia.JPAUtil;

public class TropopoihshEggrafhsService {
	//BOOLEAN AN TO AFM EINAI TO IDIO
	//EISAGEI TA NEA STOIXEIA
	//(TA LAMAVENEI O ELEGXOS GIA EPIKIRWSI DLD TA KALEI EKEI)

	private EntityManager em;


	public TropopoihshEggrafhsService(EntityManager em) {
		super();
		this.em = em;
	}
	

	public void TropopoihshLogariasmou(String afm,String epwnimia,String email,int thlefwno,LocalDate hmeromhniasistashs){
		EntityManager em = JPAUtil.getCurrentEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		LogariasmosEtairias eter = em.find(LogariasmosEtairias.class, afm);
		if(eter!=null){
			eter.setEpwnimia(epwnimia);
			eter.setEmail(email);
			eter.setThlefwno(thlefwno);
			eter.setHmeromhniasistashs(hmeromhniasistashs);
			eter.setExeiElefthei(false);
			eter.setNeedCheck(true);
			em.persist(eter);
			tx.commit();
			em.close();
		}
		
	}
	

	

}
