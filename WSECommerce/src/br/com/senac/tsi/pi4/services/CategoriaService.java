package br.com.senac.tsi.pi4.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

import br.com.senac.tsi.pi4.Categoria;
import br.com.senac.tsi.pi4.Database;

@Path ("/categoria")
public class CategoriaService {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getProduto() {
		
		List<Categoria> categorias = new ArrayList<Categoria>();
		
		Categoria categoria = null;
		
		try {
			
			Connection conn = Database.get().conn();
			PreparedStatement ps = conn.prepareStatement("select * from categoria");
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				
				categoria = new Categoria();
				categoria.setNomeCategoria(rs.getString("nomeCategoria"));
				categoria.setDescCategoria(rs.getString("DescCategoria"));
				
				categorias.add(categoria);
						
			}
			
		} catch (Exception e){
			return Response.status(500).entity(null).build();
			
		}
		
		if(categoria == null)
			return Response.status(404).entity(categorias).build();
		else
			return Response.status(200).entity(categorias).build();
		}
	
	@GET
	@Path("/{param}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCategoria(@PathParam("param") String categoriaId){
		
		String id = categoriaId;
		Categoria categoria = null;
		
		try {
			
			Connection conn = Database.get().conn();
			PreparedStatement ps = conn.prepareStatement("select * from categoria where idCategoria = ?");
			ps.setInt(1,  Integer.parseInt(id));
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()){
				categoria = new Categoria();
				categoria.setNomeCategoria(rs.getString("nomeCategoria"));
				categoria.setDescCategoria(rs.getString("descCategoria"));
			}
		}catch (Exception e) {
			return Response.status(500).entity(null).build();
		}
		
		if(categoria == null)
			return Response.status(404).entity(categoria).build();
		else
			return Response.status(200).entity(categoria).build();
	}
	
}
