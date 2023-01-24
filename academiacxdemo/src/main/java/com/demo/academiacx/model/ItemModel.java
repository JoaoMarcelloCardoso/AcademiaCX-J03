package com.demo.academiacx.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_item")
public class ItemModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer quantidade;
    private Double total;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private ProdutoModel produtoModel;

    @ManyToOne
    @JoinColumn(name = "preco_id")
    private PrecoModel precoModel;

    @ManyToOne
    @JoinColumn(name = "carrinho_id")
    private CarrinhoModel carrinhoModelModel;

    public ItemModel() {
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public ProdutoModel getProdutoModel() {
        return produtoModel;
    }

    public void setProdutoModel(ProdutoModel produtoModel) {
        this.produtoModel = produtoModel;
    }

    public PrecoModel getPrecoModel() {
        return precoModel;
    }

    public void setPrecoModel(PrecoModel precoModel) {
        this.precoModel = precoModel;
    }

    public CarrinhoModel getCarrinhoModelModel() {
        return carrinhoModelModel;
    }

    public void setCarrinhoModelModel(CarrinhoModel carrinhoModelModel) {
        this.carrinhoModelModel = carrinhoModelModel;
    }
}
