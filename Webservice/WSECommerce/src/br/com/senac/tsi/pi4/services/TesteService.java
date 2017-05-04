package br.com.senac.tsi.pi4.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.senac.tsi.pi4.Database;
import br.com.senac.tsi.pi4.Produto;

import com.google.gson.Gson;

@Path ("/user")
public class TesteService {

	@GET
	@Path("/{param}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getProduto(@PathParam("param") String produtoId) {
		
		String id = produtoId;
		Produto produto = null;
		
		try{
			produto = new Produto();
			produto.setNomeProduto("Prod");
			produto.setDescProduto("Prod");
			produto.setIdProduto(1);
			produto.setPrecProduto(10);
		
		} catch (Exception e) {
			return Response.status(500).entity(null).build();
		}
		
		if (produto == null)
			return Response.status(200).entity(produto).build();
		else
			return Response.status(404).entity(produto).build();
		
	}
		
}

