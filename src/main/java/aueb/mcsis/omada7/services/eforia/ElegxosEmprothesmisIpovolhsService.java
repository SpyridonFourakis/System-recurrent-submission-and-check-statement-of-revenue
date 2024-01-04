package aueb.mcsis.omada7.services.eforia;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import aueb.mcsis.omada7.domain.eforia.AithmaElegxou;
import aueb.mcsis.omada7.domain.eforia.AithmaElegxouEmprothesmisIpovolhs;
import aueb.mcsis.omada7.domain.eforia.Dhlwsh;
import aueb.mcsis.omada7.domain.eforia.Trimhno;

public class ElegxosEmprothesmisIpovolhsService {
	
	//fernei tis dhlwseis pairnei tis hmeromhnies tous 
	//kai enhmerwnei ton pinaka tou gia na dei ean einai emprothesmes.
	private EntityManager em;
	private AithmaElegxouEmprothesmisIpovolhs ait;
	
	
	public ElegxosEmprothesmisIpovolhsService(EntityManager em) {
		super();
		this.em = em;
	}
	//fernei oles tis dhlwseis
	@SuppressWarnings("unchecked")
	public List<Dhlwsh> FereOlesTisDhlwseis(){
		List <Dhlwsh> results =null;
		results=em.createQuery("select d from Dhlwsh d").getResultList();
		return results;
		
		
	}
	//enhmwrwenei poioi mporoun na tropopoihsoun th dhlwsh tous
	@SuppressWarnings("deprecation")
	public int ApothikeusePoioiDikaiountaitropopoihsh(){
		int ar=0;
		List<Dhlwsh> d=FereOlesTisDhlwseis();
		System.out.println(d.size());
		for(Dhlwsh dil:d){
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			if(new Trimhno(dil.getTrimhno(), dil.getSubmissiondate().getMonthValue(), dil.getSubmissiondate().getYear(), dil.getSubmissiondate().getDayOfMonth()).Einaiemprothesmh()){
				ar++;
				ait = new AithmaElegxouEmprothesmisIpovolhs();
				ait.setDinatothtatropo(true);
				ait.setProstimoekprothesmis(0);
				//kai ola auta valta sth vash
				//na vazei kai sth dhlwsh oti htan emprothesmh
				dil.setEmprothesmh(true);
				em.persist(dil);
				tx.commit();	
	
			}else{
				dil.setEmprothesmh(false);
				ait.setProstimoekprothesmis(100);
				ait.updatesinolopros(dil);
				ait.setDinatothtatropo(true);
				em.persist(dil);
				em.persist(ait);
				tx.commit();			
				
			}
				
		}
		return ar;
	}
	
	
	
}
