package aueb.mcsis.omada7.services.eforia;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import aueb.mcsis.omada7.domain.eforia.LogariasmosEtairias;
import aueb.mcsis.omada7.persistence.eforia.JPAUtil;

public class EgrafhStoSistimaService {
	 // to service auto elexgxei an uparxei allh etairia me to idio afm tik
	 // an to afm einai egkiro kai exoun elex8ei ta stoixeia tote stelnei mnm epitixous eggrafhs tik
	 // kataxwrei thn eggrafh sth vash logariasmoi !!!tik
	 // h arxikopoihsh twnn pediwn prepei na elegthei kai pending einai katallhlh tik
	//diaagrafh etairias den prepei na ginetai kanonika,na menoun ta stoixeia gia panta tik
	private EntityManager em;
	
	
	public EgrafhStoSistimaService(EntityManager em) {
		super();
		this.em = em;
	}
	
	public boolean KaneNeaEggrafh(LogariasmosEtairias e){
		
		
		if((VresEanExeiKsanakataxwrhtheiToAfm(e.getAfm())==null) && e!=null && EgirosAfm(e)){
			EntityManager em = JPAUtil.getCurrentEntityManager();
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			// vazei ena antikeimeno sthn vash
			em.persist(e);
			tx.commit();
			return true;
		}
		else
		{
			return false;
		}
		
}
	

	public LogariasmosEtairias VresEanExeiKsanakataxwrhtheiToAfm(String afm){
		EntityManager em = JPAUtil.getCurrentEntityManager();
		return em.find(LogariasmosEtairias.class,afm);
		
	}
	
	public boolean EgirosAfm(LogariasmosEtairias e){
		  char[] afm;
	        double count=0;
	        double digit,finalNum=0;
	        String temp;
	        afm=e.getAfm().toCharArray();

	        for(int i=afm.length;i>=1;i--){
	            if(count!=0){
	            temp=String.valueOf(afm[i-1]);
	            digit=Integer.parseInt(temp);
	           finalNum=finalNum+digit*Math.pow(2,count);
	            }
	           count++;
	        }

	        temp=String.valueOf(afm[afm.length-1]);
	        digit=Integer.parseInt(temp);

	        if(((finalNum%11)%10)==digit){
	           return true;
	        }
	        else {return false;	}
	        
	}
	@SuppressWarnings("unchecked")
	public int FerePosoiEinaiStoSysthma(){
		int size=0;
		EntityManager em = JPAUtil.getCurrentEntityManager();
		List<LogariasmosEtairias> l = em.createQuery("select e from LogariasmosEtairias e").getResultList();
		if(l.isEmpty()){
			return size;
		}else{
			return l.size();
		}
	}
	
	
	@SuppressWarnings("unchecked")
	public List<LogariasmosEtairias> FereEtairiesStoSysthma(){
		EntityManager em = JPAUtil.getCurrentEntityManager();
		List<LogariasmosEtairias> l = em.createQuery("select e from LogariasmosEtairias e").getResultList();
		return l;
		
	}
	
	
}
