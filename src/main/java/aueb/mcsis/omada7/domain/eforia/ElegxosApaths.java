package aueb.mcsis.omada7.domain.eforia;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue(value="ElegxosApaths")
public class ElegxosApaths extends AithmaElegxou {
	
	

	@Column
	double prostimo;
	@Column
	double soumaesodwneskodwn;
	@Column
	boolean apath;
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="dhlwshid")
	private  Dhlwsh d;
	
	
	
public ElegxosApaths() {
		super();
	}



public ElegxosApaths(double prostimo, double soumaesodwneskodwn, boolean apath) {
	super();
	this.prostimo = prostimo;
	this.soumaesodwneskodwn = soumaesodwneskodwn;
	this.apath = apath;
}




//sinoliko poso exodown-esodwn diafora <<0 episterfei boolean apath kai ekxorei sth vadh apati
	//apo mian dhlwsh athroizei ola ta parastatika kai vgazei to sum
	
	public double getProstimo() {
	return prostimo;
}



public void setProstimo(double prostimo) {
	this.prostimo = prostimo;
}



public double getSoumaesodwneskodwn() {
	return soumaesodwneskodwn;
}



public void setSoumaesodwneskodwn(double soumaesodwneskodwn) {
	this.soumaesodwneskodwn = soumaesodwneskodwn;
}



public boolean isApath() {
	return apath;
}



public void setApath(boolean apath) {
	this.apath = apath;
}





public Dhlwsh getD() {
	return d;
}



public void setD(Dhlwsh d) {
	this.d = d;
}




@SuppressWarnings("deprecation")
public boolean ElegkseAnPerasan35Meres(Dhlwsh d){
	Trimhno tr=new Trimhno(d.getTrimhno(), d.getSubmissiondate().getMonthValue(),d.getSubmissiondate().getYear() , d.getSubmissiondate().getDayOfMonth());
	if(tr.paremeres()>=35){
		System.out.println(tr.paremeres());
		setEnhmerwsheforou(true);
		return true;
	}else{
		return false;
	}
	
}
	
}
