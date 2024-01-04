package aueb.mcsis.omada7.resource.eforia;

import java.util.Date;
import java.util.List;
import aueb.mcsis.omada7.domain.eforia.LogariasmosEtairias;
import aueb.mcsis.omada7.services.eforia.*;

import javax.persistence.EntityManager;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.MediaType;

@Path("Logariasmos")
public class EggrafhResource extends AbstractResource {
	
	@Context
	UriInfo uriInfo;
	
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<LogariasmosEtairias> GirnaToSinoloTwnLogariasmwn(){
		EntityManager em = getEntityManager();
		EgrafhStoSistimaService e= new EgrafhStoSistimaService(em);
		return e.FereEtairiesStoSysthma();
	}
	
	@POST
	@Consumes()
	public void KaneNeaEggraghLogariasmou(LogariasmosEtairias log){
		EntityManager em = getEntityManager();
		EgrafhStoSistimaService e= new EgrafhStoSistimaService(em);
		e.KaneNeaEggrafh(log);			
	}
	
	@GET
	@Path("vres/{afm}")
	@Produces(MediaType.APPLICATION_JSON)
	public LogariasmosEtairias vreseaniparxeitotadeafm(@PathParam("afm") String afm){
		EntityManager em = getEntityManager();
		EgrafhStoSistimaService e= new EgrafhStoSistimaService(em);
		return e.VresEanExeiKsanakataxwrhtheiToAfm(afm);
	}
	
	
}
