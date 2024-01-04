package aueb.mcsis.omada7.domain.eforia;
import org.junit.*;

import java.time.LocalDate;



public class ParastatikoTest {

	
	@Test
	public void pareToPosoTest(){
		Parastatiko p = new Parastatiko();
		p.setEidossinallaghs(true);
		p.setPoso(1);
		p.setId(1);
		p.setAfmsimvalwmenoou("123456789");
		p.setArithmosparastatikou(1);
		 LocalDate a=  LocalDate.now();
p.setHmeromhniaparastatikou(a);
Assert.assertEquals(p.getAfmsimvalwmenoou(),"123456789");
		Assert.assertTrue(p.isEidossinallaghs()&& p.getPoso() > 0 &&  p.PareToPoso(p) > 0);
	}
	
	@Test
	public void pareToPosoArnitikoTest(){
		Parastatiko p = new Parastatiko();
		p.setEidossinallaghs(false);
		p.setPoso(1);
		
		Assert.assertFalse(p.PareToPoso(p)<0 && (p.getPoso() < 0) && (p.isEidossinallaghs()));
	}
	
	@Test
	public void pareToPosoNullTest(){
		Parastatiko p = new Parastatiko();
		Assert.assertTrue(p.getPoso()==0 && p.PareToPoso(p)==0);
	}
	
	@Test
	public void miscellaniousTest(){
		LocalDate a = LocalDate.now();
		Parastatiko p= new Parastatiko("987654322" ,3,true ,300000 ,a);
		p.setId(20);
		Assert.assertEquals(20,p.getId());
		Assert.assertEquals(3,p.getArithmosparastatikou());
		Assert.assertEquals(a,p.getHmeromhniaparastatikou());
		Assert.assertEquals(-1434666362,p.hashCode());
		
			
	}

		@Test
		public void testEquals(){
		LocalDate a = LocalDate.now();
		Parastatiko p1= new Parastatiko("987654322" ,1234,true ,300000 ,a);
		Parastatiko p2= new Parastatiko("987654323" ,2341,true ,250000 ,a);
		Parastatiko p3= null;

		Assert.assertTrue(p1.equals(p1));
		Assert.assertTrue(p1.equals(p2));
		Assert.assertFalse(p1.equals(p3));
		Assert.assertFalse(p1.equals(a));
		
		
}
    
}