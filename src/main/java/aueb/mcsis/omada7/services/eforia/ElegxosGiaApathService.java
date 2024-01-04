package aueb.mcsis.omada7.services.eforia;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;

import aueb.mcsis.omada7.domain.eforia.AithmaElegxou;
import aueb.mcsis.omada7.domain.eforia.Dhlwsh;
import aueb.mcsis.omada7.domain.eforia.ElegxosApaths;
import aueb.mcsis.omada7.domain.eforia.Parastatiko;
import aueb.mcsis.omada7.domain.eforia.Trimhno;
import aueb.mcsis.omada7.persistence.eforia.JPAUtil;

public class ElegxosGiaApathService {
	
	private EntityManager em;
	private ElegxosApaths m;
	private Dhlwsh dil;
	
	public ElegxosGiaApathService(EntityManager em) {
		super();
		this.em = em;
	}
	
	public boolean FindElegxosApathsById(int id){
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		try {
			m = em.find(ElegxosApaths.class, id);
			tx.commit();
			return true;
		} catch (NoResultException ex) {
			m = null;
			tx.rollback();
			return false;
		}
	}
	//na to dw .den kanei elegxoi is not mapped
	@SuppressWarnings("unchecked")
	public int ferePosesEggrafes(){
		int poses=0;
		List<AithmaElegxou> l = em.createQuery("select e from ElegxosApaths e").getResultList();
		if(l.size()==0){
			return poses;
		}else{
		return l.size();
		}
	}
	

	//koitaei gia mia dhlwsh ean ekane apath kai thn apothikeuei sth vash ean einai ipopsifia
	//xrhsimopoiei tis parakatw sinarthseis
	public int ipologismosApaths(Dhlwsh a){
		EntityManager em = JPAUtil.getCurrentEntityManager();
		if(tsekareEanEntosXronikouOriou(a)){
				m = new ElegxosApaths(DhmiourgiaProstimou(Ipopsifiaapath(a)),Ipopsifiaapath(a),EinaiApath(Ipopsifiaapath(a)));
			
				EntityTransaction tx = em.getTransaction();
				m.setEnhmerwsheforou(true);
			
				//to testupdateprostimougiathnkathedhlwsh 
				//m.setD(a); me set to test leitourgei kanonika alla xalaei to 46% tou kodika kai den eixame xrono na to ftiaksoume
				tx.begin();
				em.persist(m);
				tx.commit();
				return m.getId();
		}else{
		return 0;}
	}
	
	
	public double Ipopsifiaapath(Dhlwsh a){
		double souma=0;
	
		for(Parastatiko p: a.getParastatika()){
			souma =+ p.PareToPoso(p);
		}
		return souma;
	}
	
	public boolean EinaiApath(double x){
		if(x<-1000){
			return true;
		}else{
			return false;
		}
	}


	public double DhmiourgiaProstimou(double souma){
		return Math.abs(souma*100);
	}
	 
	//h opoia tha tsekarei ean eimaste entos xronikou oriou
	//tsekarei ean exoun perasei oi meres(35) gia na kanei ton elegxo apaths
	//exei merikes deprecated methods
	@SuppressWarnings("deprecation")
	public boolean tsekareEanEntosXronikouOriou(Dhlwsh d){
		Trimhno tr=new Trimhno(d.getSubmissiondate().getMonthValue(), d.getSubmissiondate().getYear(), d.getSubmissiondate().getDayOfMonth());
		if(tr.paremeres()>=35){
			
			return true;
		}else{
			
		return false;}
		
	}
	

	
}
