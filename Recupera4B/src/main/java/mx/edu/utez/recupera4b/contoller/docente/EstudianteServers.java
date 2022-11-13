package mx.edu.utez.recupera4b.contoller.docente;

import mx.edu.utez.recupera4b.model.estudiante.BeanEstudiante;
import mx.edu.utez.recupera4b.model.estudiante.DaoEstudiante;
import mx.edu.utez.recupera4b.utils.Response;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Path("/api/estudiantes")
public class EstudianteServers {
    Map<String, Object> response = new HashMap<>();
    @GET
    @Path("/")
    @Produces(value = {"application/json"})
    public List<BeanEstudiante> getAll(){
        return new DaoEstudiante().findAll();
    }


    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> save(BeanEstudiante estudiante){
        System.out.println(estudiante.getNombre());
        Response<BeanEstudiante> result = new DaoEstudiante().save(estudiante);
        response.put("result", result);
        return response;
    }

    @PUT
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> update(BeanEstudiante estudiante){
        System.out.println(estudiante.getNombre());
        Response<BeanEstudiante> result = new DaoEstudiante().update(estudiante);
        response.put("result", result);
        return response;
    }

}
