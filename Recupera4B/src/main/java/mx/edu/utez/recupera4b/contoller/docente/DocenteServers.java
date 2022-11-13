package mx.edu.utez.recupera4b.contoller.docente;

import mx.edu.utez.recupera4b.model.docente.BeanDocente;
import mx.edu.utez.recupera4b.model.docente.DaoDocente;
import mx.edu.utez.recupera4b.utils.Response;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Path("/api/docentes")
public class DocenteServers {

    Map<String, Object> response = new HashMap<>();

    @GET
    @Path("/")
    @Produces(value = {"application/json"})
    public List<BeanDocente> getAll(){
        return new DaoDocente().findAll();
    }

    @PUT
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> update(BeanDocente docente){
        System.out.println(docente.getNombre());
        Response<BeanDocente> result = new DaoDocente().update(docente);
        response.put("result", result);
        return response;
    }

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> save(BeanDocente docente){
        System.out.println(docente.getNombre());
        Response<BeanDocente> result = new DaoDocente().save(docente);
        response.put("result", result);
        return response;
    }

}
