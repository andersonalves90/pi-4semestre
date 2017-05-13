package br.com.senac.tsi.pi4;

import java.math.BigDecimal;

public class Produto {

	private int idProduto;
	private String nomeProduto;
	private String descProduto;
	private float precProduto;
	private BigDecimal descontoPromocao;
	private int idCategoria;
	private int qtdMinEstoque;
	
	public BigDecimal getDescontoPromocao() {
		return descontoPromocao;
	}
	public void setDescontoPromocao(BigDecimal descontoPromocao) {
		this.descontoPromocao = descontoPromocao;
	}
	public int getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}
	public int getQtdMinEstoque() {
		return qtdMinEstoque;
	}
	public void setQtdMinEstoque(int qtdMinEstoque) {
		this.qtdMinEstoque = qtdMinEstoque;
	}
	public int getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}
	public String getNomeProduto() {
		return nomeProduto;
	}
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	public String getDescProduto() {
		return descProduto;
	}
	public void setDescProduto(String descProduto) {
		this.descProduto = descProduto;
	}
	public float getPrecProduto() {
		return precProduto;
	}
	public void setPrecProduto(float precProduto) {
		this.precProduto = precProduto;
	}
	
	
}
