package br.com.senac.tsi.pi4.services;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import br.com.senac.tsi.pi4.Cliente;
import br.com.senac.tsi.pi4.Database;

@Path("/Pedido")
public class PedidoService {
	
	@POST	
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	public Response savePedido() {
		
			try {
			
			Connection conn = Database.get().conn();
			PreparedStatement ps = conn.prepareStatement("INSERT INTO pedido VALUES (?, ?, ?, ?, ?, ?,?, ?, ?)");
			
			ps.executeUpdate();
			

		} catch (Exception e) {
			return Response.status(500).entity(null).build();
		}
		
		Gson gson = new Gson ();
		String jsonProduto = gson.toJson("");
		return Response.status(200).entity(jsonProduto).build();
 
	}

}
