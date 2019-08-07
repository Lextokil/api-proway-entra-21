package br.com.proway.api.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.proway.api.dao.ChamadoDAO;
import br.com.proway.api.model.Chamado;
import br.com.proway.api.model.util.Status;

@Path("chamados")
public class ChamadoController {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/")
	public List<Chamado> listChamados() {
		try {
			ChamadoDAO chamadoDAO = new ChamadoDAO();
			return chamadoDAO.listar();

		} catch (SQLException | ClassNotFoundException ex) {
			Logger.getLogger(ChamadoController.class.getName()).log(Level.SEVERE, null, ex);
			throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}/")
	public Chamado getChamado(@PathParam("id") long id) {
		Chamado c1 = new Chamado();
		c1.setId(id);
		c1.setAssunto("Assunto" + id);
		c1.setMensagem("Mensagem" + id);
		c1.setStatus(Status.NOVO);

		return c1;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/")
	public Response create(Chamado chamado) {
		System.out.println(chamado.toString());
		return Response.status(Response.Status.OK).build();
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/")
	public Response update(Chamado chamado) {
		System.out.println(chamado.toString());
		return Response.status(Response.Status.OK).build();
	}

	@DELETE
	@Path("{id}/")
	public Response delete(@PathParam("id") long id) {
		System.out.println("Deletando ID: " + id);
		return Response.status(Response.Status.OK).build();
	}
}
