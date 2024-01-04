package aueb.mcsis.omada7.resource.eforia;

import java.util.List;

import javax.persistence.EntityManager;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import aueb.mcsis.omada7.domain.eforia.LogariasmosEtairias;
import aueb.mcsis.omada7.services.eforia.ElegxosEggrafwnService;

@Path("eforos")
public class EforosResource extends AbstractResource{
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<LogariasmosEtairias>  FereLogGiaElegxo(){
		EntityManager em = getEntityManager();
		ElegxosEggrafwnService e=new ElegxosEggrafwnService(em);
		return e.FerePendingLogariasmous();
	}

	@PUT
	@Consumes()
	public void TropopoihshLogariasmwn(){
		EntityManager em = getEntityManager();
		ElegxosEggrafwnService e=new ElegxosEggrafwnService(em);
		e.TropopoihseKatastashLogariasmwn();
	}
	
}
