package aueb.mcsis.omada7.domain.eforia;



import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;




@XmlRootElement

@Entity
@Table(name = "LogariasmosEtairias")
public class LogariasmosEtairias  {
	
	
	@OneToMany(mappedBy="etairia")
	private Set<Dhlwsh> dhlwseis = new HashSet<Dhlwsh>();
	//id na figei otan einai aktallhlh h sinthikh

	@Column(name="logid")
	int id;
	
	@Column(name="epwnimia")
	private String epwnimia;
	
	@Column(name="hmeromhniasistashs")
	private LocalDate hmeromhniasistashs;
	
	@Id
	@Column(name="afmprwteuontos",nullable = false, unique = true)
	private String afm;
	
	@Column(name="email")
	private String email;
	
	@Column(name="thlefwno")
	private int thlefwno;
	
	//if it's true then eforos has done the check.when false then they can submit the statement
	
	@Column(name="elegxos")
	private boolean exeiElefthei;
	
	//eforos must check thhis logarriasmos.
	
	@Column(name="theleielegxo")
	private boolean needCheck;
	
	
	public LogariasmosEtairias() {
		super();
	}
	

	
	public LogariasmosEtairias(int id, String epwnimia, LocalDate hmeromhniasistashs, String afm, String email, int thlefwno,
			boolean exeiElefthei, boolean needCheck) {
		super();
		this.id = id;
		this.epwnimia = epwnimia;
		this.hmeromhniasistashs = hmeromhniasistashs;
		this.afm = afm;
		this.email = email;
		this.thlefwno = thlefwno;
		this.exeiElefthei = exeiElefthei;
		this.needCheck = needCheck;
	}


	public Set<Dhlwsh> getDhlwseis() {
		return dhlwseis;
	}



	public void setDhlwseis(Set<Dhlwsh> dhlwseis) {
		this.dhlwseis = dhlwseis;
	}



	public boolean isExeiElefthei() {
		return exeiElefthei;
	}



	public void setExeiElefthei(boolean exeiElefthei) {
		this.exeiElefthei = exeiElefthei;
	}




	public boolean isNeedCheck() {
		return needCheck;
	}

	public void setNeedCheck(boolean needCheck) {
		this.needCheck = needCheck;
	}


	public String getEpwnimia() {
		return epwnimia;
	}
	public void setEpwnimia(String epwnimia) {
		this.epwnimia = epwnimia;
	}
	
	public LocalDate getHmeromhniasistashs() {
		return hmeromhniasistashs;
	}
	public void setHmeromhniasistashs(LocalDate hmeromhniasistashs) {
		this.hmeromhniasistashs = hmeromhniasistashs;
	}
	
	public String getAfm() {
		return afm;
	}
	public void setAfm(String afm) {
		this.afm = afm;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getThlefwno() {
		return thlefwno;
	}
	public void setThlefwno(int thlefwno) {
		this.thlefwno = thlefwno;
	}


	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((afm == null) ? 0 : afm.hashCode());
		result = prime * result + ((dhlwseis == null) ? 0 : dhlwseis.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((epwnimia == null) ? 0 : epwnimia.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LogariasmosEtairias other = (LogariasmosEtairias) obj;
		if (afm == null) {
			if (other.afm != null)
				return false;
		} else if (!afm.equals(other.afm))
			return false;
		if (dhlwseis == null) {
			if (other.dhlwseis != null)
				return false;
		} else if (!dhlwseis.equals(other.dhlwseis))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (epwnimia == null) {
			if (other.epwnimia != null)
				return false;
		} else if (!epwnimia.equals(other.epwnimia))
			return false;
		return true;
	}


	public boolean MporeiNaKaneiDhlwsh(LogariasmosEtairias e ){
		
		if (e.exeiElefthei && !e.needCheck){
			return true;
		}
		return false;
	}
	
	
	public boolean isValidAfm(LogariasmosEtairias e){
		if(e.getAfm().length()>9){
			System.out.println("den einai egiros arithmos");
			return false;
		}
		else{
			return true;
		}
	}
	

	
	//na vazei mesa sto set dhlwsewn mia kainourgia eggrafh dhlwshs gia thn etairia
	public void addDhlwsh(Dhlwsh d){
		if (d!= null){
			dhlwseis.add(d);
		}
		
	}
	
	
}
