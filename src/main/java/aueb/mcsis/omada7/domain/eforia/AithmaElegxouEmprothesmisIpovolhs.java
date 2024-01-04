package aueb.mcsis.omada7.domain.eforia;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue(value="AithmaElegxouEmprothesmisIpovolhs")
public class AithmaElegxouEmprothesmisIpovolhs extends AithmaElegxou {

	final double protimo=500;
	
	
	
	
	@Column
	private	double prostimoekprothesmis;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="dhlwshid")
	public  Dhlwsh d;
	
	
	
	
	public AithmaElegxouEmprothesmisIpovolhs() {
		super();
	}


	public AithmaElegxouEmprothesmisIpovolhs(double prostimoekprothesmis) {
		super();
		this.prostimoekprothesmis = prostimoekprothesmis;
	}

	public double getProstimoekprothesmis() {
		return prostimoekprothesmis;
	}

	public void setProstimoekprothesmis(double prostimoekprothesmis) {
		this.prostimoekprothesmis = prostimoekprothesmis;
	}

	public void ElegkseGiaEkprothesmh(Dhlwsh d){
		Trimhno ela=new Trimhno();
		if (ela.paremeres()>20){
			d.setEmprothesmh(true);
			
		}else{
			d.setEmprothesmh(false);
			updatesinolopros(d);
		}
		}
	
	
	public void updatesinolopros(Dhlwsh d){
		d.setSinoloprostimou(protimo+d.getSinoloprostimou());
	}
	

	
	
	
}
