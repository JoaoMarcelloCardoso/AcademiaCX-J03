package com.demo.academiacx.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "tb_carrinho")

public class CarrinhoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date datetime;
    private double total;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private ClienteModel clienteModel;
    public CarrinhoModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public ClienteModel getClienteModel() {
        return clienteModel;
    }

    public void setClienteModel(ClienteModel clienteModel) {
        this.clienteModel = clienteModel;
    }
}
