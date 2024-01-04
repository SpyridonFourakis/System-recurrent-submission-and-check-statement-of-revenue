package aueb.mcsis.omada7.domain.eforia;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="AithmaElegxou")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type",
discriminatorType = DiscriminatorType.STRING
)

public  class AithmaElegxou {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	
	@Column(nullable = false, unique = true)
	boolean oloklhrwshelegxwn;
	
	@Column(nullable = false, unique = true)
	boolean enhmerwsheforou;
	
	@Column(nullable = false, unique = true)
	boolean dinatothtatropo;

		
	
	



	public AithmaElegxou() {
		super();
	}

	

	public AithmaElegxou(boolean oloklhrwshelegxwn, boolean enhmerwsheforou, boolean dinatothtatropo) {
		super();
		this.oloklhrwshelegxwn = oloklhrwshelegxwn;
		this.enhmerwsheforou = enhmerwsheforou;
		this.dinatothtatropo = dinatothtatropo;
	}



	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public boolean isOloklhrwshelegxwn() {
		return oloklhrwshelegxwn;
	}


	public void setOloklhrwshelegxwn(boolean oloklhrwshelegxwn) {
		this.oloklhrwshelegxwn = oloklhrwshelegxwn;
	}


	public boolean isEnhmerwsheforou() {
		return enhmerwsheforou;
	}


	public void setEnhmerwsheforou(boolean enhmerwsheforou) {
		this.enhmerwsheforou = enhmerwsheforou;
	}


	public boolean isDinatothtatropo() {
		return dinatothtatropo;
	}


	public void setDinatothtatropo(boolean dinatothtatropo) {
		this.dinatothtatropo = dinatothtatropo;
	}



	
	
	
	
	

}
