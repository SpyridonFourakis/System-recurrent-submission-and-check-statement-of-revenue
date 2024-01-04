package aueb.mcsis.omada7.domain.eforia;


import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;

import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue(value="ElegxosAnantistixiwn")
public class ElegxosAnantistixiwn extends AithmaElegxou {
	
	

	
	@Column
	double diaforaposou;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="dhlwshid")
	public  Dhlwsh d;

	
	
	public ElegxosAnantistixiwn(double diaforaposou) {
		super();
		this.diaforaposou = diaforaposou;
	}
	
	
	
	public ElegxosAnantistixiwn() {
		super();
	}

	

	public double getDiaforaposou() {
		return diaforaposou;
	}

	public void setDiaforaposou(double diaforaposou) {
		this.diaforaposou = diaforaposou;
	}
	
	

	
	@SuppressWarnings("deprecation")
	public boolean tsekareEanEntosXronikouOriou(Dhlwsh d){
		Trimhno tr=new Trimhno(d.getSubmissiondate().getMonthValue(), d.getSubmissiondate().getYear(), d.getSubmissiondate().getDayOfMonth());
		if(tr.paremeres()>30){
			return true;
		}else{
		return false;}
		
	}
	

	
	
}
