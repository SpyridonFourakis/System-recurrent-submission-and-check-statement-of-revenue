package aueb.mcsis.omada7.domain.eforia;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name = "Dhlwsh")
public class Dhlwsh {
	
	@OneToMany(cascade={CascadeType.PERSIST, CascadeType.MERGE}, 
	            mappedBy="d", fetch=FetchType.LAZY)
	private Set<Parastatiko> parastatika = new HashSet<Parastatiko>();
	
	@Id
	@Column(name="dhlwshid")
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	
	@Column
	int trimhno;
	
	@Column()
	LocalDate submissiondate;
	
	@Column()
	double sinoloprostimou;
	
	@Column()
	boolean emprothesmh;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="afmprwteuontos")
	
	private LogariasmosEtairias etairia;
	
	@OneToOne(fetch=FetchType.LAZY)
	private ElegxosApaths ea;
	
	@OneToOne(fetch=FetchType.LAZY)
	private ElegxosAnantistixiwn mm;
	
	@OneToOne(fetch=FetchType.LAZY)
	private AithmaElegxouEmprothesmisIpovolhs empr;
	
	
	public Dhlwsh() {
		super();
	}


	public Dhlwsh(int trimhno,LocalDate submissiondate, double sinoloprostimou, boolean emprothesmh) {
		super();
		this.trimhno = trimhno;
		this.submissiondate = submissiondate;
		this.sinoloprostimou = sinoloprostimou;
		this.emprothesmh = emprothesmh;
	}


	public int getTrimhno() {
		return trimhno;
	}


	public void setTrimhno(int trimhno) {
		this.trimhno = trimhno;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public LocalDate getSubmissiondate() {
		return submissiondate;
	}


	public void setSubmissiondate(LocalDate submissiondate) {
		this.submissiondate = submissiondate;
	}


	public double getSinoloprostimou() {
		return sinoloprostimou;
	}


	public void setSinoloprostimou(double sinoloprostimou) {
		this.sinoloprostimou = sinoloprostimou;
	}


	public boolean isEmprothesmh() {
		return emprothesmh;
	}


	public void setEmprothesmh(boolean emprothesmh) {
		this.emprothesmh = emprothesmh;
	}

	
	
	//den exoume valei setter gia na mhn mporei kapoios na peiraksei ena parastatiko
	public HashSet<Parastatiko> getParastatika() {
		return new HashSet<Parastatiko>(parastatika);
	}


	//no setter gia na mhn mporei kapoios na peiraksei thn etairia
	public LogariasmosEtairias getEtairia() {
		return etairia;
	}

	public void setLogarismosEtairias( LogariasmosEtairias etairia){
		this.etairia=etairia;
		
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		return true; 
	}
	
	
	public boolean MporeiNaKaneiTropopoihsh(LogariasmosEtairias etairia){
		if (etairia.isExeiElefthei()){
			return true;
		}else{
			return false;
		}
	}

//	public void EisagwghNeasDhlwshs(int tri, Date submissiondate, double sinoloprostimou, boolean emprothesmh){
//		new Dhlwsh(tri,submissiondate,sinoloprostimou,emprothesmh);
//	}
	
	
	
	//metraei ta parastatika pou exei katathesei sthn kathe tou dhlwsh h x etairia
	public int SinoloParastatikwn(){
		return parastatika.size();
	}
	
	//eisagei neo parastatiko
	public void addParastatiko(Parastatiko p){
		if(p!=null){
			parastatika.add(p);
		}
	}


	

}
