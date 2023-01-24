package com.demo.academiacx.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_preco")
public class PrecoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double valor;



    @ManyToOne
    @JoinColumn(name = "produto_id")
    private ProdutoModel produtoModel;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private ClienteModel clienteModel;

    public PrecoModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public ProdutoModel getProdutoModel() {
        return produtoModel;
    }

    public void setProdutoModel(ProdutoModel produtoModel) {
        this.produtoModel = produtoModel;
    }

    public ClienteModel getClienteModel() {
        return clienteModel;
    }

    public void setClienteModel(ClienteModel clienteModel) {
        this.clienteModel = clienteModel;
    }
}
