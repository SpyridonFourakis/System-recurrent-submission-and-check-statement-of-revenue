package aueb.mcsis.omada7.domain.eforia;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;



public class Trimhno {
	//vohthitikh klash gia na mas dinei to pedio emmprothesmh.kai na kanoume kai allous elegxous
	int year=LocalDate.now().getYear();
	 public  final LocalDate atrimhno = LocalDate.of(year, Month.APRIL, 1);
	 public  final LocalDate atrimhnoarxh = LocalDate.of(year, Month.APRIL, 1);
	 public  final LocalDate atrimhnoperas = LocalDate.of(year, Month.APRIL, 20);
	 public  final LocalDate btrimhno = LocalDate.of(year, Month.JULY, 1);
	 public  final LocalDate btrimhnoarxh = LocalDate.of(year, Month.JULY, 1);
	 public  final LocalDate btrimhnoperas = LocalDate.of(year, Month.JULY, 20);
	 public  final LocalDate gtrimhno = LocalDate.of(year, Month.OCTOBER, 1);
	 public  final LocalDate gtrimhnoarxh = LocalDate.of(year, Month.OCTOBER, 1);
	 public  final LocalDate gtrimhnoperas = LocalDate.of(year, Month.OCTOBER, 20);
	 public  final LocalDate dtrimhno = LocalDate.of(year+1, Month.JANUARY, 1);
	 public  final LocalDate dtrimhnoarxh = LocalDate.of(year+1, Month.JANUARY, 1);
	 public  final LocalDate dtrimhnoperas = LocalDate.of(year+1, Month.JANUARY, 20);
	  LocalDate ela;
	  int mhnas;
	  int etos;
	  int mera;
	  int trimhno;
  
  
  public Trimhno() {
	this.ela = LocalDate.now();
}
  
  public Trimhno(int tri) {
	  this.trimhno = tri;
		this.ela = LocalDate.now();
	}



public Trimhno(int mhnas, int etos, int mera) {
	super();
	this.mhnas = mhnas;
	this.etos = etos;
	this.mera = mera;
	this.ela = LocalDate.of(etos, mhnas, mera);
}


public Trimhno(int trimhno,int mhnas, int etos, int mera) {
	super();
	this.mhnas = mhnas;
	this.etos = etos;
	this.mera = mera;
	this.trimhno=trimhno;
	System.out.println(year+this.etos+this.mhnas+this.mera);
	System.out.println(this.etos);
	System.out.println(this.mhnas);
	System.out.println(this.mera);
	this.ela = LocalDate.of(etos, mhnas, mera);
}


public LocalDate SePioTrimhnoEisai(){
	
	if(ela.getYear()<=LocalDate.now().getYear()){
	if (ela.isBefore(atrimhno) && ela.isAfter(dtrimhno)){
		return dtrimhno;
	}else if (ela.isBefore(btrimhno) && ela.isAfter(atrimhno)) {
		return atrimhno;
	}else if (ela.isAfter(btrimhno) && ela.isBefore(gtrimhno)) {
		return btrimhno;
	}else if (ela.isAfter(gtrimhno) && ela.isBefore(dtrimhno)) {
		return gtrimhno;
	}else{
		return null;
	}
	}
	else{
		return null;
	}
}



public int paremeres(){
	  int days=0;
	  int months=0;
	  if (ela.isBefore(atrimhno)  /*&& ela.isAfter(dtrimhno)*/){
		  Period age = Period.between(atrimhno, ela);
		  days = age.getDays();
		  months = age.getMonths();
	  }else if (ela.isBefore(btrimhno) && ela.isAfter(atrimhno)) {
		  Period age = Period.between(atrimhno, ela);
		  days = age.getDays();
		  months = age.getMonths();
	}else if (ela.isAfter(btrimhno) && ela.isBefore(gtrimhno)) {
		Period age = Period.between(btrimhno, ela);
		  days = age.getDays();
		  months = age.getMonths();
	}else if (ela.isAfter(gtrimhno) && ela.isBefore(dtrimhno)) {
		Period age = Period.between(gtrimhno, ela);
		months = age.getMonths();  
		days = age.getDays();
		  
	}
	  int malakas= months*30+days+1;
	  System.out.println("asdasdasdasd"+malakas);
	  return Math.abs(months*30+days+1);
	  
  }
  

public boolean Einaiemprothesmh(){
	if(trimhno==1 && ela.isAfter(atrimhnoarxh) && ela.isBefore(atrimhnoperas)){
		return true;
	}else if (trimhno==2 && ela.isAfter(btrimhnoarxh) && ela.isBefore(btrimhnoperas)) {
		return true;
	}else if (trimhno==3 && ela.isAfter(gtrimhnoarxh) && ela.isBefore(gtrimhnoperas)) {
		return true;
	}else if (trimhno==4 && ela.isAfter(dtrimhnoarxh) && ela.isBefore(dtrimhnoperas)) {
		return true;
	}else{
		return false;
	}
}

  
}
