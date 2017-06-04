package jumpers.delta.sistemasparainter.net.appdelta.entities;

import java.math.BigDecimal;

/**
 * Created by eliana.aqueiroz on 03/05/2017.
 */

public class Produto {
    private int idProduto;
    private String nomeProduto;
    private String descProduto;
    private BigDecimal precProduto;
    private BigDecimal descPromocao;
    private int idCategoria;
    private int ativoProduto;
    private int idUsuario;
    private int qtdMinEstoque;
    private byte imagem[];

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

    public BigDecimal getPrecProduto() {
        return precProduto;
    }

    public void setPrecProduto(BigDecimal precProduto) {
        this.precProduto = precProduto;
    }

    public BigDecimal getDescPromocao() {
        return descPromocao;
    }

    public void setDescPromocao(BigDecimal descPromocao) {
        this.descPromocao = descPromocao;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public int getAtivoProduto() {
        return ativoProduto;
    }

    public void setAtivoProduto(int ativoProduto) {
        this.ativoProduto = ativoProduto;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getQtdMinEstoque() {
        return qtdMinEstoque;
    }

    public void setQtdMinEstoque(int qtdMinEstoque) {
        this.qtdMinEstoque = qtdMinEstoque;
    }

    public byte[] getImagem() {
        return imagem;
    }

    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }
}