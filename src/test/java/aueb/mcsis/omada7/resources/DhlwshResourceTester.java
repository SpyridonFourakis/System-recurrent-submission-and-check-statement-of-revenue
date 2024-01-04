package aueb.mcsis.omada7.resources;

import java.time.LocalDate;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;

import javax.ws.rs.core.Response;

import javax.ws.rs.core.MediaType;
import org.glassfish.jersey.server.ResourceConfig;
import org.junit.Assert;
import org.junit.Test;
import aueb.mcsis.omada7.domain.eforia.Dhlwsh;
import aueb.mcsis.omada7.domain.eforia.Parastatiko;
import aueb.mcsis.omada7.persistence.eforia.JPAUtil;
import aueb.mcsis.omada7.resource.eforia.DhlwshResource;



public class DhlwshResourceTester extends EforiaResourceTest {

	@Override
	protected Application configure() {
		return new ResourceConfig(DhlwshResource.class);
	}
	
	
	@Test
	//exei kapoio lathos
	public void vresDhlwshapoIdTester(){
		List<Dhlwsh> l =fereOlestisDhlwseis();
		Response r= target("dhlwsh/"+l.get(0).getId()).request().get();
		Assert.assertEquals(200, r.getStatus());
		Response r1= target("dhlwsh/500").request().get();
		Assert.assertEquals(205, r1.getStatus());
		
	}
	
	
	
	@Test
	public void kaneneadhlwshtester(){
		Response r= target("dhlwsh/trimhno/3/etairia/987654322").request().post(null);
		//metra twra tis dhwlseis na einai 4 prepei afou evlaes nea dhlwsh
		Assert.assertEquals(4, fereOlestisDhlwseis().size());
		
	}
	
	
	@Test
	public void valeNeoParastatiko(){
		List<Dhlwsh> l =fereOlestisDhlwseis();
		Response b=target("dhlwsh/"+l.get(0).getId()+"/neoparastatiko").request().post(null);
		System.out.println(b);
		Assert.assertEquals(10, fereTaParastatika().size());
	}
	
	@Test
	public void kanetropopoihshdhlwshsTester(){
		List<Dhlwsh> l =fereOlestisDhlwseis();
		Response r=target("dhlwsh/"+l.get(0).getId()+"/date").request().get();
		Assert.assertEquals(200,r.getStatus());
	}
	
	
	@Test
	public void kanetropopoihshparastatikou(){
		EntityManager em = JPAUtil.getCurrentEntityManager();
		LocalDate a = LocalDate.now();
		Dhlwsh d1 = new Dhlwsh(3,a,0 ,true);
		Parastatiko p1= new Parastatiko("987654322" ,1234,true ,300000 ,a);
		p1.setD(d1);
        EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(d1);
		em.persist(p1);
		tx.commit();
		//prepei na valw kapoia stoixeia mesa mia dhwlsh kai ena parastatiko
		Response r=target("dhlwsh/"+d1.getId()+"/arpara/1234/poso/600/eidos/false").request().post(null);
		Assert.assertEquals(200, r.getStatus());
		
		
	}
	
	@Test
	public void tropoTest(){
		List<Dhlwsh> l =fereOlestisDhlwseis();
		System.out.println(l.get(0).getId()+"apo tester");
		Dhlwsh d = new Dhlwsh(1, l.get(0).getSubmissiondate(), 1000000, true);
		d.setId(l.get(0).getId());
		Response r =target("dhlwsh").request().post(Entity.entity(d,MediaType.APPLICATION_JSON));
		Assert.assertEquals(200, r.getStatus());
	}

	
}
