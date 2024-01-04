package aueb.mcsis.omada7.services.eforia;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import aueb.mcsis.omada7.domain.eforia.ElegxosAnantistixiwn;
import aueb.mcsis.omada7.domain.eforia.ElegxosApaths;
import aueb.mcsis.omada7.persistence.eforia.JPAUtil;

public class EpivolhProstimouService {
	
	private EntityManager em;

	public EpivolhProstimouService(EntityManager em) {
		super();
		this.em = em;
	}

	
	//o eforos paei ston elegxo anantistoixeiwn kai fernei tis eggrafes gia na tis dei o eforos
	@SuppressWarnings("unchecked")
	public List<ElegxosAnantistixiwn> FereTisAnantistoixies(){
		List<ElegxosAnantistixiwn> l=null;
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		l=em.createQuery("select e from ElegxosAnantistixiwn e").getResultList();
		return l; 
	}
	
	//koitaei kai tis apates 
	
	@SuppressWarnings("unchecked")
	public List<ElegxosApaths> FereTisApates(){
		List<ElegxosApaths> l=null;
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		l=em.createQuery("select e from ElegxosApaths e").getResultList();
		return l; 
	}
	
	
	
	//enhmerwnei ta sinolika prostima epixeirhsewvn
	public boolean updateSinolikoProstimoGiathnkatheDhlwsh(){
		boolean a=false;
		List<ElegxosApaths> listaapatwn=FereTisApates();
		
		for(ElegxosApaths e:listaapatwn){
			//na dei ean hrthe h wra na tou epivalei to prostimo
			
			if(e.isEnhmerwsheforou()){
				//den exei parei ton deikth ths dhlwshs
			e.getD().setSinoloprostimou(e.getD().getSinoloprostimou()+e.getProstimo());
			//prepei na to valoume kai sthn vash
			EntityTransaction tx = em.getTransaction();
			//tx.begin();
			em.merge(e.getD());
			tx.commit();
			}		
			a=true;
		}
		return a;
	}
	
	
}