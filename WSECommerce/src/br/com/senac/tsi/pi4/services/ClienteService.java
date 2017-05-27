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

import com.google.gson.Gson;

import br.com.senac.tsi.pi4.Cliente;
import br.com.senac.tsi.pi4.Database;
import br.com.senac.tsi.pi4.Produto;


@Path ("/cliente")
public class ClienteService {
	
	@GET
	@Path("/{email}/{senha}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response loginCliente(
			@PathParam("email") String email, 
			@PathParam("senha") String senha) {
		
		String emailRequest = email;
		String senhaRequest = senha;
		Boolean login = false;
		
		try {
			
			Connection conn = Database.get().conn();
			PreparedStatement ps = conn.prepareStatement("select * from cliente where emailCliente = ? and senhaCliente = ?");
			ps.setString(1, emailRequest);
			ps.setString(2, senhaRequest);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()){
				login = true;
			}
			

		} catch (Exception e) {
			return Response.status(500).entity(null).build();
		}
		
		if (login == false)
			return Response.status(203).entity(login).build();
		else
			return Response.status(200).entity(login).build();
		
	}
	
	@POST	
	//@Consumes(MediaType.APPLICATION_JSON)
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	public Response saveCliente(Cliente cliente) {
		
			try {
			
			Connection conn = Database.get().conn();
			PreparedStatement ps = conn.prepareStatement("INSERT INTO CLIENTE VALUES (?, ?, ?, ?, ?, ?,?, ?, ?)");
			
			ps.setString(1, cliente.getNomeCompletoCliente());
			ps.setString(2, cliente.getEmailCliente());
			ps.setString(3, cliente.getSenhaCliente());
			ps.setString(4, cliente.getCPFCliente());
			ps.setString(5, cliente.getCelularCliente());
			ps.setString(6, cliente.getTelComercialCliente());
			ps.setString(7, cliente.getTelResidencialCliente());
			ps.setString(8, cliente.getDtNascCliente());
			ps.setByte(9, cliente.getRecebeNewsLetter());
			
			ps.executeUpdate();
			

		} catch (Exception e) {
			return Response.status(500).entity(null).build();
		}
		
		System.out.println("Param1 "+cliente.getNomeCompletoCliente());
		
		Gson gson = new Gson ();
		String jsonProduto = gson.toJson(cliente);
		return Response.status(200).entity(jsonProduto).build();
 
	}
		
			
	}

