package wsrest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import dao.TarefaDao;
import model.Tarefa;

@Path("/tarefa")
public class TarefaRest {

    @POST
    @Path("/cadastrar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response cadastrar(Tarefa tarefa){
        TarefaDao dao = new TarefaDao();
        return Response.status(201).entity(dao.salvar(tarefa)).build();
    }

    @GET
    @Path("/listar")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public Response listar(){
        TarefaDao dao = new TarefaDao();
        return Response.status(200).entity(dao.listar()).build();
    }
}
