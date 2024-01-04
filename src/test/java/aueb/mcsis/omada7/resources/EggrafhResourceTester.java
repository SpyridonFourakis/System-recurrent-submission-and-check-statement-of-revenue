package aueb.mcsis.omada7.resources;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Assert;
import org.junit.Test;

import aueb.mcsis.omada7.domain.eforia.LogariasmosEtairias;
import aueb.mcsis.omada7.persistence.eforia.Initializer;
import aueb.mcsis.omada7.resource.eforia.EggrafhResource;

public class EggrafhResourceTester extends EforiaResourceTest {
	
@Override
	protected Application configure() {
		// TODO Auto-generated method stub
		return new ResourceConfig(EggrafhResource.class);
	}




@Test
public void GirnaToSinoloTwnLogariasmwnTest(){
	List<LogariasmosEtairias> x = target("Logariasmos").request().get(new GenericType<List<LogariasmosEtairias>>(){});
	Assert.assertEquals(4, x.size());

}
	@Test
	public void KaneNeaEggLogTest(){
		//ftiaxnw logariasmo
		//ftiaxnw to uri pou prepei na steilw
		// kai koitaw meta ama evale neo logariasmo
		LogariasmosEtairias log=new LogariasmosEtairias(21, "aek", LocalDate.now(), "149187741", "aek@gmail.com", 2015012217, false, true);
		Response response = target("Logariasmos").request().post(Entity.entity(log, MediaType.APPLICATION_JSON));

		Assert.assertEquals(204, response.getStatus());
		List <LogariasmosEtairias> l = FereOlousTousLog();
		Assert.assertEquals(5, l.size());
 	}
	
	
	
	@Test
	public void vreseaniparxeiTester(){

		String afm1="149187741";
		LogariasmosEtairias l=target("Logariasmos/vres/"+afm1).request().get(new GenericType<LogariasmosEtairias>(){});
		Assert.assertEquals(null, l);
		
	}

}
