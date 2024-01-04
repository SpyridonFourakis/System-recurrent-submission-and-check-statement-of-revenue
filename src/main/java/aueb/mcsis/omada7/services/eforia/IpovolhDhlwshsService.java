package aueb.mcsis.omada7.services.eforia;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import aueb.mcsis.omada7.domain.eforia.Dhlwsh;
import aueb.mcsis.omada7.domain.eforia.LogariasmosEtairias;
import aueb.mcsis.omada7.domain.eforia.Parastatiko;


public class IpovolhDhlwshsService {
	// koitaei sto logariasmo me  afm ean mporei na kanei dhlwsh
	// kanei dhlwsh 
	// psaxnei gia dhlwsh me id
	//vazei neo parastatiko
	//diagrafh den exw valei gia na mhn feugoun pote ta stoixeia.
	
	private EntityManager em;
	private LogariasmosEtairias etairia;
	private Parastatiko para;
	
	
	
	public IpovolhDhlwshsService(EntityManager em) {
		super();
		this.em = em;
	}
	
	
	
	//elegxei ean  iparxei etairia
	public LogariasmosEtairias VresEtairia(String  afm){
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		try{
			etairia=em.find(LogariasmosEtairias.class, afm);
			tx.commit();
			return etairia;
		}catch(NoResultException e){
			return null;
		}
	}
	
	//pragmnatopoiei th dhlwsh
	public Dhlwsh KaneNeaDhlwsh(int trimhno){
		Dhlwsh d=null;
		if(etairia!=null){
			
			//na valoume to mporei na kanei dilosi apo tin klasi 
			//logariasmos etairias allios tsaba ftiaxtike
		if (etairia.isExeiElefthei() && !etairia.isNeedCheck() ){
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			d=new Dhlwsh();
			d.setTrimhno(trimhno);
			d.setSinoloprostimou(0);
			d.setSubmissiondate(LocalDate.now());
			em.persist(d);
			tx.commit();
			
		}
		}
		
		return d ;
	}
	//vriskei mia dhlwsh me to id
	public Dhlwsh VresDhlwshById(int id ){
		Dhlwsh d;
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		try {
			d = em.find(Dhlwsh.class, id);
			tx.commit();
		} catch (NoResultException ex) {
			d = null;
			tx.rollback();
		}
		return d;
	}
	
	
	//prepei na to doume
	//vazoume kai ta parastatika afou exoume kanei nea dhlwsh
	public boolean ValeNeoParastatiko(int did/*,String afmsimba,int arpara,boolean eidos,double poso,Date a*/){
		
		Dhlwsh d=VresDhlwshById(did);
		if(d==null){
			return false;
		}else{
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			para=new Parastatiko("", 135, true, 10000, LocalDate.now());
			// arxikopoihsh tou parastaikou diamorfwsh antikeimenou para.
			em.persist(para);
			tx.commit();
			return true;
		}
		//metaa vazei sth dhlwsh to kataallhlo parastatiko.
	
	} 
	 @SuppressWarnings("unchecked")
	public int fereArithmoDhlwsewn(){
		int ar=0;
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		List<Dhlwsh> l= em.createQuery("select d from Dhlwsh d").getResultList();
		if(l.size()!=0){
			return l.size();
		}else{
			return ar;
		}
	}
	@SuppressWarnings("unchecked")
	 public int fereTaParastatika(){
		 int a=0;
		 EntityTransaction tx = em.getTransaction();
			tx.begin();
			List<Parastatiko> l= em.createQuery("select d from Parastatiko d").getResultList();
			if(l.size()!=0){
				return l.size();
			}else{
				return a;
			}
	 }
	
	
	
	
	
	
}
