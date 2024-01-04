package aueb.mcsis.omada7.resource.eforia;


import java.time.LocalDate;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import aueb.mcsis.omada7.domain.eforia.Dhlwsh;
import aueb.mcsis.omada7.domain.eforia.LogariasmosEtairias;
import aueb.mcsis.omada7.services.eforia.IpovolhDhlwshsService;
import aueb.mcsis.omada7.services.eforia.TropopoihshDhlwshsService;

@Path("dhlwsh")
public class DhlwshResource extends AbstractResource {

	@GET
	@Path("/{id}")
	@Produces
	public Response GirnaThDwhlwshApoToIDths(@PathParam("id") int id){
		EntityManager em = getEntityManager();
		IpovolhDhlwshsService ipo=new IpovolhDhlwshsService(em);
		if(ipo.VresDhlwshById(id)!=null){
		return Response.ok().build();}
		else{
			return Response.status(205).build();
		}
	}
	
	
	@POST
	@Path("/trimhno/{trimhno}/etairia/{afm}")
	@Produces
	public Response KaneNEaDhlwsh(@PathParam("trimhno") int tri,@PathParam("afm") String afm){
		EntityManager em = getEntityManager();
		IpovolhDhlwshsService ipo=new IpovolhDhlwshsService(em);
		ipo.VresEtairia(afm);
		if(ipo.KaneNeaDhlwsh(tri)!=null){
		
			return Response.ok().build(); }
		else{
			return null;
		}
	}
	
	@POST
	@Path("/{id}/neoparastatiko")
	@Produces
	public Response ValeNeoParastatiko(@PathParam("id") int id){
		EntityManager em = getEntityManager();
		IpovolhDhlwshsService ipo=new IpovolhDhlwshsService(em);
		if( ipo.ValeNeoParastatiko(id)){
			return Response.ok().build();
		}else{
			return null;
		}
	}
	
	@GET
	@Path("/{id}/date")
	@Consumes(MediaType.APPLICATION_JSON)
	public boolean KaneTropopoihshDhlwshs(@PathParam("id") int id){
		EntityManager em = getEntityManager();
		TropopoihshDhlwshsService tr=new TropopoihshDhlwshsService(em);
		return tr.TropopoihshDhlwshs(id, LocalDate.now());
	}
	
	@POST
	@Path("/{id}/arpara/{arpar}/poso/{poso}/eidos/{eidos}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response kantropopoihshparastatikou(
			@PathParam("id") int id,
			@PathParam("arpar") int arithmospara,
			@PathParam("poso") double poso,
			@PathParam("eidos") boolean eidos
			){
		EntityManager em = getEntityManager();
		TropopoihshDhlwshsService tr=new TropopoihshDhlwshsService(em);
		boolean sin= tr.TropopoihshParastatikwn(id, arithmospara, poso, eidos);
		if(sin){
			return Response.ok().build() ;		
		}else{
			return null;	
		}
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response tropodhl(Dhlwsh d){
		EntityManager em = getEntityManager();
		TropopoihshDhlwshsService tr=new TropopoihshDhlwshsService(em);
		System.out.println(d.getId());
		boolean ela = tr.troponea(d);
		if(ela){
			return Response.ok().build();
		}else{
			return Response.status(400).build();
		}

	}
	
}
