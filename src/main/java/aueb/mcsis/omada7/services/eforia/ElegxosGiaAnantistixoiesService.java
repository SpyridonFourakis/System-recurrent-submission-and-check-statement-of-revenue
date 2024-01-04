package aueb.mcsis.omada7.services.eforia;

import java.util.HashSet;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import aueb.mcsis.omada7.domain.eforia.AithmaElegxou;
import aueb.mcsis.omada7.domain.eforia.Dhlwsh;
import aueb.mcsis.omada7.domain.eforia.ElegxosAnantistixiwn;
import aueb.mcsis.omada7.domain.eforia.Parastatiko;

public class ElegxosGiaAnantistixoiesService {
		
	private EntityManager em;

	
		public ElegxosGiaAnantistixoiesService(EntityManager em) {
			super();
			this.em = em;
		}
	    
		
		//prepei na fernei  oles tis dhlwseis h mono autes pou aforoun to trexon trimhno?
		@SuppressWarnings("unchecked")
		public List<Dhlwsh> findAllDhlwseis(){
			List<Dhlwsh> d=null;
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			d=em.
					createQuery("select d from Dhlwsh d").getResultList();
			tx.commit();
			return d;
		}
		//
		//exoume lista me dhlwseis,tsekarei oles tis dhlwseis analitika gia anantistoixies
		public void elegxosAnantistoixiwn(){
			List<Dhlwsh> d=findAllDhlwseis();
			System.out.println(d.size());
			for(Dhlwsh dilo:d){
				for (Parastatiko p:dilo.getParastatika()){
					String afmtolook=p.getAfmsimvalwmenoou();
					int parastatikotollok=p.getArithmosparastatikou();
					double prwto=p.getPoso();
					System.out.println(afmtolook);
					for(Dhlwsh dilosi:d){
						if(dilosi.getEtairia().getAfm()==afmtolook){
							for (Parastatiko para:dilosi.getParastatika()){
								if(para.getArithmosparastatikou()==parastatikotollok){
									KaneEisagwghSthBash(prwto-para.getPoso());
								}
							}
						}
					}
				}
			}
		}
		
		//fernei apo ton pinaka elegxosana tis anantistoixies
		@SuppressWarnings("unchecked")
		public List<AithmaElegxou> girnaTisAnantistoixies(){
			List<AithmaElegxou> results1 = null;
			results1 = em.createQuery("select e from ElegxosAnantistixiwn e").getResultList();
			return results1;
		}
		
		
		//tsekarei ean prepein an thewrhthei anantistoixia to poso pou ipologizetai
		public boolean EinaiAnantistoixia(double x){
			if (x!=0){
				return true;
			}else{
			return false;}
			
		}
		
		// vazei ta dedomena apo ton elegxo sth vash elegxoi anantistoixiwn.
		public void KaneEisagwghSthBash(double teliko){
			if(EinaiAnantistoixia(teliko)){
				ElegxosAnantistixiwn e=new ElegxosAnantistixiwn(teliko);
				// mas afhnei kai peritherio tropopoihsewn
				e.setDinatothtatropo(true);
				EntityTransaction tx = em.getTransaction();
				tx.begin();
				em.persist(e);
				tx.commit();
				
			}
		}
		
}
