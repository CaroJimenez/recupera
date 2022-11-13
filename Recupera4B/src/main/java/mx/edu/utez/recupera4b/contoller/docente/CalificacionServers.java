package mx.edu.utez.recupera4b.contoller.docente;

import mx.edu.utez.recupera4b.model.evaluaciones.BeanEvaluaciones;
import mx.edu.utez.recupera4b.model.evaluaciones.DaoEvaluaciones;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Path("/api/calificaciones")
public class CalificacionServers {

    Map<String, Object> response = new HashMap<>();

    @GET
    @Path("/")
    @Produces(value = {"application/json"})
    public List<BeanEvaluaciones> getAll(){
        return new DaoEvaluaciones().findAll();
    }

}
