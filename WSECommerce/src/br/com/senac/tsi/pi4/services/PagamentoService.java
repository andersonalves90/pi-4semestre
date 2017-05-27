package br.com.senac.tsi.pi4.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.senac.tsi.pi4.Categoria;
import br.com.senac.tsi.pi4.Database;
import br.com.senac.tsi.pi4.Pagamento;

@Path ("/pagamento")
public class PagamentoService {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPagamento(){
		
		List<Pagamento> pagamentos = new ArrayList<Pagamento>();
		
		Pagamento pagamento = null;
		
		try{
			
			Connection conn = Database.get().conn();
			PreparedStatement ps = conn.prepareStatement("select * from TipoPagamento");
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()){
				pagamento = new Pagamento();
				pagamento.setDescTipoPagto("descTipoPagto");
				
				pagamentos.add(pagamento);
			}
			
			
		}catch (Exception e) {
			return Response.status(500).entity(null).build();
		}
		
		if(pagamento == null)
			return Response.status(404).entity(pagamentos).build();
		else
			return Response.status(200).entity(pagamentos).build();
	}

}
